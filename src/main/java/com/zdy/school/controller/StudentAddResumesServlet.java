package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.Resumes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/16
 * 学生提交  保存简历信息
 */

@WebServlet("/StudentAddResumesServlet")
public class StudentAddResumesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Resumes resumes = new Resumes();
        StudentService studentService = new StudentServiceImpl();
        resumes.setStudentId(Integer.parseInt(request.getParameter("student_id")));
        resumes.setNationality(request.getParameter("nationality"));
        resumes.setBirthday(Date.valueOf(request.getParameter("birthday")));
        resumes.setPolitics(request.getParameter("politics"));
        resumes.setHealth(request.getParameter("health"));
        resumes.setCollege(request.getParameter("college"));
        resumes.setEducation(request.getParameter("education"));
//        resumes.setGraduateTime(Date.valueOf(request.getParameter("graduate_time")));
        resumes.setGraduateTime(Date.valueOf(request.getParameter("graduate_time")));
        resumes.setStudentContineTime(request.getParameter("student_continue_time"));
        resumes.setMajorCourse(request.getParameter("major_course"));
        resumes.setCredential(request.getParameter("credential"));
        resumes.setSelfEvaluation(request.getParameter("self_evaluation"));
        int datavalues = studentService.insertStudentResumes(resumes);
        if (datavalues > 0) {
            request.getRequestDispatcher("ResumesQueryAllServlet").forward(request,response);
//            request.getRequestDispatcher("jsp/contact.jsp").forward(request,response);
//            response.sendRedirect("jsp/contact.jsp");
//            response.sendRedirect("ResumesQueryAllServlet");
        }else {
            response.getWriter().print(
                    "<script >alert('修改简历信息失败!');"
                            + "</script>");
        }
    }
}
