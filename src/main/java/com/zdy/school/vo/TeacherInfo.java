package com.zdy.school.vo;

/**
 * @author Psyduck
 * teacherinfo 教师表
 * 用于存放教师的相关信息
 */
public class TeacherInfo {
	private int teacherId;
	private String teacherName;
	private String teacherTel;
	private String teacherPassword;
	private String email;
	private String teacherCollege;
	private String teacherSex;
	private String teacherJob;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherTel() {
		return teacherTel;
	}

	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeacherCollege() {
		return teacherCollege;
	}

	public void setTeacherCollege(String teacherCollege) {
		this.teacherCollege = teacherCollege;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public String getTeacherJob() {
		return teacherJob;
	}

	public void setTeacherJob(String teacherJob) {
		this.teacherJob = teacherJob;
	}
}
