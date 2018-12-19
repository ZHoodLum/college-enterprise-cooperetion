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
 * @ Date       ：Created in 2018/10/11
 */

@WebServlet("/JobInfoQueryServlet")
public class JobInfoQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        JobInfoDao jobInfoDao = new JobInfoDaoImpl();
        JobInfoService jobInfoService = new JobInfoServiceImpl();

        int JobId = Integer.parseInt(request.getParameter("jobid"));
        System.out.println(request.getParameter("jobid"));
        try {
            JobInfo jobInfo = jobInfoService.findJobInfo(JobId);
            request.getSession().setAttribute("job_info",jobInfo.getJobInfo());
            request.getSession().setAttribute("job_position",jobInfo.getJobPosition());
            request.getSession().setAttribute("job_date",jobInfo.getJobDate());
            request.getSession().setAttribute("enterprise_name",jobInfo.getEnterpriseName());
            request.getSession().setAttribute("enterprise_id", jobInfo.getEnterpriseId());
            request.getSession().setAttribute("wage",jobInfo.getWage());
            request.getSession().setAttribute("jobInfo",jobInfo);

//            request.getRequestDispatcher("/jsp/jobinfos").forward(request,response);
            response.sendRedirect("/college-enterprise-cooperetion/jobinfo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
