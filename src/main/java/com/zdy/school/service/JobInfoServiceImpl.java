package com.zdy.school.service;

import com.zdy.school.dao.JobInfoDao;
import com.zdy.school.dao.JobInfoDaoImpl;
import com.zdy.school.vo.JobInfo;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/9
 */


public class JobInfoServiceImpl implements JobInfoService {
    JobInfoDao jobInfoDao = new JobInfoDaoImpl();
//    查询全部招聘信息
    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception {
        return jobInfoDao.findAllJobInfo(jobInfo);
    }

    //    public PageBean findPageBean(PageBean pageBean) throws SQLException {
//        PageBeanDao pageBeanDao = new PageBeanDao();
//        // 查询 展示的信息
//        PageBean pagebean1=pageBeanDao.findPageBean(pageBean.getCurrentPage(), pageBean.getCurrentCount());
//        // 一共有多少条
//        int totalcount =pageBeanDao.findtotal();
//        //一共有多少页
//        int totalpage=(int) Math.ceil((double)totalcount/(double)pageBean.getCurrentCount());
//
//        pagebean1.setTotalCount(totalcount);
//        pagebean1.setTotalpage(totalpage);
//        pagebean1.setCurrentCount(pageBean.getCurrentCount());
//        pagebean1.setCurrentPage(pageBean.getCurrentPage());
//
//        return pagebean1;
//    }
//  查看招聘信息详情
    public JobInfo findJobInfo(int jobId) throws Exception {
        return jobInfoDao.findJobInfo(jobId);
    }
//    添加招聘信息
    public int insertJobInfo(JobInfo jobInfo) throws Exception{
        int datevalues = 0;
        int rows = jobInfoDao.insertJobInfo(jobInfo);
        if (rows>0){
            datevalues = 1;
        }else {
            datevalues = 0;
        }
        return rows;
    }

    //  企业查看自己发布的招聘信息
    @Override
    public ArrayList<JobInfo> findByEnterpriseId(int enterpriseId) {
        return jobInfoDao.findByEnterpriseId(enterpriseId);
    }

    //企业修改招聘信息（除了信息状态之外）
    @Override
    public boolean updateEnterpriseJobInfo01(JobInfo jobInfo) {
        int succ = 0;
        boolean rows = jobInfoDao.updateEnterpriseJobInfo01(jobInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }

    @Override
    public List<JobInfo> findAllConditionQueryJobInfo(JobInfo jobInfo) {
        List<JobInfo> list = jobInfoDao.findAllConditionQueryJobInfo(jobInfo);
        return list;
    }


}
