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

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2019/1/11
 */


@WebServlet("/ResumesDeleteServlet")
public class ResumesDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseStudentInfoService enterpriseStudentInfoService = new EnterpriseStudentInfoServiceImpl();
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        try {
            int  enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(enterpriseId);
            System.out.println(id);
            boolean rows = enterpriseStudentInfoService.ResumesDelete(id);
            request.getRequestDispatcher("/EnterpriseQueryAllResumesServlet").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
