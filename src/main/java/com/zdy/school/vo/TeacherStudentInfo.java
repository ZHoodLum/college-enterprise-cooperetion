package com.zdy.school.vo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/15
 */


public class TeacherStudentInfo {
    private int Id;
    private int TeacherAccount;
    private int StudentAccount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTeacherAccount() {
        return TeacherAccount;
    }

    public void setTeacherAccount(int teacherAccount) {
        TeacherAccount = teacherAccount;
    }

    public int getStudentAccount() {
        return StudentAccount;
    }

    public void setStudentAccount(int studentAccount) {
        StudentAccount = studentAccount;
    }
}
