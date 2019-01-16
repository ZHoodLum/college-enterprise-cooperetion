package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;
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
 * @ Date       ：Created in 2018/10/17
 * 评判学生成绩  先进行查询学生信息
 */

@WebServlet("/EnterpriseStudentQueryAllServlet02")
public class EnterpriseStudentQueryAllServlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
//        默认每页数据量数
        int pageSize = 4;
//        调用方法获取list集合下的数据
        List<StudentInfo> list = studentService.findAllStudentInfo(pageNo,pageSize,enterpriseId);
        int n = studentService.getTotal();
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("n", n);
        request.getSession().setAttribute("pageSize", pageSize);
        request.getSession().setAttribute("pageNo", pageNo);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/student-score.jsp");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}