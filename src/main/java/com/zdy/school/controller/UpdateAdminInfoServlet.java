package com.zdy.school.controller;

import com.zdy.school.service.AdminService;
import com.zdy.school.service.AdminServiceImpl;
import com.zdy.school.service.TeacherService;
import com.zdy.school.service.TeacherServiceImpl;
import com.zdy.school.vo.AdminInfo;
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

@WebServlet("/UpdateAdminInfoServlet")
public class UpdateAdminInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setId(Integer.parseInt(request.getParameter("id")));
        adminInfo.setAdminId(Integer.parseInt(request.getParameter("admin_id")));
        adminInfo.setAdminName(request.getParameter("admin_name"));
        adminInfo.setAdminPassword(request.getParameter("admin_password"));

        try {
            boolean succ = adminService.updateAdminInfo(adminInfo);

            if (succ == true){
                request.getRequestDispatcher("/updatesuccess.jsp").forward(request,response);
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
