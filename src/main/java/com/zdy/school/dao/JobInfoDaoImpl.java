package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.util.PageBean;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.JobInfo;
import com.zdy.school.vo.StudentInfo;
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
    public ArrayList<JobInfo> findAllJobInfo(JobInfo jobInfo) {
        ArrayList<JobInfo> allJobInfo = new ArrayList<JobInfo>();
        try {
            String sql = "select * from jobinfo j ,enterpriseinfo e limit 0,5";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                flag = true;
                jobInfo = new JobInfo();
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.setWage(rs.getString("wage"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfo.setEnterpriseAddress(rs.getString("enterprise_address"));
                jobInfo.setEnterpriseTel(rs.getString("enterprise_tel"));
                jobInfo.setEmail(rs.getString("email"));
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

//    根据招聘信息ID查找招聘信息详情
    public JobInfo findJobInfo(int jobId) throws Exception {
        JobInfo jobInfo = new JobInfo();
        try {
            String sql = "select * from jobinfo j,enterpriseinfo e where j.enterprise_id = e.enterprise_id  and job_id = ?";
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
                jobInfo.seteCheck(rs.getString("e_check"));
                jobInfo.setWage(rs.getString("wage"));
                jobInfo.setInformationState(rs.getString("information_state"));
                jobInfo.setEnterpriseAddress(rs.getString("enterprise_address"));
                jobInfo.setEnterpriseTel(rs.getString("enterprise_tel"));
                jobInfo.setEmail(rs.getString("email"));
            }
            DruidUtil.closeConnection(rs, con, pstate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobInfo;
    }

//添加招聘信息
    public int insertJobInfo(JobInfo jobInfo) {
        int rows = 0;
        try {
            String sql = "insert into jobinfo(job_info,job_position,wage,enterprise_id) values(?,?,?,?)";
            pstate = con.prepareStatement(sql);
            pstate.setString(1,jobInfo.getJobInfo());
            pstate.setString(2,jobInfo.getJobPosition());
            pstate.setString(3,jobInfo.getWage());
            pstate.setInt(4,jobInfo.getEnterpriseId());
            rows = pstate.executeUpdate();
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入招聘信息出现错误！");
        }
        return rows;
    }

    //根据企业ID进行查询
    @Override
    public ArrayList<JobInfo> findByEnterpriseId(int enterpriseId) {
        ArrayList<JobInfo> jobInfoList = new ArrayList<JobInfo>();
        try {
            String sql = "select * from jobinfo j,enterpriseinfo e where j.enterprise_id = e.enterprise_id and e.enterprise_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1,enterpriseId);
            rs = pstate.executeQuery();
            while (rs.next()) {
                flag = true;
                JobInfo jobInfo = new JobInfo();
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.setWage(rs.getString("wage"));
                jobInfo.seteCheck(rs.getString("e_check"));
                jobInfo.setInformationState(rs.getString("information_state"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfoList.add(jobInfo);
            }
            DruidUtil.closeConnection(rs, con, pstate);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobInfoList;
    }

    //企业修改招聘信息（除了信息状态之外）
    @Override
    public boolean updateEnterpriseJobInfo01(JobInfo jobInfo) {
        int rows = 0;
        try {
            String sql = "update jobinfo set job_info = ?,job_position = ?,wage = ?,enterprise_id = ? where job_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setString(1, jobInfo.getJobInfo());
            pstate.setString(2, jobInfo.getJobPosition());
            pstate.setString(3, jobInfo.getWage());
            pstate.setInt(4,jobInfo.getEnterpriseId());
            pstate.setInt(5, jobInfo.getJobId());
            rows = pstate.executeUpdate();
            if (rows>0){
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //企业修改招聘信息状态
    @Override
    public boolean updateEnterpriseJobInfo02(JobInfo jobInfo) {
        int rows = 0;
        try {
            String sql = "update jobinfo set information_state = ? where job_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setString(1, jobInfo.getInformationState());
            pstate.setInt(2, jobInfo.getJobId());
            rows = pstate.executeUpdate();
            if (rows>0){
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateEnterpriseJobInfo03(JobInfo jobInfo) {
        int rows = 0;
        try {
            String sql = "update jobinfo set e_check = ? where job_id = ?";
            pstate = con.prepareStatement(sql);
            pstate.setString(1, jobInfo.geteCheck());
            pstate.setInt(2, jobInfo.getJobId());
            rows = pstate.executeUpdate();
            if (rows>0){
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //根据条件查询企业信息
    @Override
    public List<JobInfo> findAllConditionQueryJobInfo(JobInfo jobInfo) {
        List<JobInfo> list = new ArrayList<JobInfo>();

            StringBuilder sql = new StringBuilder();
            sql.append("select *");
            sql.append(" from jobinfo j,enterpriseinfo e ");
            sql.append(" where j.enterprise_id = e.enterprise_id  ");
            if (jobInfo.geteCheck() != null && !"".equals(jobInfo.geteCheck()) ) {
                sql.append(" and j.e_check = ? ");
            }
            if (jobInfo.getInformationState() != null && !"".equals(jobInfo.getInformationState())) {
                sql.append(" and j.information_state = ? ");
            }
        try {
            pstate = con.prepareStatement(sql.toString());
            int i = 1;
            // && !"-1".equals(jobInfo.geteCheck())
            if (jobInfo.geteCheck() != null && !"".equals(jobInfo.geteCheck()) ) {
                pstate.setString(i,jobInfo.geteCheck());
                i++;
            }
            //  && !"-1".equals(jobInfo.getInformationState())
            if (jobInfo.getInformationState() != null && !"".equals(jobInfo.getInformationState())) {
                pstate.setString(i,jobInfo.getInformationState());
                i++;
            }
            rs = pstate.executeQuery();
            while (rs.next()) {
                jobInfo = new JobInfo();
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.seteCheck(rs.getString("e_check"));
                jobInfo.setWage(rs.getString("wage"));
                jobInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfo.setInformationState(rs.getString("information_state"));
                list.add(jobInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //分页查询
    @Override
    public List<JobInfo> findAllPageJobInfo(int pageNo, int pageSize, String eCheck) {
        List<JobInfo> allJobInfoList = new ArrayList<JobInfo>();
        String sql = "select * from  jobinfo j,enterpriseinfo e where j.enterprise_id = e.enterprise_id and e_check = ?  limit ?,?;";
        try{
            pstate = con.prepareStatement(sql);
            pstate.setString(1,eCheck);
            pstate.setInt(2,(pageNo-1)*pageSize);
            pstate.setInt(3,pageSize);
            rs = pstate.executeQuery();
            while (rs.next()){
                JobInfo jobInfo = new JobInfo();
                jobInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                jobInfo.setEnterpriseName(rs.getString("enterprise_name"));
                jobInfo.setJobId(rs.getInt("job_id"));
                jobInfo.setJobInfo(rs.getString("job_info"));
                jobInfo.setJobPosition(rs.getString("job_position"));
                jobInfo.setJobDate(rs.getDate("job_date"));
                jobInfo.seteCheck(rs.getString("e_check"));
                jobInfo.setWage(rs.getString("wage"));
                allJobInfoList.add(jobInfo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allJobInfoList;
    }
    //查询数据总量
    @Override
    public int getTotal() {
        String sql = "select count(*) c from jobinfo";
        int n = 0;
        try{
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            if (rs.next()){
                n = rs.getInt("c");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    //删除
    @Override
    public boolean deleteJobInfo(int jobId) throws Exception {
        try {
            String sql = "delete from jobinfo where job_id=?";
            pstate = con.prepareStatement(sql);
            pstate.setInt(1, jobId);
            int c = pstate.executeUpdate();
            if (c > 0) {
                flag = true;
            }
            DruidUtil.closeConnection(rs,con,pstate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


}
