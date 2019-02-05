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
 * 根据ID查询信息  用于修改
 */


@WebServlet("/AdminGetByIdTeacherInfoServlet")
public class AdminGetByIdTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        try {
            int teacherId = Integer.parseInt(request.getParameter("teacherId"));
            TeacherInfo list = adminService.queryGetByIdTeacherInfo(teacherId);
            request.getSession().setAttribute("list", list);
            response.sendRedirect("/college-enterprise-cooperetion/jsp/manger-update-teacherinfo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
