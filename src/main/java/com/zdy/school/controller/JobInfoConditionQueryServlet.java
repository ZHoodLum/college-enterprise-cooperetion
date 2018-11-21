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
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/20
 */

@WebServlet("/JobInfoConditionQueryServlet")
public class JobInfoConditionQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        JobInfo jobInfo = new JobInfo();
        try {
            if (request.getParameter("e_check") != null && !"".equals(request.getParameter("e_check")) ) {
                jobInfo.seteCheck(request.getParameter("e_check"));
                System.out.println("渠道的值111："+request.getParameter("e_check"));
            }
            if (request.getParameter("information_state") != null && !"".equals(request.getParameter("information_state")) ) {
                jobInfo.setInformationState(request.getParameter("information_state"));
                System.out.println("渠道的值222："+request.getParameter("information_state"));
            }
            List<JobInfo> list = jobInfoService.findAllConditionQueryJobInfo(jobInfo);
            request.getSession().setAttribute("jobInfoList", list);
            request.getRequestDispatcher("jsp/company-manage-information.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
