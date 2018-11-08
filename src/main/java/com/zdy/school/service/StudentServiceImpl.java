package com.zdy.school.service;

import com.zdy.school.dao.StudentDao;
import com.zdy.school.dao.StudentDaoImpl;
import com.zdy.school.vo.EnterpriseInfo;
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

    //分页查询   企业进行分页查询
    @Override
    public List<StudentInfo> findAllStudentInfo(int pageNo,int pageSize,int enterpriseId) {
        List<StudentInfo> list = studentDao.findAllStudentInfo(pageNo,pageSize,enterpriseId);
        return list;
    }
    //数据总量
    @Override
    public int getTotal() {
        int n = studentDao.getTotal();
        return n;
    }

    //修改学生信息
    @Override
    public boolean updateStudentInfo(StudentInfo studentInfo) {
        return false;
    }

    //教师查询全部学生的信息
    @Override
    public List<StudentInfo> teacherFindAllStudentInfo(int teacherId) {
        List<StudentInfo> list = studentDao.teacherFindAllStudentInfo(teacherId);
        return list;
    }
}
