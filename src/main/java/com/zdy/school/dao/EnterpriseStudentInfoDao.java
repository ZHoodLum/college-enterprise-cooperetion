package com.zdy.school.dao;

import com.zdy.school.vo.EnterpriseStudentInfo;
import com.zdy.school.vo.Resumes;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


public interface EnterpriseStudentInfoDao {
    //根据学生id 企业id进行查询是否存在该条信息
//    boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo);
    boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId,int jobId) throws Exception;

    //提交简历
    public int insertEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo);

    //企业查询自己的招聘信息（审核查询）
    public List<EnterpriseStudentInfo> queryEnterpriseStudentinfo(int enterpriseId);

    //企业查看简历信息详情
    public EnterpriseStudentInfo enterpriseQueryByIdResumesServlet(int id);

    //审核学生简历  修改简历信息的状态——通过
    public boolean ResumesUpdate(EnterpriseStudentInfo enterpriseStudentInfo);

    //审核简历信息——不通过
    public boolean ResumesDelete(int id) throws Exception;
}
