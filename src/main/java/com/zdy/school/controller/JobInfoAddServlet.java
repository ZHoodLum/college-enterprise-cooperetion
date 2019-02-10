package com.zdy.school.controller;

import com.zdy.school.dao.JobInfoDao;
import com.zdy.school.dao.JobInfoDaoImpl;
import com.zdy.school.service.JobInfoService;
import com.zdy.school.service.JobInfoServiceImpl;
import com.zdy.school.vo.JobInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/13
 */
@WebServlet("/JobInfoAddServlet")
public class JobInfoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JobInfo jobInfo = new JobInfo();
//        JobInfoDao jobInfoDao = new JobInfoDaoImpl();
        JobInfoService jobInfoDao = new JobInfoServiceImpl();

        jobInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
        jobInfo.setEnterpriseName(request.getParameter("enterprise_name"));
        System.out.println(request.getParameter("enterprise_name"));
        jobInfo.setJobInfo(request.getParameter("job_info"));
        jobInfo.setJobPosition(request.getParameter("job_position"));
        jobInfo.setWage(request.getParameter("wage"));

        try{
            int datevalues = jobInfoDao.insertJobInfo(jobInfo);
            if (datevalues > 0){
                request.getRequestDispatcher("/jobinfoaddsuccess.html").forward(request,response);
            }else {
                response.getWriter().print(
                        "<script >alert('录入招聘信息失败！');"
                                + "</script>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
