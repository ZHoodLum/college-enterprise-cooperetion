package com.zdy.school.dao;

import com.zdy.school.vo.JobInfo;
import com.zdy.school.vo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 */


public interface JobInfoDao {
    //    查询全部招聘信息
    ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception;

    //    查找招聘信息详情
    JobInfo findJobInfo(int jobId) throws Exception;

    //    添加招聘信息
    int insertJobInfo(JobInfo jobInfo) throws Exception;

    //根据企业ID查询发布的招聘信息
    ArrayList<JobInfo> findByEnterpriseId(int enterpriseId);

    //企业修改招聘信息（除了信息状态之外，审核状态）
    boolean updateEnterpriseJobInfo01(JobInfo jobInfo);

    //企业修改招信息状态
    boolean updateEnterpriseJobInfo02(JobInfo jobInfo);

    //企业修改招审核状态
    boolean updateEnterpriseJobInfo03(JobInfo jobInfo);

    //根据条件查询企业信息
    List<JobInfo> findAllConditionQueryJobInfo(JobInfo jobInfo);

    //招聘信息进行分页查询
    List<JobInfo> findAllPageJobInfo(int pageNo, int pageSize,String eCheck);
    //数据总数
    int getTotal();
    //学生查询全部的招聘信息
    List<JobInfo> studentFindAllPageJobInfo(int pageNo, int pageSize,String eCheck,String infomationState);

    // 删除
    public boolean deleteJobInfo(int jobId) throws Exception;

}
