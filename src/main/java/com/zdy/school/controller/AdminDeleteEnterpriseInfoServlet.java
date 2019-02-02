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
 */


@WebServlet("/AdminDeleteEnterpriseInfoServlet")
public class AdminDeleteEnterpriseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        try {
            int pageNo = Integer.parseInt(request.getParameter("pageNo"));
            enterpriseInfo.setPageNo(pageNo);
            int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
            boolean rows = adminService.deleteEnterpriseInfo(enterpriseId);
            if (rows == true) {
                request.getRequestDispatcher("/AdminQueryAllEnterpriseInfoServlet").forward(request, response);
            } else {
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
