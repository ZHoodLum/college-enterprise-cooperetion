package com.zdy.school.vo;

import java.sql.Date;

/**
 * @author Psyduck
 * Resume 简历信息表
 * 用于存放简历信息的相关信息
 */
public class Resume {
	private int student_id;
	private String student_name;
	private String student_sex;
	private String nationality;
	private Date birthday;
	private String city;
	private String politics;
	private String health;
	private String college;
	private String education;
	private String major;
	private Date graduate_time;
	private String email;
	private String student_contine_time;
	private String major_course;
	private String credential;
	private String self_evaluation;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
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
	public Date getGraduate_time() {
		return graduate_time;
	}
	public void setGraduate_time(Date graduate_time) {
		this.graduate_time = graduate_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudent_contine_time() {
		return student_contine_time;
	}
	public void setStudent_contine_time(String student_contine_time) {
		this.student_contine_time = student_contine_time;
	}
	public String getMajor_course() {
		return major_course;
	}
	public void setMajor_course(String major_course) {
		this.major_course = major_course;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getSelf_evaluation() {
		return self_evaluation;
	}
	public void setSelf_evaluation(String self_evaluation) {
		this.self_evaluation = self_evaluation;
	}
	
}
