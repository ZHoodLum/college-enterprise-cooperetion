package com.zdy.school.service;

import com.zdy.school.dao.StudentDao;
import com.zdy.school.dao.StudentDaoImpl;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public class StudentServiceImpl implements  StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception {
        return studentDao.findAllStudentInfo(studentInfo);
    }
}
