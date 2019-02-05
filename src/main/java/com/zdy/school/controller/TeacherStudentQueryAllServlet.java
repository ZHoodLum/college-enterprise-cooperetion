package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 * 教师查询旗下所有学生的成绩信息的Servlet
 */

@WebServlet("/TeacherStudentQueryAllServlet")
public class TeacherStudentQueryAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    StudentInfo studentInfo = new StudentInfo();
    EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
    TeacherInfo teacherInfo = new TeacherInfo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        List<StudentInfo> list = studentService.teacherFindAllStudentInfo(teacherId);
        request.getSession().setAttribute("list", list);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/teachermanger-studentscore.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }
}
