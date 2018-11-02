package com.zdy.school.service;

import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public interface StudentService {
//    查看全部学生信息
//    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception;
List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize, int enterpriseId);
    int getTotal();

    //修改学生信息
    boolean uodateStudentInfo(StudentInfo studentInfo);
}


