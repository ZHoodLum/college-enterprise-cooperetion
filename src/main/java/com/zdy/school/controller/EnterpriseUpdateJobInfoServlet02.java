package com.zdy.school.controller;

import com.zdy.school.service.JobInfoService;
import com.zdy.school.service.JobInfoServiceImpl;
import com.zdy.school.vo.JobInfo;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlFormatName.JSON;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/20
 * 企业修改招聘信息的信息状态  比如是：已结束或者正在招聘
 */

@WebServlet("/EnterpriseUpdateJobInfoServlet02")
public class EnterpriseUpdateJobInfoServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobInfoService jobInfoService = new JobInfoServiceImpl();
        JobInfo jobInfo = new JobInfo();
        PrintWriter out = response.getWriter();

        String data=request.getParameter("data");
        int jobId = Integer.parseInt(request.getParameter("jobId"));
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        System.out.println("我取到的值"+data+",,,,,,,,,,"+jobId);
        jobInfo.setInformationState(data);
        jobInfo.setJobId(jobId);
        try {
            boolean succ = jobInfoService.updateEnterpriseJobInfo02(jobInfo);
            if (succ = true){
                out.print("true");
            }else {
                out.print("false");
            }
        }catch (Exception e){
            e.printStackTrace();
            out.flush();
            out.close();
        }
    }
}
