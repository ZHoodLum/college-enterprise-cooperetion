package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.EnterpriseStudentInfo;
import com.zdy.school.vo.Resumes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */

public class EnterpriseStudentInfoDaoImpl implements EnterpriseStudentInfoDao {
    PreparedStatement pstate;
    ResultSet rs;
    Connection conn = DruidUtil.getCon();
    boolean flag = false;
    //根据学生id 企业id进行查询是否存在该条信息
    @Override
    public boolean QueryByIdEnterpriseStudentInfo(int studentId,int enterpriseId,int jobId) throws Exception{
        String sql = "select * from enterprise_studentinfo where student_id = ? and enterprise_id = ? and job_id = ?";
        pstate = conn.prepareStatement(sql);
        pstate.setInt(1, studentId);
        pstate.setInt(2, enterpriseId);
        pstate.setInt(3,jobId);
        rs = pstate.executeQuery();
        if(rs.next()) {
            return true;
        }else{
            return false;
        }
    }

    //提交简历信息
    @Override
    public int insertEnterpriseStudentInfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        int rows = 0;
        try {
            String sql = "insert into enterprise_studentinfo(enterprise_id,student_id,job_id) values(?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, enterpriseStudentInfo.getEnterpriseId());
            pstate.setInt(2, enterpriseStudentInfo.getStudentId());
            pstate.setInt(3, enterpriseStudentInfo.getJobId());
            rows = pstate.executeUpdate();
            DruidUtil.closeConnection(rs,conn,pstate);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("提交简历信息出现错误！");
        }
        return rows;
    }

    //企业查询自己的招聘信息（审核查询）
    @Override
    public List<EnterpriseStudentInfo> queryEnterpriseStudentinfo(EnterpriseStudentInfo enterpriseStudentInfo) {
        List<EnterpriseStudentInfo> allEnterpriseStudentInfoArrayList = new ArrayList<EnterpriseStudentInfo>();
        try {
            String sql = "select * from enterprise_studentinfo es, studentinfo s,enterpriseinfo e,jobinfo j,resumes r where es.student_id = s.student_id and es.enterprise_id = e.enterprise_id and es.job_id = j.job_id and s.student_id = r.student_id and j.information_state = 0 and e.enterprise_id = ?;";
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, enterpriseStudentInfo.getEnterpriseId());
            rs = pstate.executeQuery();
            while (rs.next()) {
                enterpriseStudentInfo.setId(rs.getInt("id"));
                enterpriseStudentInfo.setJobId(rs.getInt("job_id"));
                enterpriseStudentInfo.setStudentId(rs.getInt("student_id"));
                enterpriseStudentInfo.setEnterpriseId(rs.getInt("enterprise_id"));
                enterpriseStudentInfo.setStudentName(rs.getString("student_name"));
                enterpriseStudentInfo.setCollege(rs.getString("college"));
                enterpriseStudentInfo.setEducation(rs.getString("education"));
                enterpriseStudentInfo.setMajor(rs.getString("major"));
                enterpriseStudentInfo.setSelfEvaluation(rs.getString("self_evaluation"));
                enterpriseStudentInfo.setGraduateTime(rs.getDate("graduate_time"));
//                System.out.print(rs.getInt("id"));
//                System.out.print(rs.getInt("student_id"));
//                System.out.print(rs.getInt("job_id"));
//                System.out.print(rs.getString("student_name"));
//                System.out.println(rs.getInt("enterprise_id"));
//                System.out.println(rs.getString("college"));
//                System.out.println(rs.getString("self_evaluation"));
//                System.out.println(rs.getString("education"));
//                System.out.println(rs.getString("major"));
                allEnterpriseStudentInfoArrayList.add(enterpriseStudentInfo);
            }
            DruidUtil.closeConnection(rs,conn,pstate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allEnterpriseStudentInfoArrayList;
    }

    //企业查看简历信息详情
    @Override
    public EnterpriseStudentInfo enterpriseQueryByIdResumesServlet(int id) {
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        try {
            String sql = "select  * from enterprise_studentinfo es,studentinfo s,resumes r where es.student_id = s.student_id and r.student_id = s.student_id and es.id  = ?;";
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, id);
            rs = pstate.executeQuery();
            if (rs.next()) {
                flag = true;
                enterpriseStudentInfo.setStudentId(rs.getInt("student_id"));
                enterpriseStudentInfo.setStudentName(rs.getString("student_name"));
                enterpriseStudentInfo.setStudentTel(rs.getString("student_tel"));
                enterpriseStudentInfo.setNationality(rs.getString("nationality"));
                enterpriseStudentInfo.setBirthday(rs.getDate("birthday"));
                enterpriseStudentInfo.setCity(rs.getString("city"));
                enterpriseStudentInfo.setPolitics(rs.getString("politics"));
                enterpriseStudentInfo.setHealth(rs.getString("health"));
                enterpriseStudentInfo.setCollege(rs.getString("college"));
                enterpriseStudentInfo.setEducation(rs.getString("education"));
                enterpriseStudentInfo.setMajor(rs.getString("major"));
                enterpriseStudentInfo.setGraduateTime(rs.getDate("graduate_time"));
                enterpriseStudentInfo.setEmail(rs.getString("email"));
                enterpriseStudentInfo.setMajorCourse(rs.getString("major_course"));
                enterpriseStudentInfo.setCredential(rs.getString("credential"));
                enterpriseStudentInfo.setSelfEvaluation(rs.getString("self_evaluation"));
                enterpriseStudentInfo.setStudentSex(rs.getString("student_sex"));
                enterpriseStudentInfo.setBirthday(rs.getDate("birthday"));
            }
            DruidUtil.closeConnection(rs, conn, pstate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enterpriseStudentInfo;
    }

}
