package com.zdy.school.dao;

import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public interface StudentDao {
//    public ArrayList<StudentInfo> findAllStudentInfo(StudentInfo studentInfo) throws Exception;
    //企业进行分页查询
    List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize, int enterpriseId);
    //数据总数
    int getTotal();

    //修改学生信息
    boolean updateStudentInfo(StudentInfo studentInfo);

    //教师查询全部学生信息
    List<StudentInfo> teacherFindAllStudentInfo(int teacherId);

    //条件查询学生信息
    List<StudentInfo> conditionFindAllStudentInfo(StudentInfo studentInfo);

}
