package com.zdy.school.controller;

import com.sun.xml.internal.ws.transport.http.HttpAdapter;
import com.zdy.school.service.EnterpriseService;
import com.zdy.school.service.EnterpriseServiceImpl;
import com.zdy.school.service.TeacherService;
import com.zdy.school.service.TeacherServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.TeacherInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 * 教师修改自己信息
 */

@WebServlet("/UpdateTeacherInfoServlet")
public class UpdateTeacherInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = new TeacherInfo();
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
            if (succ = true){
                request.getRequestDispatcher("/updatesuccess.jsp").forward(request,response);
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
