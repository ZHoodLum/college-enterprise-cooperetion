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
    public boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        try {
            String sql = "select * from enterprise_studentinfo  where student_id = ? and enterprise_id = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, enterpriseStudentInfo.getStudentId());
            pstmt.setInt(2, enterpriseStudentInfo.getEnterpriseId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
                enterpriseStudentInfo.setStudentId(rs.getInt("student_id"));
                enterpriseStudentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                enterpriseStudentInfo.setId(rs.getInt("id"));
            }
//            DruidUtil.closeConnection(rs,conn,pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
