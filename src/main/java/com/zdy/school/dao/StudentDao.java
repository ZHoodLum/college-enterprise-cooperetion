package com.zdy.school.dao;

import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public interface StudentDao {
    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception;
}
