package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/6
 */


public class LoginDao {
    private PreparedStatement preparedStatement;
    ResultSet rs = null;
    boolean flag = false;
    //获取连接信息
    Connection conn = DruidUtil.getCon();

    //学生登陆
    public boolean studentlogin(StudentInfo studentInfo) throws Exception {
        try {
            String sql = "select * from studentinfo where student_tel =? and student_password =?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, studentInfo.getStudentTel());
            preparedStatement.setString(2, studentInfo.getStudentPassword());

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                flag = true;
                studentInfo.setStudentTel(rs.getString("student_tel"));
                studentInfo.setStudentPassword(rs.getString("student_password"));
                studentInfo.setStudentName(rs.getString("student_name"));
                studentInfo.setStudentSex(rs.getString("student_sex"));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            DruidUtil.closeConnection(rs, conn, preparedStatement);
        }
        return flag;
    }
    //教师登陆
    public boolean teacherlogin(TeacherInfo teacherInfo) throws Exception {
        try {
            String sql = "select * from teacherinfo where teacher_tel =? and teacher_password =?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, teacherInfo.getTeacherTel());
            preparedStatement.setString(2, teacherInfo.getTeacherPassword());

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                flag = true;
                teacherInfo.setTeacherTel(rs.getString("teacher_tel"));
                teacherInfo.setTeacherPassword(rs.getString("teacher_password"));
                teacherInfo.setTeacherName(rs.getString("teacher_name"));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            DruidUtil.closeConnection(rs, conn, preparedStatement);

        }
        return flag;
    }
    //企业登录入口
    public boolean enterpriselogin(EnterpriseInfo enterpriseInfo) throws Exception {
        try {
            String sql = "select * from enterpriseinfo where enterprise_id =? and enterprise_password =?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, enterpriseInfo.getEnterpriseId());
            preparedStatement.setString(2, enterpriseInfo.getEnterprisePassword());

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                flag = true;
                enterpriseInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                enterpriseInfo.setEnterprisePassword(rs.getString("enterprise_password"));
                enterpriseInfo.setEnterpriseManager(rs.getString("enterprise_manager"));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            DruidUtil.closeConnection(rs, conn, preparedStatement);
        }
        return flag;
    }

    //管理员登录入口
    public boolean adminlogin(AdminInfo adminInfo) throws Exception {
        try {
            String sql = "select * from admininfo where admin_id =? and admin_password =?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, adminInfo.getAdminId());
            preparedStatement.setString(2, adminInfo.getAdminPassword());

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                flag = true;
                adminInfo.setAdminId(rs.getInt("admin_id"));
                adminInfo.setAdminPassword(rs.getString("admin_password"));
                adminInfo.setAdminName(rs.getString("admin_name"));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            DruidUtil.closeConnection(rs, conn, preparedStatement);
        }
        return flag;
    }

}
