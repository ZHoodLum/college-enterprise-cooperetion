package com.zdy.school.vo;
/**
 * @author Psyduck
 * studentinfo 学生表
 * 用于存放学生的相关信息
 */
public class StudentInfo {
	private int StudentId;
	private int StudentAccount;
	private String StudentName;
	private String StudentTel;
	private String StudentPassword;
	private String StudentSex;
	private String Major;
	private String City;
	private String Email;
	private String StudentCollege;
	private String StudentInternship;
	private int StudentGrade;
	private int ClassId;
	private int TeacherId;
	private String ClassName;
	private String TeacherName;

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public int getStudentAccount() {
		return StudentAccount;
	}

	public void setStudentAccount(int studentAccount) {
		StudentAccount = studentAccount;
	}
	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentTel() {
		return StudentTel;
	}
	public void setStudentTel(String studentTel) {
		StudentTel = studentTel;
	}
	public String getStudentPassword() {
		return StudentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}
	public String getStudentSex() {
		return StudentSex;
	}
	public void setStudentSex(String studentSex) {
		StudentSex = studentSex;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getStudentCollege() {
		return StudentCollege;
	}
	public void setStudentCollege(String studentCollege) {
		StudentCollege = studentCollege;
	}
	public String getStudentInternship() {
		return StudentInternship;
	}
	public void setStudentInternship(String studentInternship) {
		StudentInternship = studentInternship;
	}
	public int getStudentGrade() {
		return StudentGrade;
	}
	public void setStudentGrade(int studentGrade) {
		StudentGrade = studentGrade;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	
	
}
