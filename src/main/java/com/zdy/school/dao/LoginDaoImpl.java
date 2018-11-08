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
	public boolean studentlogin(StudentInfo studentInfo) throws Exception {
		try {
//			String sql = "select * from studentinfo where student_tel =? and student_password =?";
			String sql = " select * from  studentinfo s,teacherinfo t,classinfo c where s.teacher_id = t.teacher_id and c.class_id = s.class_id and student_tel =? and student_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentInfo.getStudentTel());
			pstmt.setString(2, studentInfo.getStudentPassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
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
				studentInfo.setTeacherName(rs.getString("teacher_name"));
				studentInfo.setTeacherId(rs.getInt("teacher_id"));
//				studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
//				studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
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
	public boolean teacherlogin(TeacherInfo teacherInfo) throws Exception {
		try {
			String sql = "select * from teacherinfo where teacher_tel =? and teacher_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherInfo.getTeacherTel());
			pstmt.setString(2, teacherInfo.getTeacherPassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
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
	public boolean enterpriselogin(EnterpriseInfo enterpriseInfo) throws Exception {
		try {
			String sql = "select * from enterpriseinfo where enterprise_id =? and enterprise_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, enterpriseInfo.getEnterpriseId());
			pstmt.setString(2, enterpriseInfo.getEnterprisePassword());

			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				flag = true;
				enterpriseInfo.setEnterpriseId(rs.getInt("enterprise_id"));
				enterpriseInfo.setEnterprisePassword(rs.getString("enterprise_password"));
				enterpriseInfo.setEnterpriseName(rs.getString("enterprise_name"));
				enterpriseInfo.setEnterpriseIntroduce(rs.getString("enterprise_introduce"));
				enterpriseInfo.setEnterpriseAddress(rs.getString("enterprise_address"));
				enterpriseInfo.setEnterpriseTel(rs.getString("enterprise_tel"));
				enterpriseInfo.setEmail(rs.getString("email"));
				enterpriseInfo.setEnterpriseManager(rs.getString("enterprise_manager"));
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
