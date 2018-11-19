package com.zdy.school.dao;

import com.zdy.school.vo.EnterpriseInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/29
 */


public interface EnterpriseDao {
    //修改企业信息
    boolean updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    //注册企业信息
    int insertEnterpriseInfo(EnterpriseInfo enterpriseInfo);
}
