package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.TeacherInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2019/1/22
 */

@WebServlet("/AdminQueryAllTeacherInfoServlet")
public class AdminQueryAllTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        TeacherInfo teacherInfo = new TeacherInfo();
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = 12;
        //将数据存放在List中
        List<TeacherInfo> list = adminService.findAllTeacherInfo(pageNo, pageSize);
        //获取的总数据量
        int n = adminService.getTeacherInfoTotal();
        //页数
        int y = n/pageSize;
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("n", n);
        request.getSession().setAttribute("y", y);
        request.getSession().setAttribute("pageSize", pageSize);
        request.getSession().setAttribute("pageNo", pageNo);
        response.sendRedirect("/college-enterprise-cooperetion/jsp/manger-teacherinfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
