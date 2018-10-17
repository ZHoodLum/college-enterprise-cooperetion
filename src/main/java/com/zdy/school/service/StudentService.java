package com.zdy.school.service;

import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public interface StudentService {
//    查看全部学生信息
    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception;
}
