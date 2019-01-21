package com.zdy.school.dao;

import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.StudentInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public interface AdminDao {
    //注册管理员信息
    int insertAdminInfo(AdminInfo adminInfo);

    //修改管理员信息
    boolean updateAdminInfo(AdminInfo adminInfo);
}
