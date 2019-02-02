package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

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


@WebServlet("/AdminDeleteTeacherInfoServlet")
public class AdminDeleteTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        TeacherInfo teacherInfo = new TeacherInfo();
        try {
            int pageNo = Integer.parseInt(request.getParameter("pageNo"));
            teacherInfo.setPageNo(pageNo);
            int teacherId = Integer.parseInt(request.getParameter("teacherId"));
            boolean rows = adminService.deleteTeacherInfo(teacherId);
            if (rows == true) {
                request.getRequestDispatcher("/AdminQueryAllTeacherInfoServlet").forward(request, response);
            } else {
                response.getWriter().print(
                        "<script >alert('修改失败');"
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
