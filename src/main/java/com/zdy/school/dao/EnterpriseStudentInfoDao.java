package com.zdy.school.dao;

import com.zdy.school.vo.EnterpriseStudentInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


public interface EnterpriseStudentInfoDao {
    //根据学生id 企业id进行查询是否存在该条信息
//    boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo);
    boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId) throws Exception;
}
