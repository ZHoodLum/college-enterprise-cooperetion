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
    //进行分页查询
List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize, int enterpriseId);
    //总结
    int getTotal();

    //修改学生信息
    boolean updateStudentInfo(StudentInfo studentInfo);
}
