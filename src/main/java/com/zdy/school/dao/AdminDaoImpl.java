package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.AdminInfo;
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

    //管理员进行分页查询
    // pageNo 序列号起始点     pageSize  向后数pageSize条数据
    @Override
    public List<EnterpriseInfo> findAllEnterpriseInfo(int pageNo, int pageSize) {
        List<EnterpriseInfo> list = new ArrayList<EnterpriseInfo>();
        String sql = "select * from enterpriseinfo limit ?,?";
        try {
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, (pageNo - 1) * pageSize);
            pstate.setInt(2, pageSize);
            rs = pstate.executeQuery();
            while (rs.next()) {
                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
                enterpriseInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                enterpriseInfo.setEnterpriseName(rs.getString("enterprise_name"));
                enterpriseInfo.setEnterpriseIntroduce(rs.getString("enterprise_introduce"));
                enterpriseInfo.setEnterpriseAddress(rs.getString("enterprise_address"));
                enterpriseInfo.setEnterpriseTel(rs.getString("enterprise_tel"));
                enterpriseInfo.setEmail(rs.getString("email"));
                enterpriseInfo.setEnterpriseManager(rs.getString("enterprise_manager"));
                list.add(enterpriseInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //总数据量
    @Override
    public int getEnterpriseInfoTotal() {
        int n = 0;
        try{
            String sql = "select count(*) c from enterpriseinfo;";
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

    //根据ID进行查询
    @Override
    public EnterpriseInfo queryGetByIdEnterpriseInfo(int enterpriseId) {
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        try {
            String sql = "select * from enterpriseinfo where enterprise_id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, enterpriseId);
            rs = pstate.executeQuery();
            if (rs.next()) {
                enterpriseInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                enterpriseInfo.setEnterpriseName(rs.getString("enterprise_name"));
                enterpriseInfo.setEnterprisePassword(rs.getString("enterprise_password"));
                enterpriseInfo.setEnterpriseIntroduce(rs.getString("enterprise_introduce"));
                enterpriseInfo.setEnterpriseAddress(rs.getString("enterprise_address"));
                enterpriseInfo.setEnterpriseTel(rs.getString("enterprise_tel"));
                enterpriseInfo.setEmail(rs.getString("email"));
                enterpriseInfo.setEnterpriseManager(rs.getString("enterprise_manager"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enterpriseInfo;
    }

    //删除
    @Override
    public boolean deleteEnterpriseInfo(int enterpriseId) {
        try {
            String sql = "delete from enterpriseinfo where enterprise_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, enterpriseId);
            int c = pstate.executeUpdate();
            if (c > 0) {
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    //教师信息查询分页
    @Override
    public List<TeacherInfo> findAllTeacherInfo(int pageNo, int pageSize) {
        List<TeacherInfo> list = new ArrayList<TeacherInfo>();
        try {
            String sql = "select * from teacherinfo limit ?,?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, (pageNo - 1) * pageSize);
            pstate.setInt(2, pageSize);
            rs = pstate.executeQuery();
            while (rs.next()) {
                TeacherInfo teacherInfo = new TeacherInfo();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //数据总量
    @Override
    public int getTeacherInfoTotal() {
        int n = 0;
        try {
            String sql = "select count(*) c from teacherinfo";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            if (rs.next()){
                n = rs.getInt("c");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    //教师修改查询操作
    @Override
    public TeacherInfo queryGetByIdTeacherInfo(int teacherId) {
        TeacherInfo teacherInfo = new TeacherInfo();
        try {
            String sql = "select * from teacherinfo where teacher_id = ?;";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, teacherId);
            rs = pstate.executeQuery();
            if (rs.next()) {
                teacherInfo.setTeacherId(rs.getInt("teacher_id"));
                teacherInfo.setTeacherAccount(rs.getInt("teacher_account"));
                teacherInfo.setTeacherName(rs.getString("teacher_name"));
                teacherInfo.setTeacherTel(rs.getString("teacher_tel"));
                teacherInfo.setTeacherPassword(rs.getString("teacher_password"));
                teacherInfo.setEmail(rs.getString("email"));
                teacherInfo.setTeacherCollege(rs.getString("teacher_college"));
                teacherInfo.setTeacherSex(rs.getString("teacher_sex"));
                teacherInfo.setTeacherJob(rs.getString("teacher_job"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }

    //删除教师信息
    @Override
    public boolean deleteTeacherInfo(int teacherId) {
        try {
            String sql = "delete from teacherinfo where teacher_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, teacherId);
            int c = pstate.executeUpdate();
            if (c > 0) {
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    //学生分页查询
    @Override
    public List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize) {
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        try {
            String sql = "select * from studentinfo limit ?,?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, (pageNo - 1) * pageSize);
            pstate.setInt(2, pageSize);
            rs = pstate.executeQuery();
            while (rs.next()) {
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
                list.add(studentInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getStudentInfoTotal() {
        int n = 0;
        try {
            String sql = "select count(*) c from studentinfo";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            if (rs.next()){
                n = rs.getInt("c");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    //根据ID进行查询
    @Override
    public StudentInfo queryGetByIdStudentInfo(int studentId) {
        StudentInfo studentInfo = new StudentInfo();
        try {
            String sql = "select * from studentinfo where student_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, studentId);
            rs = pstate.executeQuery();
            if (rs.next()) {
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
                studentInfo.setTeacherId(rs.getInt("teacher_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }



    //修改学生信息
    @Override
    public boolean adminUpdateStudentInfo(StudentInfo studentInfo) {
        int rows = 0;
        try{
            String sql = "update studentinfo set student_account = ?,student_name = ?,student_tel = ?," +
                    "student_password = ?,student_sex = ?,major = ?,city = ?,email = ?,student_college = ? where student_id = ?;";
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
            pstate.setInt(10,studentInfo.getStudentId());
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

    //删除学生信息
    @Override
    public boolean deleteStudentInfo(int studentId) {
        try {
            String sql = "delete from studentinfo where student_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, studentId);
            int c = pstate.executeUpdate();
            if (c > 0) {
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    //删除学生简历信息
    @Override
    public boolean deleteStudentResumes(int studentId) {
        try {
            String sql = "delete from resumes where student_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, studentId);
            int c = pstate.executeUpdate();
            if (c > 0) {
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

}
