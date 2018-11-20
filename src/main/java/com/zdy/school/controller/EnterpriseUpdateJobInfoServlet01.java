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
 * @ Date       ：Created in 2018/11/20
 */

@WebServlet("/EnterpriseUpdateJobInfoServlet01")
public class EnterpriseUpdateJobInfoServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        JobInfo jobInfo = new JobInfo();

        jobInfo.setJobId(Integer.parseInt(request.getParameter("job_id")));
        jobInfo.setJobPosition(request.getParameter("job_position"));
        jobInfo.setJobInfo(request.getParameter("job_info"));
        jobInfo.setWage(request.getParameter("wage"));
        jobInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
        try {
            boolean succ = jobInfoService.updateEnterpriseJobInfo01(jobInfo);
            if (succ = true){
                request.getRequestDispatcher("/information-update.html").forward(request,response);
//                response.sendRedirect("JobInfoQueryByEnterpriseIdServlet");
            }else {
                System.out.println("succ="+succ);
                response.getWriter().print(
                        "<script >alert('修改失败');"
                                + "history.go(-1);"
                                + "</script>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
