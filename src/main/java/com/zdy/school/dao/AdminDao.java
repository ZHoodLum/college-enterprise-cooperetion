package com.zdy.school.dao;

import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public interface AdminDao {
    //注册管理员信息
    int insertAdminInfo(AdminInfo adminInfo);

    //修改管理员信息
    boolean updateAdminInfo(AdminInfo adminInfo);

    /*********************************************企业*****************************************************/
    //企业进行分页查询
    List<EnterpriseInfo> findAllEnterpriseInfo(int pageNo, int pageSize);

    //数据总数
    int getEnterpriseInfoTotal();

    //根据id进行查询修改
    EnterpriseInfo queryGetByIdEnterpriseInfo(int enterpriseId);

    //删除学生信息
    boolean deleteEnterpriseInfo(int enterpriseId);

    /********************************************教师*****************************************************/
    //教师进行分页查询
    List<TeacherInfo> findAllTeacherInfo(int pageNo, int pageSize);

    //数据总数
    int getTeacherInfoTotal();

    //根据id进行查询修改
    TeacherInfo queryGetByIdTeacherInfo(int teacherId);

    //删除学生信息
    boolean deleteTeacherInfo(int teacherId);

    /*********************************************学生****************************************************/
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

    //删除学生简历信息
    boolean deleteStudentResumes(int studentId);

}
