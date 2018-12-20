package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseStudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */

public class EnterpriseStudentInfoDaoImpl implements EnterpriseStudentInfoDao {
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    boolean flag = false;
    private Connection conn = DruidUtil.getCon();
    //根据学生id 企业id进行查询是否存在该条信息
    @Override
    public boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId) throws Exception{
        String sql = "select * from enterprise_studentinfo where student_id = ? and enterprise_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        pstmt.setInt(2, enterpriseId);
        rs = pstmt.executeQuery();
        if(rs.next()) {
            flag = true;
            return flag;
        }else{
            return flag;
        }
    }
}
