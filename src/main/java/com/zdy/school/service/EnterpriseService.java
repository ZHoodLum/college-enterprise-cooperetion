package com.zdy.school.service;

import com.zdy.school.vo.EnterpriseInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/29
 */


public interface EnterpriseService {
    //修改企业管理员信息
    boolean updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    //注册企业信息
    int intsertEnterpriseInfo(EnterpriseInfo enterpriseInfo);
}
