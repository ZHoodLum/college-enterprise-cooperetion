package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public class AdminDaoImpl implements AdminDao {
    ResultSet rs;
    PreparedStatement pstate;
    boolean flag = false;
    Connection con = DruidUtil.getCon();

    //注册管理员信息
    @Override
    public int insertAdminInfo(AdminInfo adminInfo) {
        int rows = 0;
        try {
            String sql = "insert into admininfo(admin_id, admin_name, admin_password) values(?,?,?)";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, adminInfo.getAdminId());
            pstate.setString(2, adminInfo.getAdminName());
            pstate.setString(3, adminInfo.getAdminPassword());

            rows = pstate.executeUpdate();

            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }

    //修改管理员信息
    @Override
    public boolean updateAdminInfo(AdminInfo adminInfo) {
        int rows = 0;
        try{
            String sql = "update admininfo set admin_id = ?,admin_name = ?,admin_password = ? where id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,adminInfo.getAdminId());
            pstate.setString(2,adminInfo.getAdminName());
            pstate.setString(3,adminInfo.getAdminPassword());
            pstate.setInt(4,adminInfo.getId());
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
}
