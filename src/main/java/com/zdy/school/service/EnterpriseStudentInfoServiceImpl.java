package com.zdy.school.service;

import com.zdy.school.dao.EnterpriseStudentInfoDao;
import com.zdy.school.dao.EnterpriseStudentInfoDaoImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


public class EnterpriseStudentInfoServiceImpl implements EnterpriseStudentInfoService {
    EnterpriseStudentInfoDao enterpriseStudentInfoDao = new EnterpriseStudentInfoDaoImpl();
    //根据学生id 企业id进行查询是否存在该条信息
    @Override
    public boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        return enterpriseStudentInfoDao.QueryByIdEnterpriseStudentInfo(enterpriseStudentInfo);
    }

}
