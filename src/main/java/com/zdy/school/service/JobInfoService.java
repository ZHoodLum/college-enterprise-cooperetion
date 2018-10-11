package com.zdy.school.service;

import com.zdy.school.dao.JobInfoDao;
import com.zdy.school.vo.JobInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/9
 */


public class JobInfoService {
    JobInfoDao jobInfoDao = new JobInfoDao();

    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception {
        return jobInfoDao.finAllJobInfo(jobInfo);
    }
    public JobInfo findJobInfo(int JobId) throws Exception{
        return jobInfoDao.findJobInfo(JobId);
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

}
