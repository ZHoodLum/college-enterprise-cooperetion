package com.zdy.school.controller;

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
 *  //  查看招聘信息详情
 *  根据招聘信息主键ID进行查询  并查看其详细信息
 */

@WebServlet("/EnterpriseJobInfoQueryByIdServlet")
public class EnterpriseJobInfoQueryByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        JobInfoDao jobInfoDao = new JobInfoDaoImpl();
        JobInfoService jobInfoDao = new JobInfoServiceImpl();

        int JobId = Integer.parseInt(request.getParameter("jobid"));
        try {
            JobInfo jobInfo = jobInfoDao.findJobInfo(JobId);
            request.getSession().setAttribute("job_info",jobInfo.getJobInfo());
            request.getSession().setAttribute("job_position",jobInfo.getJobPosition());
            request.getSession().setAttribute("job_date",jobInfo.getJobDate());
            request.getSession().setAttribute("enterprise_name",jobInfo.getEnterpriseName());
            request.getSession().setAttribute("wage",jobInfo.getWage());
            request.getSession().setAttribute("enterprise_address", jobInfo.getEnterpriseAddress());
            request.getSession().setAttribute("enterprise_tel", jobInfo.getEnterpriseTel());
            request.getSession().setAttribute("email", jobInfo.getEmail());
            request.getSession().setAttribute("jobInfo",jobInfo);

//            request.getRequestDispatcher("/jsp/jobinfos").forward(request,response);
            response.sendRedirect("/college-enterprise-cooperetion/jsp/company-update-jobinfo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
