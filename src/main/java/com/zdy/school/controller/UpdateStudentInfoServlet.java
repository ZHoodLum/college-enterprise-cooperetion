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

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/2
 */

@WebServlet("/UpdateStudentInfoServlet")
public class UpdateStudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setStudentAccount(Integer.parseInt(request.getParameter("student_account")));
        studentInfo.setStudentName(request.getParameter("student_name"));
        studentInfo.setStudentTel(request.getParameter("student_tel"));
        studentInfo.setStudentPassword(request.getParameter("student_password"));
        studentInfo.setStudentSex(request.getParameter("student_sex"));
        studentInfo.setMajor(request.getParameter("major"));
        studentInfo.setCity(request.getParameter("city"));
        studentInfo.setEmail(request.getParameter("email"));
        studentInfo.setStudentCollege(request.getParameter("student_college"));
//        studentInfo.setStudentInternship(request.getParameter("student_internship"));
//        studentInfo.setStudentGrade(Integer.parseInt(request.getParameter("student_grade")));
        studentInfo.setClassId(Integer.parseInt(request.getParameter("class_id")));
        studentInfo.setTeacherId(Integer.parseInt(request.getParameter("teacher_id")));
        studentInfo.setStudentId(Integer.parseInt(request.getParameter("student_id")));

        try {
            boolean succ = studentService.updateStudentInfo(studentInfo);
            if (succ = true){
                request.getRequestDispatcher("/updatesuccess.html").forward(request,response);
//                response.setHeader("Refresh","1;URL=http://localhost:8080/college-enterprise-cooperetion/jsp/company-main.jsp");
//                response.sendRedirect("/college-enterprise-cooperetion/jsp/company-main.jsp");
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
}
