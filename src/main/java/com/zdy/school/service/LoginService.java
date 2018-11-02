package com.zdy.school.service;

import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 */


public interface LoginService {
    //学生登陆
    boolean studentlogin(StudentInfo studentInfo) throws Exception;
    //教师登录
    boolean teacherlogin(TeacherInfo teacherInfo) throws Exception;
    //企业登录
    boolean enterpriselogin(EnterpriseInfo enterpriseInfo) throws Exception;
    //管理员登录
    boolean adminlogin(AdminInfo adminInfo) throws Exception;
}
