package com.zdy.school.service;

import com.zdy.school.dao.AdminDao;
import com.zdy.school.dao.AdminDaoImpl;
import com.zdy.school.vo.AdminInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    //注册管理员信息
    @Override
    public int insertAdminInfo(AdminInfo adminInfo) {
        int datavalues = 0;
        int rows = adminDao.insertAdminInfo(adminInfo);
        if (rows > 0 ){
            datavalues = 1;
        }else {
            datavalues = 0;
        }
        return datavalues;
    }
}
