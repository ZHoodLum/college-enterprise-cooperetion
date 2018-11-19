package com.zdy.school.controller;

import com.zdy.school.dao.StudentDao;
import com.zdy.school.dao.StudentDaoImpl;
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
 * @ Date       ：Created in 2018/11/19
 */

@WebServlet("/InsertStudentInfoServlet")
public class InsertStudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo studentInfo = new StudentInfo();
        StudentService studentService = new StudentServiceImpl();

        studentInfo.setStudentAccount(Integer.parseInt(request.getParameter("student_account")));
        studentInfo.setStudentName(request.getParameter("student_name"));
        studentInfo.setStudentTel(request.getParameter("student_tel"));
        studentInfo.setStudentPassword(request.getParameter("student_password"));
        studentInfo.setStudentSex(request.getParameter("student_sex"));
        studentInfo.setMajor(request.getParameter("major"));
        studentInfo.setCity(request.getParameter("city"));
        studentInfo.setEmail(request.getParameter("email"));
        studentInfo.setStudentCollege(request.getParameter("student_college"));
        try {

            int datevalues = studentService.insertStudentInfo(studentInfo);
            if (datevalues > 0){
                request.getRequestDispatcher("/registersuccess.html").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
