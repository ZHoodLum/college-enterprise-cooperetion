package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseStudentInfo;
import com.zdy.school.vo.Resumes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */

public class EnterpriseStudentInfoDaoImpl implements EnterpriseStudentInfoDao {
     PreparedStatement pstate;
     ResultSet rs;
     Connection conn = DruidUtil.getCon();
    //根据学生id 企业id进行查询是否存在该条信息
    @Override
    public boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId,int jobId) throws Exception{
        String sql = "select * from enterprise_studentinfo where student_id = ? and enterprise_id = ? and job_id = ?";
        pstate = conn.prepareStatement(sql);
        pstate.setInt(1, studentId);
        pstate.setInt(2, enterpriseId);
        pstate.setInt(3,jobId);
        rs = pstate.executeQuery();
        if(rs.next()) {
            return true;
        }else{
            return false;
        }
    }

    //提交简历信息
    @Override
    public int insertEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        int rows = 0;
        try {
            String sql = "insert into enterprise_studentinfo(enterprise_id,student_id,job_id) values(?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, enterpriseStudentInfo.getEnterpriseId());
            pstate.setInt(2, enterpriseStudentInfo.getStudentId());
            pstate.setInt(3, enterpriseStudentInfo.getJobId());
            rows = pstate.executeUpdate();
            DruidUtil.closeConnection(rs,conn,pstate);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("提交简历信息出现错误！");
        }
        return rows;
    }
}
