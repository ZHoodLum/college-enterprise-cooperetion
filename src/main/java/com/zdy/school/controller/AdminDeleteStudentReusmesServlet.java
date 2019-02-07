package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.vo.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2019/1/22
 */


@WebServlet("/AdminDeleteStudentReusmesServlet")
public class AdminDeleteStudentReusmesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        StudentInfo studentInfo = new StudentInfo();
        try {
            int pageNo = Integer.parseInt(request.getParameter("pageNo"));
            studentInfo.setPageNo(pageNo);
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            studentInfo.setStudentId(studentId);
            boolean rows = adminService.deleteStudentResumes(studentId);
            if (rows == true) {
                request.getRequestDispatcher("/AdminQueryAllStudentInfoServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("/AdminQueryAllStudentInfoServlet").forward(request, response);
                response.getWriter().print(
                        "<script >alert('数据是最新版本！');"
                                + "</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
