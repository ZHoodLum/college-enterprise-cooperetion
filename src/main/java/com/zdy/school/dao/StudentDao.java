package com.zdy.school.dao;

import com.zdy.school.vo.Resumes;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */


public interface StudentDao {
    ArrayList<StudentInfo> queryAllStudentInfo(StudentInfo studentInfo) throws Exception;
    //企业进行分页查询
    List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize, int enterpriseId);
    //数据总数
    int getTotal();

    //修改学生信息
    boolean updateStudentInfo(StudentInfo studentInfo);

    //教师查询自己管理的实习学生的信息成绩
    List<StudentInfo> teacherFindAllStudentInfo(int teacherId);

    //条件查询学生信息
    List<StudentInfo> conditionFindAllStudentInfo(StudentInfo studentInfo);

    //教师管理的学生
    List<StudentInfo> teacherMyStudentInfo(int teacherId);

    //注册学生信息
    int insertStudentInfo(StudentInfo studentInfo);

    //添加简历信息
    int insertStudentResumes(Resumes resumes);

    //学生查询简历信息是否存在
    Resumes findResumesById(int studentId);

}
