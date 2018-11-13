package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 * //修改教师的基本信息
 */


public class TeacherDaoImpl implements TeacherDao {
    PreparedStatement pstate;
    ResultSet rs;
    boolean flag = false;
    Connection con = DruidUtil.getCon();
    @Override
    public boolean updateTeacherInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try{
            String sql = "update teacherinfo set teacher_account = ?,teacher_name = ?,teacher_tel = ?,teacher_password = ?,email = ?,teacher_college = ?,teacher_sex = ?,teacher_job = ? where teacher_id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,teacherInfo.getTeacherAccount());
            pstate.setString(2,teacherInfo.getTeacherName());
            pstate.setString(3,teacherInfo.getTeacherTel());
            pstate.setString(4,teacherInfo.getTeacherPassword());
            pstate.setString(5,teacherInfo.getEmail());
            pstate.setString(6,teacherInfo.getTeacherCollege());
            pstate.setString(7,teacherInfo.getTeacherSex());
            pstate.setString(8,teacherInfo.getTeacherJob());
            pstate.setInt(9,teacherInfo.getTeacherId());
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
