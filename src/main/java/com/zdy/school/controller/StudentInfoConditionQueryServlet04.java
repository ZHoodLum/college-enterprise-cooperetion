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
 * 企业查询学生成绩信息
 * 根据学生电话进行查询 跳转student-score.jsp界面
 */
@WebServlet("/StudentInfoConditionQueryServlet04")
public class StudentInfoConditionQueryServlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo studentInfo = new StudentInfo();
        if (!"" .equals(request.getParameter("studentTel"))) {
            studentInfo.setStudentTel(request.getParameter("studentTel"));
        }
        List<StudentInfo> list = studentService.conditionFindAllStudentInfo(studentInfo);
        request.getSession().setAttribute("list", list);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/student-score.jsp");
//        request.getRequestDispatcher("/jsp/student-informations.jsp").forward(request,response);
    }
}
