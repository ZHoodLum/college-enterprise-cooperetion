package com.zdy.school.controller;

import com.zdy.school.service.EnterpriseService;
import com.zdy.school.service.EnterpriseServiceImpl;
import com.zdy.school.service.LoginServiceImpl;
import com.zdy.school.vo.EnterpriseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/16
 * 企业管理员修改企业信息
 */

@WebServlet("/UpdateEnterpriseManagerServlet")
public class UpdateEnterpriseManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        EnterpriseService enterpriseService = new EnterpriseServiceImpl();
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        enterpriseInfo.setEnterpriseId(Integer.parseInt(request.getParameter("enterprise_id")));
        enterpriseInfo.setEnterpriseName(request.getParameter("enterprise_name"));
        enterpriseInfo.setEnterprisePassword(request.getParameter("enterprise_password"));
        enterpriseInfo.setEnterpriseIntroduce(request.getParameter("enterprise_introduce"));
        enterpriseInfo.setEnterpriseAddress(request.getParameter("enterprise_address"));
        enterpriseInfo.setEnterpriseTel(request.getParameter("enterprise_tel"));
        enterpriseInfo.setEmail(request.getParameter("email"));
        enterpriseInfo.setEnterpriseManager(request.getParameter("enterprise_manager"));

        try {
            boolean succ = enterpriseService.updateEnterpriseInfo(enterpriseInfo);
            if (succ = true){
                request.getRequestDispatcher("/updatesuccess.jsp").forward(request,response);
//                response.setHeader("Refresh","1;URL=http://localhost:8080/college-enterprise-cooperetion/jsp/company-main.jsp");
//                response.sendRedirect("/college-enterprise-cooperetion/jsp/company-main.jsp");
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
