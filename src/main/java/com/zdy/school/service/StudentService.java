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
    ArrayList<StudentInfo> queryAllStudentInfo(StudentInfo studentInfo) throws Exception;
//    企业进行分页查询
    List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize, int enterpriseId);
    int getTotal();

    //修改学生信息
    boolean updateStudentInfo(StudentInfo studentInfo);

    //教师查询学生信息
    List<StudentInfo> teacherFindAllStudentInfo(int teacherId);

    //条件查询学生信息
    List<StudentInfo> conditionFindAllStudentInfo(StudentInfo studentInfo);

    //教师管理的学生
    List<StudentInfo> teacherMyStudentInfo(int teacherId);

    //注册学生信息
    int insertStudentInfo(StudentInfo studentInfo);

}


