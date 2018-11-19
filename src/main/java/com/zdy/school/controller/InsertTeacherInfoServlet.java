package com.zdy.school.controller;

import com.zdy.school.service.TeacherService;
import com.zdy.school.service.TeacherServiceImpl;
import com.zdy.school.vo.TeacherInfo;
import sun.security.jgss.HttpCaller;

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

@WebServlet("/InsertTeacherInfoServlet")
public class InsertTeacherInfoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = new TeacherInfo();

        teacherInfo.setTeacherAccount(Integer.parseInt(request.getParameter("teacher_account")));
        teacherInfo.setTeacherName(request.getParameter("teacher_name"));
        teacherInfo.setTeacherTel(request.getParameter("teacher_tel"));
        teacherInfo.setTeacherPassword(request.getParameter("teacher_password"));
        teacherInfo.setEmail(request.getParameter("email"));
        teacherInfo.setTeacherCollege(request.getParameter("teacher_college"));
        teacherInfo.setTeacherSex(request.getParameter("teacher_sex"));
        teacherInfo.setTeacherJob(request.getParameter("teacher_job"));
        try {
            int datevalues = teacherService.insertTeacherInfo(teacherInfo);
            if (datevalues > 0 ){
                request.getRequestDispatcher("/registersuccess.html").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
