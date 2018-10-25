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
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/17
 */

@WebServlet("/StudentQueryAllServlet")
public class StudentQueryAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        StudentInfo studentInfo = new StudentInfo();
//        StudentService studentService = new StudentServiceImpl();
//        try{
//            ArrayList<StudentInfo> allStudent = studentService.findAllStudentInfo(studentInfo);
//            request.getSession().setAttribute("allStudent",allStudent);
////            request.getRequestDispatcher("/jsp/student-information.jsp").forward(request,response);
//            response.sendRedirect("/college-enterprise-cooperetion/jsp/student-information.jsp");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        int pageNo = new Integer(request.getParameter("pageNo"));
        System.out.println("Servlet中的页数"+pageNo);
        int pageSize = 2;
        List<StudentInfo> list = studentService.findAllStudentInfo(pageNo,pageSize);
        int n = studentService.getTotal();
        System.out.println("集合长度"+list.size());
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("n", 14);
//		每页多些数据
        request.getSession().setAttribute("pageSize", "5");
//		当前页码
        request.getSession().setAttribute("pageNo", "1");
        response.sendRedirect("/college-enterprise-cooperetion/jsp/student-informations.jsp");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
