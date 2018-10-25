package com.zdy.school.service;

import com.zdy.school.dao.StudentDao;
import com.zdy.school.dao.StudentDaoImpl;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public class StudentServiceImpl implements  StudentService {
    StudentDao studentDao = new StudentDaoImpl();
//    @Override
//    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception {
//        return studentDao.findAllStudentInfo(studentInfo);
//    }

    @Override
    public List<StudentInfo> findAllStudentInfo(int pageNo,int pageSize) {
        List<StudentInfo> list = studentDao.findAllStudentInfo(pageNo,pageSize);
        System.out.println("数组："+list);
        return list;
    }

    @Override
    public int getTotal() {
        int n = studentDao.getTotal();
        return n;
    }
}
