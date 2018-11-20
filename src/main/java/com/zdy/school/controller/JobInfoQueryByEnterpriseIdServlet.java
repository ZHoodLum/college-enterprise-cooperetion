package com.zdy.school.controller;

import com.zdy.school.service.JobInfoService;
import com.zdy.school.service.JobInfoServiceImpl;
import com.zdy.school.vo.JobInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/20
 */

@WebServlet("/JobInfoQueryByEnterpriseIdServlet")
public class JobInfoQueryByEnterpriseIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfo jobInfo = new JobInfo();
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        try {
            ArrayList<JobInfo> jobInfoList = jobInfoService.findByEnterpriseId(enterpriseId);
            request.getSession().setAttribute("jobInfoList",jobInfoList);
//            response.sendRedirect("/college-enterprise-cooperetion/jobinfo.jsp");
            request.getRequestDispatcher("/jsp/company-manage-information.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
