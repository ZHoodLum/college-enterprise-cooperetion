<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.school.vo.StudentInfo" %>
<%@ page import="com.zdy.school.service.StudentService" %>
<%@ page import="com.zdy.school.vo.ClassInfo" %>
<%@page import="com.zdy.school.service.ClassInfoService"%>
<%@ page import="java.util.List" %>
<%@ page import="com.zdy.school.service.ClassInfoServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生信息查询</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
    <style type="text/css">
        /*搜索框*/
        .sousuo{float:right;margin: 20px 80px 10px 0;}
        .search{border-color:blue;width: 200px;height:20px;outline: none;border-radius:10px;padding: 3px 0 3px 3px;}
        .sub{background-color: blue;border: 2px;width: 60px;height: 30px;font-size: 16px;font-family:YouYuan;}
        <!--下拉框样式-->
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(${pageContext.request.contextPath}/images/arrow.png) right center no-repeat;  vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 14px; width:100%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
</head>
<body>
<div class="checkout-title" style="font-family: 微软雅黑;font-size: 20px;text-align: center;margin-top: 5px;font-weight: bold;">
    <span><hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/>学生的信息查询<hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->

    <div>
        <form action="${pageContext.request.contextPath}/StudentInfoConditionQueryServlet01" method="get">
        <div class="selectbox" style="margin: 20px 0 10px 80px;width: 200px;float: left;border: 2px solid blue;">
            <select name="class_id" id="data" class="data">
                <option value="0">未选择</option>
                <%
                    ClassInfo classInfo = new ClassInfo();
                    ClassInfoService classInfoService = new ClassInfoServiceImpl();
                    List<ClassInfo> allClassInfo = classInfoService.findAllClassInfo(classInfo);
                    for(int i=0;i<allClassInfo.size();i++){
                        classInfo = allClassInfo.get(i);
                        if (classInfo.getClassId() == 0){
                %>

                <option value="0" selected="selected" style="font-size: 16px;"><%=classInfo.getClassName()%></option>
                <option value="<%=classInfo.getClassId()%>" selected="selected" style="font-size: 16px;"><%=classInfo.getClassName()%></option>

                <%
                    }else{
                %>

                <option value="<%=classInfo.getClassId()%>" style="font-size: 16px;"><%=classInfo.getClassName()%></option>

                <%
                     }
                    }
                %>
                <%--<option value="1" style="font-size: 16px;">计科二班</option>--%>
                <%--<option value="2" style="font-size: 16px;">软工一班</option>--%>
                <%--<option value="3" style="font-size: 16px;">软工二班</option>--%>
            </select>
        </div>
        <div class="sousuo">
            <input type="text" name="studentTel" class="search" placeholder="根据电话进行搜索"/>
            <input type="text" name="studentAccount" class="search" placeholder="根据学号进行搜索"/>
            <input type="submit" value="搜索" class="sub"/>
        </div>
        </form>
    </div>

<div id="recruitinformation">
    <table width="100%" border="0px" cellpadding="0" cellspacing="0">
        <br>
            <tr align="center"  bgcolor="#FFFFFF" border: 0px;>
                <%--<td width="6%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学号</td>--%>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">学号</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">姓名</td>
                <td width="7%"  style="padding:10px; border-bottom: 2px dashed #808080;">性别</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">专业</td>
                <td width="12%"  style="padding:10px; border-bottom: 2px dashed #808080;">籍贯</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">邮箱</td>
                <td width="12%"  style="padding:10px; border-bottom: 2px dashed #808080;">电话</td>
                <td width="12%"  style="padding:10px; border-bottom: 2px dashed #808080;">学院</td>
                <td width="7%"  style="padding:10px; border-bottom: 2px dashed #808080;">是否实习</td>
                <td width="8%"  style="padding:10px; border-bottom: 2px dashed #808080;">指导教师</td>
            </tr>
            <c:forEach items="${list}" var="si" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <td  style="padding:7px 0 7px 0;">${si.studentAccount}</td>
                <td>${si.studentName}</td>
                <td>${si.studentSex}</td>
                <td>${si.major}</td>
                <td>${si.city}</td>
                <td>${si.email}</td>
                <td>${si.studentTel}</td>
                <td>${si.studentCollege}</td>
                <td>${si.studentInternship}</td>
                <td>${si.teacherName}</td>
                </tr>
            </c:forEach>
        <tbody>
    </table>
</div>
</body>
</html>