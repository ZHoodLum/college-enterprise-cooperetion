package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/14
 */


public class StudentDaoImpl implements StudentDao{
    PreparedStatement pstate;
    ResultSet rs;
    boolean flag = false;
    Connection con = DruidUtil.getCon();
//    查询全部学生信息
    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception{
        ArrayList<StudentInfo> allStudentInfo = new ArrayList<StudentInfo>();
        try{
            String sql = "select * from studentinfo s,teacher_studentinfo ts,teacherinfo t,classinfo c,class_studentinfo cs where s.student_account = ts.student_account and ts.teacher_account = t.teacher_account and c.class_id = cs.class_id and cs.student_account = s.student_account;";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()){
                flag = true;
                studentInfo = new StudentInfo();
                studentInfo.setStudentId(rs.getInt("student_id"));
                studentInfo.setStudentAccount(rs.getInt("student_account"));
                studentInfo.setStudentName(rs.getString("student_name"));
                studentInfo.setStudentTel(rs.getString("student_tel"));
                studentInfo.setStudentPassword(rs.getString("student_password"));
                studentInfo.setStudentSex(rs.getString("student_sex"));
                studentInfo.setMajor(rs.getString("major"));
                studentInfo.setCity(rs.getString("city"));
                studentInfo.setEmail(rs.getString("email"));
                studentInfo.setStudentCollege(rs.getString("student_college"));
                studentInfo.setStudentInternship(rs.getString("student_internship"));
                studentInfo.setStudentGrade(rs.getInt("student_grade"));
                studentInfo.setClassId(rs.getInt("class_id"));
                studentInfo.setClassName(rs.getString("class_name"));
                studentInfo.setTeacherId(rs.getInt("teacher_id"));
                studentInfo.setTeacherName(rs.getString("teacher_name"));
                allStudentInfo.add(studentInfo);
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return allStudentInfo;
    }
}
