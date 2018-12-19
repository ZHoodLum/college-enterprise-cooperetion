package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;
import com.zdy.school.vo.StudentInfo;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static sun.misc.MessageUtils.out;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/18
 */


@WebServlet("/StudentSubmitResumesServlet")
public class StudentSubmitResumesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = new StudentInfo();
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        PrintWriter out = response.getWriter();
        try {
//            enterpriseStudentInfo.setStudentId(Integer.parseInt(request.getParameter("student_id")));
//            System.out.println("此登陆用户的学生ID是："+request.getParameter("student_id"));
//            enterpriseStudentInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
//            System.out.println("此招聘信息的ID是"+request.getParameter("enterprise_id"));
            response.sendRedirect("updatesuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
