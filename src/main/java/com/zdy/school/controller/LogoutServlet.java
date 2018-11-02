package com.zdy.school.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zdy.school.vo.StudentInfo;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1599366365079846238L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 获取session
        HttpSession session = request.getSession();
        // 获取用户对象
        StudentInfo studentInfo = (StudentInfo)session.getAttribute("StudentInfo");
        // 判断用户是否有效
        if(studentInfo != null){
            // 将用户对象逐出session
            session.removeAttribute("studentInfo");
            // 设置提示信息
            request.setAttribute("info", studentInfo.getStudentName() + " 已成功退出！");
        }
        // 转发到message.jsp页面
//        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/login.jsp");
    }

}
