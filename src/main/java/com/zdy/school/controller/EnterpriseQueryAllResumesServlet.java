package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseStudentInfoService;
import com.zdy.school.service.EnterpriseStudentInfoServiceImpl;
import com.zdy.school.vo.EnterpriseStudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/12/26
 */


@WebServlet("/EnterpriseQueryAllResumesServlet")
public class EnterpriseQueryAllResumesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseStudentInfoService enterpriseStudentInfoService = new EnterpriseStudentInfoServiceImpl();
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        enterpriseStudentInfo.setEnterpriseId(enterpriseId);
        System.out.println("审核简历渠道的企业ID是：" + enterpriseId);
        List<EnterpriseStudentInfo> list = enterpriseStudentInfoService.queryEnterpriseStudentinfo(enterpriseStudentInfo);
        request.getSession().setAttribute("list", list);
//        response.sendRedirect("college-enterprise-cooperetion/jsp/applicationaudit.jsp");
        request.getRequestDispatcher("jsp/applicationaudit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
