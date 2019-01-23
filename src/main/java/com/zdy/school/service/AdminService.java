package com.zdy.school.service;

import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public interface AdminService {
    //注册管理员信息
    int insertAdminInfo(AdminInfo adminInfo);

    //修改管理员信息
    boolean updateAdminInfo(AdminInfo adminInfo);

    //企业进行分页查询
    List<EnterpriseInfo> findAllEnterpriseInfo(int pageNo, int pageSize);
    //数据总数
    int getEnterpriseInfoTotal();

    //教师进行分页查询
    List<TeacherInfo> findAllTeacherInfo(int pageNo, int pageSize);
    //数据总数
    int getTeacherInfoTotal();

    //学生进行分页查询
    List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize);
    //数据总数
    int getStudentInfoTotal();
    //根据id进行查询修改
    StudentInfo queryGetByIdStudentInfo(int studentId);
    //修改学生信息
    boolean adminUpdateStudentInfo(StudentInfo studentInfo);
    //删除学生信息
    boolean deleteStudentInfo(int studentId);

}
