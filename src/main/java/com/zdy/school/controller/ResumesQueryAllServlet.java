package com.zdy.school.controller;

import com.zdy.school.service.StudentService;
import com.zdy.school.service.StudentServiceImpl;
import com.zdy.school.vo.JobInfo;
import com.zdy.school.vo.Resumes;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/16
 */


@WebServlet("/ResumesQueryAllServlet")
public class ResumesQueryAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        try {
            Resumes resumes = studentService.findResumesById(studentId);
            request.getSession().setAttribute("resumes",resumes);
            request.getSession().setAttribute("health",resumes.getHealth());
            request.getSession().setAttribute("politics",resumes.getPolitics());
            response.sendRedirect("jsp/contact.jsp");

            out.print(resumes);
            if (resumes != null){
                out.print("success");
//                out.write("success");
            }else {
                out.print("false");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
