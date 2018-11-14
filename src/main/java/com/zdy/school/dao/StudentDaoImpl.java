package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<StudentInfo> queryAllStudentInfo(StudentInfo studentInfo) throws Exception{
        ArrayList<StudentInfo> list = new ArrayList<StudentInfo>();
        try{
            String sql = "select * from  studentinfo s,teacherinfo t,classinfo c where s.teacher_id = t.teacher_id and c.class_id = s.class_id ;" ;
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
                list.add(studentInfo);
//                for(StudentInfo li:list) {
//                    System.out.println("集合元素有："+list);
//                }
            }
//            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

//  企业进行分页查询
    public List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize,int enterpriseId){
        List<StudentInfo> list = new ArrayList<StudentInfo>();
//        String sql = "select * from studentinfo s,teacher_studentinfo ts,teacherinfo t,classinfo c,class_studentinfo cs,enterprise_studentinfo es,enterpriseinfo e where s.student_account = ts.student_account and ts.teacher_account = t.teacher_account and c.class_id = cs.class_id and cs.student_account = s.student_account and es.enterprise_id = e.enterprise_id and es.student_account = s.student_account and e.enterprise_id= ? limit ?,?;";
        String sql = "select * from  studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e" +
                " where s.teacher_id = t.teacher_id" +
                " and c.class_id = s.class_id " +
                " and e.enterprise_id = ?" +
                " limit ?,?;";
        try{
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,enterpriseId);
            pstate.setInt(2,(pageNo-1)*pageSize);
            pstate.setInt(3,pageSize);
            rs = pstate.executeQuery();
            while (rs.next()){
                StudentInfo studentInfo = new StudentInfo();
                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
                enterpriseInfo.setEnterpriseId(rs.getInt("enterprise_id"));
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
                list.add(studentInfo);
//                for(StudentInfo li:list) {
//                    System.out.println("集合元素有："+list);
//                }
            }
//            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
//    查询数据总数量
    @Override
    public int getTotal() {
        String sql = "select count(*) c from studentinfo";
        int n = 0;
        try{
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            if (rs.next()){
                n = rs.getInt("c");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    //修改学生信息
    @Override
    public boolean updateStudentInfo(StudentInfo studentInfo) {
        int rows = 0;
        try{
            String sql = "update studentinfo set teacher_id = ? where student_id = ?;";
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //教师查询自己管理的实习学生的信息成绩
    @Override
    public List<StudentInfo> teacherFindAllStudentInfo(int teacherId) {
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        String sql = "select * from studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e" +
                " where s.student_id = es.student_id " +
                " and es.enterprise_id = e.enterprise_id " +
                "and c.class_id = s.class_id  " +
                "and t.teacher_id = s.teacher_id" +
                " and t.teacher_id = ?;";
        try{
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,teacherId);
            rs = pstate.executeQuery();
            while (rs.next()){
                StudentInfo studentInfo = new StudentInfo();
//                TeacherInfo teacherInfo = new TeacherInfo();
//                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
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
                list.add(studentInfo);
//                for(StudentInfo li:list) {
//                    System.out.println("集合元素有："+list);
//                }
            }
//            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    //条件查询

    @Override
    public List<StudentInfo> conditionFindAllStudentInfo(StudentInfo studentInfo) {
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        StringBuilder sql = new StringBuilder();
        sql.append("select *");
        sql.append("from studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e ");
        sql.append("where c.class_id = s.class_id ");
        sql.append("and t.teacher_id = s.teacher_id ");
        sql.append("and e.enterprise_id = es.enterprise_id ");
        sql.append("and  s.student_id = es.student_id ");
        if (studentInfo.getStudentAccount() != null && !"".equals(studentInfo.getStudentAccount())){
            sql.append("and s.student_account = ? ");
        }
        if (studentInfo.getStudentTel() != null && !"".equals(studentInfo.getStudentTel())){
            sql.append("and s.student_tel = ? ");
        }
        if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
            sql.append("and s.class_id = ? ");
        }
//        String  sql = "select * from studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e where c.class_id = s.class_id and t.teacher_id = s.teacher_id and e.enterprise_id = es.enterprise_id and  s.student_id = es.student_id and s.student_tel = ?;";
        try{
            pstate = con.prepareStatement(sql.toString());
            int i = 1;
            if (studentInfo.getStudentAccount() != null && !"".equals(studentInfo.getStudentAccount())){
                pstate.setInt(i, studentInfo.getStudentAccount());
                i++;
            }
            if (studentInfo.getStudentTel() != null && !"".equals(studentInfo.getStudentTel())){
                pstate.setString(1, studentInfo.getStudentTel());
                i++;
            }
            if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
                pstate.setInt(i, studentInfo.getClassId());
                i++;
            }
            rs = pstate.executeQuery();
            while (rs.next()){
                studentInfo = new StudentInfo();
//                TeacherInfo teacherInfo = new TeacherInfo();
//                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
//                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
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
//                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
//                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
                list.add(studentInfo);
//                for(StudentInfo li:list) {
//                    System.out.println("集合元素有："+list);
//                }
            }
//            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    //教师查询自己管理的学生
    @Override
    public List<StudentInfo> teacherMyStudentInfo(int teacherId) {
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        String sql = "select * from studentinfo s,teacherinfo t,classinfo c " +
                "where c.class_id = s.class_id " +
                "and t.teacher_id = s.teacher_id " +
                " and t.teacher_id = ?;";
        try{
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,teacherId);
            rs = pstate.executeQuery();
            while (rs.next()){
                StudentInfo studentInfo = new StudentInfo();
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
                list.add(studentInfo);
//                for(StudentInfo li:list) {
//                    System.out.println("集合元素有："+list);
//                }
            }
//            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
