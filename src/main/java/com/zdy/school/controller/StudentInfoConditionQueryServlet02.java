package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/9
 * 教师查询实习学生的成绩及其信息
 * 可以根据学生电话、学生学号进行一个或多个条件进行查询
 */
@WebServlet("/StudentInfoConditionQueryServlet02")
public class StudentInfoConditionQueryServlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo studentInfo = new StudentInfo();
        if (!"" .equals(request.getParameter("studentTel"))) {
            studentInfo.setStudentTel(request.getParameter("studentTel"));
        }
        if (!"" .equals(request.getParameter("studentAccount"))) {
            studentInfo.setStudentAccount(Integer.parseInt(request.getParameter("studentAccount")));
        }
        List<StudentInfo> list = studentService.conditionFindAllStudentInfo(studentInfo);
        request.getSession().setAttribute("list", list);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/teachermanger-studentscore.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
