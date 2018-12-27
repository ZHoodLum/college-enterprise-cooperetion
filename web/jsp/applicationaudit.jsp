<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>审核简历信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/applicationaudit.css">
    <!--
    下拉框样式
    -->
    <style type="text/css">
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
</head>
<body>
<div class="checkout-title">
    <span><hr class="hrLine" style="width:300px;"/>请审核实习申请<hr class="hrLine" style="width:300px;"/></span>
</div>
<div id="recruitinformation">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr align="center">
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">姓名</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">专业</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">毕业院校</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学历</td>
            <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">自我介绍</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">毕业时间</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">操作</td>
        </tr>
        <c:forEach items="${list}" var="es" varStatus="i">
            <c:if test="${i.index%2 == 0}">
                 <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
            </c:if>
            <c:if test="${i.index%2 == 1}">
                <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
            </c:if>
        <%--<tr align="center" style="padding:10px; border-bottom: 1px dashed #6bb642;">--%>
            <%--<input type="text" name="id" value="${es.id}">--%>
            <td style="padding:15px;">${es.studentName}</td>
            <td style="padding:15px;">${es.major}</td>
            <td style="padding:15px;">${es.college}</td>
            <td style="padding:15px;">${es.education}</td>
            <td style="padding:15px;">${es.selfEvaluation}</td>
            <td style="padding:15px;">${es.graduateTime}</td>
            <td style="padding:15px;">
                <div class="theme-buy">
                    <a class="btn btn-large theme-login" href="EnterpriseQueryByIdResumesServlet?id=${es.id}">查看详情</a>
                </div>
            </td>
        </c:forEach>

    <%--</tr>--%>

    </table>
</div>
</body>
</html>