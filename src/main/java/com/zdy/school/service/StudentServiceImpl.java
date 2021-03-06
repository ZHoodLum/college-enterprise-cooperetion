package com.zdy.school.service;

import com.zdy.school.dao.StudentDao;
import com.zdy.school.dao.StudentDaoImpl;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.Resumes;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public class StudentServiceImpl implements  StudentService {
    StudentDao studentDao = new StudentDaoImpl();
//  查询全部学生信息
    @Override
    public ArrayList<StudentInfo> queryAllStudentInfo(StudentInfo studentInfo) throws Exception {
        ArrayList<StudentInfo> list = studentDao.queryAllStudentInfo(studentInfo);
        return list;
    }

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
        int succ = 0;
        boolean rows = studentDao.updateStudentInfo(studentInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }

    //教师查询自己管理的实习学生的信息成绩
    @Override
    public List<StudentInfo> teacherFindAllStudentInfo(int teacherId) {
        List<StudentInfo> list = studentDao.teacherFindAllStudentInfo(teacherId);
        return list;
    }

    //条件查询1
    @Override
    public List<StudentInfo> conditionFindAllStudentInfo1(StudentInfo studentInfo) {
        List<StudentInfo> list = studentDao.conditionFindAllStudentInfo1(studentInfo);
        return list;
    }

    //条件查询2
    @Override
    public List<StudentInfo> conditionFindAllStudentInfo(StudentInfo studentInfo) {
        List<StudentInfo> list = studentDao.conditionFindAllStudentInfo(studentInfo);
        return list;
    }

    //该教师管理的学生信息
    @Override
    public List<StudentInfo> teacherMyStudentInfo(int teacherId) {
        List<StudentInfo> list = studentDao.teacherMyStudentInfo(teacherId);
        return list;
    }

    //注册学生信息
    @Override
    public int insertStudentInfo(StudentInfo studentInfo) {
        int datevalues = 0;
        int rows = studentDao.insertStudentInfo(studentInfo);
        if (rows > 0){
            datevalues = 1;
        }else{
            datevalues = 0;
        }
        return datevalues;
    }

    //添加简历信息
    @Override
    public int insertStudentResumes(Resumes resumes) {
        int datevalues = 0;
        int rows = studentDao.insertStudentResumes(resumes);
        if (rows > 0){
            datevalues = 1;
        }else{
            datevalues = 0;
        }
        return datevalues;
    }

    //根据iD查询简历是否存在
    @Override
    public Resumes findResumesById(int studentId) {
        return studentDao.findResumesById(studentId);
    }

    @Override
    public boolean enterpriseUpdateStudentScore(StudentInfo studentInfo) {
        int succ = 0;
        boolean rows = studentDao.enterpriseUpdateStudentScore(studentInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }


}
