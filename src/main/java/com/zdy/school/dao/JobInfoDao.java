package com.zdy.school.dao;

import com.zdy.school.vo.JobInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 */


public interface JobInfoDao {
    //    查询全部招聘信息
    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception ;
    //    查找招聘信息详情
    public JobInfo findJobInfo(int jobId) throws Exception ;
    //    添加招聘信息
    public int insertJobInfo(JobInfo jobInfo) throws Exception;
}
