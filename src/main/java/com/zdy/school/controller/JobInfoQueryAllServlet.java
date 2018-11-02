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
import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/9
 */

@WebServlet("/JobInfoQueryAllServlet")
public class JobInfoQueryAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JobInfo jobInfo = new JobInfo();
//        JobInfoDao jobInfoDao = new JobInfoDaoImpl();
        JobInfoService jobInfoService = new JobInfoServiceImpl();

        try {

            ArrayList<JobInfo> allJobInfo = jobInfoService.findAllJobInfo(jobInfo);
            request.getSession().setAttribute("allJobInfo",allJobInfo);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        JobInfo jobInfo = new JobInfo();
//        jobInfo.setJob_id(111);
//        jobInfo.setJbo_info("ssss");
//        jobInfo.setEnterprise_name("sdafag");
//        jobInfo.setWage("2222222");
//        //放到list集合中
//        List<JobInfo> jobInfos = new ArrayList<JobInfo>();
//        jobInfos.add(jobInfo);
//
//        request.setAttribute("jobInfo", jobInfos);
//        response.sendRedirect("/main.jsp");
    }
}
