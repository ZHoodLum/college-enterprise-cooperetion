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
        response.setContentType("application/json;charset=UTF-8");
        JobInfo jobInfo = new JobInfo();
        PrintWriter out = response.getWriter();
        jobInfo.setInformationState(request.getParameter("informationState"));
        jobInfo.setJobId(Integer.parseInt(request.getParameter("jobId")));
//        jobInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
//        System.out.println("前台取到信息ID的值是"+Integer.parseInt(request.getParameter("enterprise_id")));
        System.out.println("前台取到状态的值是"+request.getParameter("informationState"));
        System.out.println("前台取到信息ID的值是"+Integer.parseInt(request.getParameter("jobId")));
        try {
            boolean succ = jobInfoService.updateEnterpriseJobInfo02(jobInfo);
            if (succ = true){
                out.print("success");
//                out.write("success");
            }else {
                out.print("false");
            }
        }catch (Exception e){
            e.printStackTrace();
//            out.flush();
//            out.close();
        }
    }
}
//    JobInfoService jobInfoService = new JobInfoServiceImpl();
//    //        response.setContentType("application/json;charset=UTF-8");
//    JobInfo jobInfo = new JobInfo();
//    String datas=request.getParameter("informationState");
//    int jobId = Integer.parseInt(request.getParameter("jobId"));
//        System.out.println("前台取到状态的值是"+datas);
//                System.out.println("前台取到信息ID的值是"+jobId);
//                jobInfo.setInformationState(datas);
//                jobInfo.setJobId(jobId);
//                jobInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
//                System.out.println("前台取到信息ID的值是"+Integer.parseInt(request.getParameter("enterprise_id")));
//
//                try {
//                boolean succ = jobInfoService.updateEnterpriseJobInfo02(jobInfo);
//                if (succ = true){
////                response.sendRedirect("EnterpriseUpdateJobInfoServlet01");
//                response.getWriter().print(
//                "<script >alert('修改sss');"
//                + "</script>");
//                }else {
//                System.out.println("succ="+succ);
//                response.getWriter().print(
//                "<script >alert('修改失败');"
//                + "history.go(-1);"
//                + "</script>");
//                }
//                }catch (Exception e){
//                e.printStackTrace();
////            out.flush();
////            out.close();
//                }