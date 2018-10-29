package com.zdy.school.dao;

import com.zdy.school.vo.EnterpriseInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/29
 */


public interface EnterpriseDao {
    //修改企业信息
    public boolean updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);
}
