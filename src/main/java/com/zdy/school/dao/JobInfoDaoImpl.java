package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.util.PageBean;
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

    //根据条件查询企业信息
    @Override
    public ArrayList<JobInfo> findAllConditionQueryJobInfo(JobInfo jobInfo) {
//        List<StudentInfo> list = new ArrayList<StudentInfo>();
//        StringBuilder sql = new StringBuilder();
//        sql.append("select *");
//        sql.append("from studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e ");
//        sql.append("where c.class_id = s.class_id ");
//        sql.append("and t.teacher_id = s.teacher_id ");
//        sql.append("and e.enterprise_id = es.enterprise_id ");
//        sql.append("and  s.student_id = es.student_id ");
//        if (studentInfo.getStudentAccount() != null && !"".equals(studentInfo.getStudentAccount())){
//            sql.append("and s.student_account = ? ");
//        }
//        if (studentInfo.getStudentTel() != null && !"".equals(studentInfo.getStudentTel())){
//            sql.append("and s.student_tel = ? ");
//        }
//        if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
//            sql.append("and s.class_id = ? ");
//        }
////        String  sql = "select * from studentinfo s,teacherinfo t,classinfo c,enterprise_studentinfo es,enterpriseinfo e where c.class_id = s.class_id and t.teacher_id = s.teacher_id and e.enterprise_id = es.enterprise_id and  s.student_id = es.student_id and s.student_tel = ?;";
//        try{
//            pstate = con.prepareStatement(sql.toString());
//            int i = 1;
//            if (studentInfo.getStudentAccount() != null && !"".equals(studentInfo.getStudentAccount())){
//                pstate.setInt(i, studentInfo.getStudentAccount());
//                i++;
//            }
//            if (studentInfo.getStudentTel() != null && !"".equals(studentInfo.getStudentTel())){
//                pstate.setString(1, studentInfo.getStudentTel());
//                i++;
//            }
//            if (studentInfo.getClassId() != null && !"".equals(studentInfo.getClassId()) && !"0".equals(studentInfo.getClassId())){
//                pstate.setInt(i, studentInfo.getClassId());
//                i++;
//            }
//            rs = pstate.executeQuery();
//            while (rs.next()){
//                studentInfo = new StudentInfo();
////                TeacherInfo teacherInfo = new TeacherInfo();
////                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
////                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
//                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
//                studentInfo.setStudentId(rs.getInt("student_id"));
//                studentInfo.setStudentAccount(rs.getInt("student_account"));
//                studentInfo.setStudentName(rs.getString("student_name"));
//                studentInfo.setStudentTel(rs.getString("student_tel"));
//                studentInfo.setStudentPassword(rs.getString("student_password"));
//                studentInfo.setStudentSex(rs.getString("student_sex"));
//                studentInfo.setMajor(rs.getString("major"));
//                studentInfo.setCity(rs.getString("city"));
//                studentInfo.setEmail(rs.getString("email"));
//                studentInfo.setStudentCollege(rs.getString("student_college"));
//                studentInfo.setStudentInternship(rs.getString("student_internship"));
//                studentInfo.setStudentGrade(rs.getInt("student_grade"));
//                studentInfo.setClassId(rs.getInt("class_id"));
//                studentInfo.setClassName(rs.getString("class_name"));
//                studentInfo.setTeacherId(rs.getInt("teacher_id"));
//                studentInfo.setTeacherName(rs.getString("teacher_name"));
////                studentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
////                studentInfo.setEnterpriseName(rs.getString("enterprise_name"));
//                list.add(studentInfo);
////                for(StudentInfo li:list) {
////                    System.out.println("集合元素有："+list);
////                }
//            }
////            DruidUtil.closeConnection(rs,con,pstate);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
        return null;
    }




}
