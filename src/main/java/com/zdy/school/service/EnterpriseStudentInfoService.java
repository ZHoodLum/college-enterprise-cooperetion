package com.zdy.school.service;

import com.zdy.school.vo.EnterpriseStudentInfo;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


public interface EnterpriseStudentInfoService {
    //根据学生id 企业id进行查询是否存在该条信息
//    boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo);
    boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId,int jobId) throws Exception;

    //提交简历
    public int insertEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo);

    //企业查询自己的招聘信息（审核查询）
    public List<EnterpriseStudentInfo> queryEnterpriseStudentinfo(EnterpriseStudentInfo enterpriseStudentInfo);
}
