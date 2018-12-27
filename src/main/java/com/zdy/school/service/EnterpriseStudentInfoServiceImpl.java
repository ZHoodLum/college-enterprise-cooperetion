package com.zdy.school.service;

import com.zdy.school.dao.EnterpriseStudentInfoDao;
import com.zdy.school.dao.EnterpriseStudentInfoDaoImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


public class EnterpriseStudentInfoServiceImpl implements EnterpriseStudentInfoService {
    EnterpriseStudentInfoDao enterpriseStudentInfoDao = new EnterpriseStudentInfoDaoImpl();
    //根据学生id 企业id进行查询是否存在该条信息
    @Override
//    public boolean QueryByIdEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
//        return enterpriseStudentInfoDao.QueryByIdEnterpriseStudentInfo(enterpriseStudentInfo);
//    }
    public boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId,int jobId) throws Exception{
        return enterpriseStudentInfoDao.QueryByIdEnterpriseStudentInfo(studentId,enterpriseId,jobId);
    }

    //提交简历
    @Override
    public int insertEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        int datevalues = 0;
        int rows = enterpriseStudentInfoDao.insertEnterpriseStudentInfo(enterpriseStudentInfo);
        if (rows > 0) {
            datevalues = 1;
        } else {
            datevalues = 0;
        }
        return rows;
    }

    //企业查询自己的招聘信息（审核查询）
    @Override
    public List<EnterpriseStudentInfo> queryEnterpriseStudentinfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        return enterpriseStudentInfoDao.queryEnterpriseStudentinfo(enterpriseStudentInfo);
    }

    //企业查看简历信息详情
    @Override
    public EnterpriseStudentInfo enterpriseQueryByIdResumesServlet(int id) {
        return enterpriseStudentInfoDao.enterpriseQueryByIdResumesServlet(id);
    }

}
