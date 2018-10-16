package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.util.PageBean;
import com.zdy.school.vo.JobInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/9
 */


public class JobInfoDaoImpl implements JobInfoDao{
    PreparedStatement pstate;
    ResultSet rs;
    boolean flag = false;
    Connection con = DruidUtil.getCon();
//    查询全部招聘信息
    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) throws Exception {
        ArrayList<JobInfo> allJobInfo = new ArrayList<JobInfo>();
        try {
            String sql = "select job_id,job_info,job_position,job_date,enterprise_name,e_check,wage from jobinfo limit 0,5";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                flag = true;
                jobInfo = new JobInfo();
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfo.setECheck(rs.getString("e_check"));
                jobInfo.setWage(rs.getString("wage"));
                allJobInfo.add(jobInfo);
            }
            DruidUtil.closeConnection(rs, con, pstate);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allJobInfo;
    }
//    public PageBean findPageBean(int currentPage, int currenCount) throws SQLException {
//        QueryRunner qr=new QueryRunner(DruidUtil.getDatasource());
//        String sql="select k.userid,k.account,k.username,k.password,k.gender from(select rownum rn,n.*  from (select t.*   from usersinfo t   order by userid  ) n ) k where rn<="+currentPage*currenCount +" and rn>="+((currentPage-1)*currenCount+1)+" ";
//        System.out.println(sql);
//        List<JobInfo> list=	qr.query(sql, new BeanListHandler<JobInfo>(JobInfo.class));
//
//        PageBean pageBean = new PageBean();
//
//        for(JobInfo user:list) {
//            System.out.println(user);
//        }
//        pageBean.setJavabeanlist(list);
//        return pageBean;
//    }
//
//    public int findtotal() throws SQLException {
//
//        Connection connection =DruidUtil.getCon();
//        PreparedStatement pst=connection.prepareStatement("select count(userid) count from usersinfo");
//        ResultSet rs=pst.executeQuery();
//        int i=0;
//        if(rs.next()) {
//            i=rs.getInt("count");
//        }
//        return i;
//    }

//    查找招聘信息详情
    public JobInfo findJobInfo(int jobId) throws Exception {
        JobInfo jobInfo = new JobInfo();
        try {
            String sql = "select job_id,job_info,job_position,job_date,enterprise_name,e_check,wage from jobinfo where job_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, jobId);
            rs = pstate.executeQuery();
            if (rs.next()) {
                flag = true;
                jobInfo = new JobInfo();
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfo.setECheck(rs.getString("e_check"));
                jobInfo.setWage(rs.getString("wage"));
            }
            DruidUtil.closeConnection(rs, con, pstate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobInfo;
    }

//添加招聘信息
    public int insertJobInfo(JobInfo jobInfo) throws Exception{
        int rows = 0;
        try {
            String sql = "insert into jobinfo(job_info,job_position,enterprise_name,wage) values(?,?,?,?)";
            pstate = con.prepareStatement(sql);
            pstate.setString(1,jobInfo.getJobInfo());
            pstate.setString(2,jobInfo.getJobPosition());
            pstate.setString(3,jobInfo.getEnterpriseName());
            pstate.setString(4,jobInfo.getWage());
            rows = pstate.executeUpdate();
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入招聘信息出现错误！");
        }
        return rows;
    }




}
