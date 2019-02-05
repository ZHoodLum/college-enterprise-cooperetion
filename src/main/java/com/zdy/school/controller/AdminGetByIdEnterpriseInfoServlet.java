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

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2019/1/22
 * 根据ID查询信息  用于修改
 */


@WebServlet("/AdminGetByIdEnterpriseInfoServlet")
public class AdminGetByIdEnterpriseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        try {
            int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
            EnterpriseInfo list = adminService.queryGetByIdEnterpriseInfo(enterpriseId);
            request.getSession().setAttribute("list", list);
            response.sendRedirect("/college-enterprise-cooperetion/jsp/manger-update-enterpriseinfo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
