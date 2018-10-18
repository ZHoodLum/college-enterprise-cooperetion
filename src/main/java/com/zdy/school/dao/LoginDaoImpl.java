package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LoginDaoImpl implements LoginDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean flag = false;
	private Connection conn = DruidUtil.getCon();
	//学生登陆
	@Override
	public boolean studentlogin(StudentInfo studentinfo) throws Exception {
		try {
			String sql = "select * from studentinfo where student_tel =? and student_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentinfo.getStudentTel());
			pstmt.setString(2, studentinfo.getStudentPassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
				studentinfo.setStudentTel(rs.getString("student_tel"));
				studentinfo.setStudentPassword(rs.getString("student_password"));
				studentinfo.setStudentName(rs.getString("student_name"));
				studentinfo.setStudentSex(rs.getString("student_sex"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DruidUtil.closeConnection(rs, conn, pstmt);
		}
		return flag;
	}
	//教师登陆
	@Override
	public boolean teacherlogin(TeacherInfo teacherinfo) throws Exception {
		try {
			String sql = "select * from teacherinfo where teacher_tel =? and teacher_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherinfo.getTeacherTel());
			pstmt.setString(2, teacherinfo.getTeacherPassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
				teacherinfo.setTeacherTel(rs.getString("teacher_tel"));
				teacherinfo.setTeacherPassword(rs.getString("teacher_password"));
				teacherinfo.setTeacherName(rs.getString("teacher_name"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DruidUtil.closeConnection(rs, conn, pstmt);

		}
		return flag;
	}
	//企业登录入口
	@Override
	public boolean enterpriselogin(EnterpriseInfo enterpriseinfo) throws Exception {
		try {
			String sql = "select * from enterpriseinfo where enterprise_id =? and enterprise_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, enterpriseinfo.getEnterpriseId());
			pstmt.setString(2, enterpriseinfo.getEnterprisePassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
				enterpriseinfo.setEnterpriseId(rs.getInt("enterprise_id"));
				enterpriseinfo.setEnterprisePassword(rs.getString("enterprise_password"));
				enterpriseinfo.setEnterpriseManager(rs.getString("enterprise_manager"));
				enterpriseinfo.setEnterpriseName(rs.getString("enterprise_name"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DruidUtil.closeConnection(rs, conn, pstmt);

		}
		return flag;
	}
	
	//管理员登录入口
	@Override
	public boolean adminlogin(AdminInfo admininfo) throws Exception {
		try {
			String sql = "select * from admininfo where admin_id =? and admin_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, admininfo.getAdminId());
			System.out.println(admininfo.getAdminId());
			pstmt.setString(2, admininfo.getAdminPassword());
			System.out.println(admininfo.getAdminPassword());
			
			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
				admininfo.setAdminId(rs.getInt("admin_id"));
				admininfo.setAdminPassword(rs.getString("admin_password"));
				admininfo.setAdminName(rs.getString("admin_name"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DruidUtil.closeConnection(rs, conn, pstmt);

		}
		return flag;
	}


	
}
