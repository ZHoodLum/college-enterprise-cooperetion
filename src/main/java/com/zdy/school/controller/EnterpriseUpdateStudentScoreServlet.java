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

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2019/1/20
 */


@WebServlet("/EnterpriseUpdateStudentScoreServlet")
public class EnterpriseUpdateStudentScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = new StudentInfo();
        try {
            studentInfo.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
            studentInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterpriseId")));
            studentInfo.setStudentGrade(Integer.parseInt(request.getParameter("student_grade")));
            studentInfo.setStudentId(Integer.parseInt(request.getParameter("student_id")));
            boolean succ = studentService.enterpriseUpdateStudentScore(studentInfo);
            if (succ == true) {
//                request.getRequestDispatcher("/jsp/student-score.jsp").forward(request,response);
                request.getRequestDispatcher("/EnterpriseStudentQueryAllServlet02").forward(request,response);
//                response.sendRedirect("/college-enterprise-cooperetion/jsp/student-score.jsp");
            }else {
                System.out.println("succ="+succ);
                response.getWriter().print(
                        "<script >alert('修改失败');"
                                + "</script>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
