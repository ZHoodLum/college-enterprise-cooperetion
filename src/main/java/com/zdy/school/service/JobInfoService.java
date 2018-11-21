package com.zdy.school.service;

import com.zdy.school.vo.JobInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 */


public interface JobInfoService {
    //  查看全部招聘信息
    ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception;

    //  查看招聘信息详情
    JobInfo findJobInfo(int jobId) throws Exception;

    //  添加招聘信息
    int insertJobInfo(JobInfo jobInfo) throws Exception;

    //根据企业ID查询发布的招聘信息
    ArrayList<JobInfo> findByEnterpriseId(int enterpriseId);

    //企业修改招聘信息（除了信息状态之外）
    boolean updateEnterpriseJobInfo01(JobInfo jobInfo);

    //根据条件查询企业信息
    List<JobInfo> findAllConditionQueryJobInfo(JobInfo jobInfo);
}
