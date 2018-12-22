package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseStudentInfoService;
import com.zdy.school.service.EnterpriseStudentInfoServiceImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/19
 */


@WebServlet("/StudentIdAndEnterpriseIdQueryServlet")
public class StudentIdAndEnterpriseIdQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        EnterpriseStudentInfoService enterpriseStudentInfoService = new EnterpriseStudentInfoServiceImpl();
//        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        enterpriseStudentInfo.setStudentId(studentId);
        enterpriseStudentInfo.setEnterpriseId(enterpriseId);
        System.out.println("前台取到学生ID的值是"+studentId);
        System.out.println("前台取到企业ID的值是"+enterpriseId);
        try {
            boolean flag = enterpriseStudentInfoService.QueryByIdEnterpriseStudentInfo(studentId,enterpriseId);
            if (flag == true) {
                System.out.println("这里在数据库已查到数据！");
                out.write("success");
            } else {
                System.out.println("这里在数据库中没有查到数据！");
                out.write("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
        System.out.println("请求结束！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
