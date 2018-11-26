package com.zdy.school.controller;

import com.zdy.school.service.JobInfoService;
import com.zdy.school.service.JobInfoServiceImpl;
import com.zdy.school.vo.JobInfo;
import com.zdy.school.vo.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/25
 */


@WebServlet("/JobInfoQueryAllManageServlet")
public class JobInfoQueryAllManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        JobInfo jobInfo = new JobInfo();
        try {
            String eCheck =  "1";
            int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        //  默认每页数据量数
            int pageSize = 2;

            List<JobInfo> allJobInfoList = jobInfoService.findAllPageJobInfo(pageNo,pageSize,eCheck);
            int n = jobInfoService.getTotal();
            request.getSession().setAttribute("allJobInfoList", allJobInfoList);
            request.getSession().setAttribute("n", n);
            request.getSession().setAttribute("pageSize", pageSize);
            request.getSession().setAttribute("pageNo", pageNo);

            response.sendRedirect("/college-enterprise-cooperetion/jsp/application-company-information.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
