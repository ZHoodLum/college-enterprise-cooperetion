package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseService;
import com.zdy.school.service.EnterpriseServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;

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

@WebServlet("/InsertEnterpriseInfoServlet")
public class InsertEnterpriseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        EnterpriseService enterpriseService = new EnterpriseServiceImpl();

        enterpriseInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
        enterpriseInfo.setEnterpriseName(request.getParameter("enterprise_name"));
        enterpriseInfo.setEnterprisePassword(request.getParameter("enterprise_password"));
        enterpriseInfo.setEnterpriseIntroduce(request.getParameter("enterprise_introduce"));
        enterpriseInfo.setEnterpriseAddress(request.getParameter("enterprise_address"));
        enterpriseInfo.setEnterpriseTel(request.getParameter("enterprise_tel"));
        enterpriseInfo.setEmail(request.getParameter("email"));
        enterpriseInfo.setEnterpriseManager(request.getParameter("enterprise_manager"));

        int datevalues = enterpriseService.intsertEnterpriseInfo(enterpriseInfo);
        if (datevalues > 0 ){
            request.getRequestDispatcher("/registersuccess.html").forward(request,response);
        }else {
            response.getWriter().print(
                    "<script >alert('注册管理员信息失败！');"
                            + "</script>");
        }
    }
}
