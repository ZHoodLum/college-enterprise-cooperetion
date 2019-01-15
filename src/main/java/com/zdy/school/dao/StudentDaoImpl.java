package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.Resumes;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;
import sun.security.rsa.RSASignature;

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
                " and e.enterprise_id = es.enterprise_id  " +
                " and s.student_id = es.student_id " +
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
//            String sql = "update studentinfo set student_account = ?,student_name = ?,student_tel = ?,student_password = ?," +
//                    "student_sex = ?,major = ?,city = ?,email = ?,student_college = ?," +
//                    "student_internship = ?,student_grade = ?,class_id = ?,teacher_id = ? " +
//                    "where student_id = ?;";
            String sql = "update studentinfo set student_account = ?,student_name = ?,student_tel = ?," +
                    "student_password = ?,student_sex = ?,major = ?,city = ?,email = ?,student_college = ?,class_id = ?,teacher_id = ? where student_id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,studentInfo.getStudentAccount());
            pstate.setString(2,studentInfo.getStudentName());
            pstate.setString(3,studentInfo.getStudentTel());
            pstate.setString(4,studentInfo.getStudentPassword());
            pstate.setString(5,studentInfo.getStudentSex());
            pstate.setString(6,studentInfo.getMajor());
            pstate.setString(7,studentInfo.getCity());
            pstate.setString(8,studentInfo.getEmail());
            pstate.setString(9,studentInfo.getStudentCollege());
            pstate.setInt(10,studentInfo.getClassId());
            pstate.setInt(11,studentInfo.getTeacherId());
            pstate.setInt(12,studentInfo.getStudentId());
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

    //条件查询01
    @Override
    public List<StudentInfo> conditionFindAllStudentInfo1(StudentInfo studentInfo) {
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        StringBuilder sql = new StringBuilder();
        try{
            sql.append("select * from studentinfo s,teacherinfo t,classinfo c ");
        sql.append("where s.teacher_id = t.teacher_id ");
        sql.append("and  c.class_id = s.class_id ");
//        sql.append("and e.enterprise_id = es.enterprise_id ");
//        sql.append("and  s.student_id = es.student_id ");
        if (studentInfo.getStudentAccount() != null && !"".equals(studentInfo.getStudentAccount())){
            sql.append("and s.student_account = ? ");
        }
        if (studentInfo.getStudentTel() != null && !"".equals(studentInfo.getStudentTel())){
            sql.append("and s.student_tel = ? ");
        }
        if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId())){
            sql.append("and s.class_id = ? ");
        }
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
//            String sql = " select * from  studentinfo s,teacherinfo t,classinfo c " +
//                    "where s.teacher_id = t.teacher_id " +
//                    "and c.class_id = s.class_id  " +
//                    "and  s.class_id = ?;";
//            pstate = con.prepareStatement(sql);
            if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId())){
                pstate.setInt(1, studentInfo.getClassId());
                i++;
            }
            rs = pstate.executeQuery();
            while (rs.next()){
                studentInfo = new StudentInfo();
//                TeacherInfo teacherInfo = new TeacherInfo();
//                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
//                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
//                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    //条件查询02
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
//        if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
//            sql.append("and s.class_id = ? ");
//        }
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
//            if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
//                pstate.setInt(i, studentInfo.getClassId());
//                i++;
//            }
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

    //注册学生信息
    @Override
    public int insertStudentInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            String sql = "insert into studentinfo(student_account, student_name, student_tel, student_password, student_sex, major, city, email, student_college) values(?,?,?,?,?,?,?,?,?);";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,studentInfo.getStudentAccount());
            pstate.setString(2,studentInfo.getStudentName());
            pstate.setString(3,studentInfo.getStudentTel());
            pstate.setString(4,studentInfo.getStudentPassword());
            pstate.setString(5,studentInfo.getStudentSex());
            pstate.setString(6,studentInfo.getMajor());
            pstate.setString(7,studentInfo.getCity());
            pstate.setString(8,studentInfo.getEmail());
            pstate.setString(9,studentInfo.getStudentCollege());
            rows = pstate.executeUpdate();
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("录入学生信息出现错误！");
        }
        return rows;
    }

    //添加简历信息
    @Override
    public int insertStudentResumes(Resumes resumes) {
        int rows = 0;
        try {
            String sql = " insert into resumes(student_id, nationality, birthday, politics, health, college, education, graduate_time, student_continue_time, major_course, credential, self_evaluation) values(?,?,?,?,?,?,?,?,?,?,?,?);";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, resumes.getStudentId());
            pstate.setString(2, resumes.getNationality());
            pstate.setDate(3, resumes.getBirthday());
            pstate.setString(4, resumes.getPolitics());
            pstate.setString(5, resumes.getHealth());
            pstate.setString(6, resumes.getCollege());
            pstate.setString(7, resumes.getEducation());
            pstate.setDate(8, resumes.getGraduateTime());
            pstate.setString(9, resumes.getStudentContineTime());
            pstate.setString(10, resumes.getMajorCourse());
            pstate.setString(11,resumes.getCredential());
            pstate.setString(12, resumes.getSelfEvaluation());
            rows = pstate.executeUpdate();
//            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入学生信息出现错误！");
        }
        return rows;
    }

    //学生查询简历信息是否存在 第二次进入后不显示按钮
    @Override
    public Resumes findResumesById(int studentId) {
        Resumes resumes = new Resumes();
        try {
            String sql = "select * from studentinfo s,resumes r where s.student_id = r.student_id and r.student_id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,studentId);
            rs = pstate.executeQuery();
            while (rs.next()) {
                flag = true;
                resumes.setStudentId(rs.getInt("student_id"));
                resumes.setNationality(rs.getString("nationality"));
                resumes.setBirthday(rs.getDate("birthday"));
                resumes.setPolitics(rs.getString("politics"));
                resumes.setHealth(rs.getString("health"));
                resumes.setCollege(rs.getString("college"));
                resumes.setEducation(rs.getString("education"));
                resumes.setGraduateTime(rs.getDate("graduate_time"));
                resumes.setStudentContineTime(rs.getString("student_continue_time"));
                resumes.setMajorCourse(rs.getString("major_course"));
                resumes.setCredential(rs.getString("credential"));
                resumes.setSelfEvaluation(rs.getString("self_evaluation"));
//                DruidUtil.closeConnection(rs, con, pstate);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resumes;
    }

}
