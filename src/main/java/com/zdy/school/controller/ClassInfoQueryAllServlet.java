package com.zdy.school.controller;

import com.zdy.school.service.ClassInfoService;
import com.zdy.school.service.ClassInfoServiceImpl;
import com.zdy.school.vo.ClassInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 */

@WebServlet("/ClassInfoQueryAllServlet")
public class ClassInfoQueryAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassInfo classInfo = new ClassInfo();
        ClassInfoService classInfoService = new ClassInfoServiceImpl();

        try {
             List<ClassInfo> allClassInfo = classInfoService.findAllClassInfo(classInfo);
             request.getSession().setAttribute("class_id",classInfo.getClassId());
             request.getSession().setAttribute("class_name",classInfo.getClassName());
             request.getSession().setAttribute("allClassInfo",allClassInfo);
             request.getRequestDispatcher("/jsp/teacher-student-information.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
