package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseStudentInfoService;
import com.zdy.school.service.EnterpriseStudentInfoServiceImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;
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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        enterpriseStudentInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterpriseId")));
        enterpriseStudentInfo.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        System.out.println("前台取到企业ID的值是"+request.getParameter("enterpriseId"));
        System.out.println("前台取到学生ID的值是"+request.getParameter("studentId"));
        try {
//            boolean succ = enterpriseStudentInfoService.QueryByIdEnterpriseStudentInfo(enterpriseStudentInfo);
//            if (succ = true){
//                out.print("success");
//            }else {
//                out.print("false");
//            }
            System.out.println("aaaaaa");
            if (enterpriseStudentInfoService.QueryByIdEnterpriseStudentInfo(enterpriseStudentInfo)) {
                System.out.println("bbbbbbbb");
                out.write("success");
            } else {
                out.write("error");
                System.out.println("cccc");

            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
