package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.service.TeacherService;
import com.zdy.school.service.TeacherServiceImpl;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/10
 */

@WebServlet("/TeacherInfoQueryAllServlet")
public class TeacherInfoQueryAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherInfo teacherInfo = new TeacherInfo();
        try {
            ArrayList<TeacherInfo> list = teacherService.queryAllTeacherInfo(teacherInfo);
            request.getSession().setAttribute("teacher_name",teacherInfo.getTeacherName());
            request.getSession().setAttribute("list", list);
//            request.getRequestDispatcher("/jsp/update-student-information.jsp").forward(request,response);
            response.sendRedirect("/college-enterprise-cooperetion/jsp/update-student-information.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
