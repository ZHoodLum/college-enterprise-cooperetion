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
    public boolean studentlogin(StudentInfo studentInfo) throws Exception;
    //教师登录
    public boolean teacherlogin(TeacherInfo teacherInfo) throws Exception;
    //企业登录
    public boolean enterpriselogin(EnterpriseInfo enterpriseInfo) throws Exception;
    //管理员登录
    public boolean adminlogin(AdminInfo adminInfo) throws Exception;
}
