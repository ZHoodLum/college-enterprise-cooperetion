package com.zdy.school.vo;

import java.sql.Date;

/**
 * @author Psyduck
 * Resume 简历信息表
 * 用于存放简历信息的相关信息
 */
public class Resume {
	private int studentId;
	private String studentName;
	private String studentSex;
	private String nationality;
	private Date birthday;
	private String city;
	private String politics;
	private String health;
	private String college;
	private String education;
	private String major;
	private Date graduateTime;
	private String email;
	private String studentContineTime;
	private String majorCourse;
	private String credential;
	private String selfEvaluation;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getGraduateTime() {
		return graduateTime;
	}

	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentContineTime() {
		return studentContineTime;
	}

	public void setStudentContineTime(String studentContineTime) {
		this.studentContineTime = studentContineTime;
	}

	public String getMajorCourse() {
		return majorCourse;
	}

	public void setMajorCourse(String majorCourse) {
		this.majorCourse = majorCourse;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getSelfEvaluation() {
		return selfEvaluation;
	}

	public void setSelfEvaluation(String selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
	}
}
