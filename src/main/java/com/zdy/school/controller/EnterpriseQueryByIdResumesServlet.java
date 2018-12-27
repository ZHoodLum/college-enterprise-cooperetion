package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseStudentInfoService;
import com.zdy.school.service.EnterpriseStudentInfoServiceImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/27
 */


@WebServlet("/EnterpriseQueryByIdResumesServlet")
public class EnterpriseQueryByIdResumesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseStudentInfoService enterpriseStudentInfoService = new EnterpriseStudentInfoServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("本次简历信息查到得ID是"+id);
        EnterpriseStudentInfo listenterpriseStudentInfo = enterpriseStudentInfoService.enterpriseQueryByIdResumesServlet(id);
        request.getSession().setAttribute("listenterpriseStudentInfo", listenterpriseStudentInfo);
        request.getRequestDispatcher("jsp/resumeinfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
