package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/29
 */


public class EnterpriseDaoImpl implements EnterpriseDao {
    PreparedStatement pstate;
    ResultSet rs;
    boolean flag = false;
    Connection con = DruidUtil.getCon();
//    企业管理员修改企业信息
    @Override
    public boolean updateEnterpriseInfo(EnterpriseInfo enterpriseInfo){
        int rows = 0;
        try{
            String sql = "update enterpriseinfo set enterprise_name = ?,enterprise_password = ?,enterprise_introduce = ?,enterprise_address = ?,enterprise_tel = ?,email = ?,enterprise_manager = ? where enterprise_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setString(1,enterpriseInfo.getEnterpriseName());
            pstate.setString(2,enterpriseInfo.getEnterprisePassword());
            pstate.setString(3,enterpriseInfo.getEnterpriseIntroduce());
            pstate.setString(4,enterpriseInfo.getEnterpriseAddress());
            pstate.setString(5,enterpriseInfo.getEnterpriseTel());
            pstate.setString(6,enterpriseInfo.getEmail());
            pstate.setString(7,enterpriseInfo.getEnterpriseManager());
            pstate.setInt(8,enterpriseInfo.getEnterpriseId());

            rows = pstate.executeUpdate();
            if (rows>0){
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //注册企业信息
    @Override
    public int insertEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        int rows = 0;
        try {
            String sql = "insert into enterpriseinfo(enterprise_id, enterprise_name, enterprise_password, enterprise_introduce, enterprise_address, enterprise_tel, email, enterprise_manager) values(?,?,?,?,?,?,?,?);";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, enterpriseInfo.getEnterpriseId());
            pstate.setString(2, enterpriseInfo.getEnterpriseName());
            pstate.setString(3, enterpriseInfo.getEnterprisePassword());
            pstate.setString(4, enterpriseInfo.getEnterpriseIntroduce());
            pstate.setString(5, enterpriseInfo.getEnterpriseAddress());
            pstate.setString(6, enterpriseInfo.getEnterpriseTel());
            pstate.setString(7, enterpriseInfo.getEmail());
            pstate.setString(8,enterpriseInfo.getEnterpriseManager());
            rows = pstate.executeUpdate();

            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
}
