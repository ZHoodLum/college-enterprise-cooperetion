package com.zdy.school.service;

import com.zdy.school.vo.JobInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 */


public interface JobInfoService {
    //  查看全部招聘信息
    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception ;
    //  查看招聘信息详情
    public JobInfo findJobInfo(int jobId) throws Exception;
    //  添加招聘信息
    public int insertJobInfo(JobInfo jobInfo) throws Exception;
}
