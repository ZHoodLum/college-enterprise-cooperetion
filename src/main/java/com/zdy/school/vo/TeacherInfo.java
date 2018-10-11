package com.zdy.school.vo;

/**
 * @author Psyduck
 * teacherinfo 教师表
 * 用于存放教师的相关信息
 */
public class TeacherInfo {
	private int TeacherId;
	private String TeacherName;
	private String TeacherTel;
	private String TeacherPassword;
	private String Email;
	private String TeacherCollege;
	private String TeacherSex;
	private String TeacherJob;
	
	public int getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getTeacherTel() {
		return TeacherTel;
	}
	public void setTeacherTel(String teacherTel) {
		TeacherTel = teacherTel;
	}
	public String getTeacherPassword() {
		return TeacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		TeacherPassword = teacherPassword;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTeacherCollege() {
		return TeacherCollege;
	}
	public void setTeacherCollege(String teacherCollege) {
		TeacherCollege = teacherCollege;
	}
	public String getTeacherSex() {
		return TeacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		TeacherSex = teacherSex;
	}
	public String getTeacherJob() {
		return TeacherJob;
	}
	public void setTeacherJob(String teacherJob) {
		TeacherJob = teacherJob;
	}
	
}
