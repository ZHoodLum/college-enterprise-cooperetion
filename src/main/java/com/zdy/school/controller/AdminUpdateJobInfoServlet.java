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
 * @ Date       ：Created in 2018/11/25
 * 管理员查询未企业审核得招聘信息  根据eCheck = 1进行查询
 */


@WebServlet("/AdminUpdateJobInfoServlet")
public class AdminUpdateJobInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        JobInfo jobInfo = new JobInfo();

        jobInfo.setJobId(Integer.parseInt(request.getParameter("jobId")));

        jobInfo.seteCheck(request.getParameter("eCheck"));

        try {
            boolean rows = jobInfoService.updateEnterpriseJobInfo03(jobInfo);
            if (rows = true){
                request.getRequestDispatcher("/information-update.html").forward(request,response);
            }else {
                System.out.println("rows="+rows);
                response.getWriter().print(
                        "<script >alert('修改失败');"
                                + "history.go(-1);"
                                + "</script>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
