package com.zdy.school.service;

import com.zdy.school.dao.LoginDao;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/6
 * @ Description：${description}
 * @Version: $version$
 */


public class LoginService {
    LoginDao loginDao = new LoginDao();
    //学生登陆
    public boolean studentlogin(StudentInfo studentInfo) throws Exception {
        return loginDao.studentlogin(studentInfo);
    }
    //教师登录
    public boolean teacherlogin(TeacherInfo teacherInfo) throws Exception{
        return loginDao.teacherlogin(teacherInfo);
    }
    //企业登录
    public boolean enterpriselogin(EnterpriseInfo enterpriseInfo) throws Exception{
        return loginDao.enterpriselogin(enterpriseInfo);
    }
    //管理员登录
    public boolean adminlogin(AdminInfo adminInfo) throws Exception{
        return loginDao.adminlogin(adminInfo);
    }
}
