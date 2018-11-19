package com.zdy.school.service;

import com.zdy.school.dao.EnterpriseDao;
import com.zdy.school.dao.EnterpriseDaoImpl;
import com.zdy.school.vo.EnterpriseInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/29
 */


public class EnterpriseServiceImpl implements EnterpriseService {
    EnterpriseDao enterpriseDao = new EnterpriseDaoImpl();

    //    修改企业信息
    @Override
    public boolean updateEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        int succ = 0;
        boolean rows = enterpriseDao.updateEnterpriseInfo(enterpriseInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }

    //注册
    @Override
    public int intsertEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        int datavalues = 0;
        int rows = enterpriseDao.insertEnterpriseInfo(enterpriseInfo);
        if (rows > 0 ){
            datavalues = 1;
        }else {
            datavalues = 0;
        }
        return datavalues;
    }
}
