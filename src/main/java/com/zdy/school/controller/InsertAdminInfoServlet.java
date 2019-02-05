package com.zdy.school.controller;

import com.zdy.school.dao.AdminDao;
import com.zdy.school.dao.AdminDaoImpl;
import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.vo.AdminInfo;

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

@WebServlet("/InsertAdminInfoServlet")
public class InsertAdminInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        AdminInfo adminInfo = new AdminInfo();

        adminInfo.setAdminId(Integer.parseInt(request.getParameter("admin_id")));
        adminInfo.setAdminName(request.getParameter("admin_name"));
        adminInfo.setAdminPassword(request.getParameter("admin_password"));

        int datavalues = adminService.insertAdminInfo(adminInfo);
        if (datavalues > 0 ){
            request.getRequestDispatcher("/registersuccess.html").forward(request,response);
        }else {
            response.getWriter().print(
                    "<script >alert('注册管理员信息失败!');"
                            + "</script>");
        }
    }
}
