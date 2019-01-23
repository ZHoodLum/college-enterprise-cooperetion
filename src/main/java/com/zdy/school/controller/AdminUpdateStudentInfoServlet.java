package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
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


@WebServlet("/AdminUpdateStudentInfoServlet")
public class AdminUpdateStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        StudentInfo studentInfo = new StudentInfo();
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        studentInfo.setPageNo(pageNo);
        studentInfo.setStudentAccount(Integer.parseInt(request.getParameter("student_account")));
        studentInfo.setStudentName(request.getParameter("student_name"));
        studentInfo.setStudentTel(request.getParameter("student_tel"));
        studentInfo.setStudentPassword(request.getParameter("student_password"));
        studentInfo.setStudentSex(request.getParameter("student_sex"));
        studentInfo.setMajor(request.getParameter("major"));
        studentInfo.setCity(request.getParameter("city"));
        studentInfo.setEmail(request.getParameter("email"));
        studentInfo.setStudentCollege(request.getParameter("student_college"));
        studentInfo.setStudentId(Integer.parseInt(request.getParameter("student_id")));

        try {
            boolean succ = adminService.adminUpdateStudentInfo(studentInfo);
            if (succ == true){
                request.getRequestDispatcher("/AdminQueryAllStudentInfoServlet").forward(request,response);
            }else {
                System.out.println("succ="+succ);
                response.getWriter().print(
                        "<script >alert('修改失败');"
                                + "history.go(-1);"
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
