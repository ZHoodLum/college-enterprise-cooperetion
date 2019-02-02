package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
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
 * @ Date       ：Created in 2019/1/22
 */


@WebServlet("/AdminUpdateTeacherInfoServlet")
public class AdminUpdateTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = new TeacherInfo();
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        teacherInfo.setPageNo(pageNo);
        teacherInfo.setTeacherId(Integer.parseInt(request.getParameter("teacher_id")));
        teacherInfo.setTeacherAccount(Integer.parseInt(request.getParameter("teacher_account")));
        teacherInfo.setTeacherName(request.getParameter("teacher_name"));
        teacherInfo.setTeacherTel(request.getParameter("teacher_tel"));
        teacherInfo.setTeacherPassword(request.getParameter("teacher_password"));
        teacherInfo.setTeacherSex(request.getParameter("teacher_sex"));
        teacherInfo.setTeacherJob(request.getParameter("teacher_job"));
        teacherInfo.setEmail(request.getParameter("email"));
        teacherInfo.setTeacherCollege(request.getParameter("teacher_college"));
        try {
            boolean succ = teacherService.updateTeacherInfo(teacherInfo);
            if (succ == true){
                request.getRequestDispatcher("/AdminQueryAllTeacherInfoServlet").forward(request,response);
            }else {
                System.out.println("succ="+succ);
                response.getWriter().print(
                        "<script >alert('修改失败');"
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
