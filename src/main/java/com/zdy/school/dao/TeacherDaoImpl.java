package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
//  查询全部教师
    @Override
    public ArrayList<TeacherInfo> queryAllTeacherInfo(TeacherInfo teacherInfo) throws Exception {
        ArrayList<TeacherInfo> list = new ArrayList<TeacherInfo>();
        try{
            String sql = "select * from teacherinfo ;" ;
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()){
                flag = true;
                teacherInfo = new TeacherInfo();
                teacherInfo.setTeacherId(rs.getInt("teacher_id"));
                teacherInfo.setTeacherAccount(rs.getInt("teacher_account"));
                teacherInfo.setTeacherName(rs.getString("teacher_name"));
                teacherInfo.setTeacherTel(rs.getString("teacher_tel"));
                teacherInfo.setTeacherPassword(rs.getString("teacher_password"));
                teacherInfo.setEmail(rs.getString("email"));
                teacherInfo.setTeacherCollege(rs.getString("teacher_college"));
                teacherInfo.setTeacherSex(rs.getString("teacher_sex"));
                teacherInfo.setTeacherJob(rs.getString("teacher_job"));
                list.add(teacherInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //修改教师信息
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
