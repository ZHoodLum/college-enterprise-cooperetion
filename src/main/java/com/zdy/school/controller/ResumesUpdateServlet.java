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
 * @ Date       ：Created in 2019/1/6
 */


@WebServlet("/ResumesUpdateServlet")
public class ResumesUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseStudentInfoService enterpriseStudentInfoService = new EnterpriseStudentInfoServiceImpl();
        EnterpriseStudentInfo enterpriseStudentInfo = new EnterpriseStudentInfo();
        int informationState = Integer.parseInt(request.getParameter("informationState"));
        enterpriseStudentInfo.setInformationState(informationState);
        enterpriseStudentInfo.setId(Integer.parseInt(request.getParameter("id")));
        enterpriseStudentInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterpriseId")));
//        System.out.println("修改信息状态1" + Integer.parseInt(request.getParameter("id")));
//        System.out.println("修改信息状态2" + Integer.parseInt(request.getParameter("informationState")));
//        System.out.println("修改信息状态3" + Integer.parseInt(request.getParameter("enterpriseId")));

        try {
            boolean rows = enterpriseStudentInfoService.ResumesUpdate(enterpriseStudentInfo);
            if (rows = true){
//                response.sendRedirect("/EnterpriseQueryAllResumesServlet");
                request.getRequestDispatcher("/EnterpriseQueryAllResumesServlet").forward(request, response);

            }else {
                System.out.println("rows="+rows);
                response.getWriter().print(
                        "<script >alert('修改失败');"
                                + "history.go(-1);"
                                + "</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
