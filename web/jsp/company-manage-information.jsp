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
    <title>招聘信息查询管理</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
    <style type="text/css">
        /*搜索框*/
        .sousuo{float:right;margin: 20px 80px 10px 0;}
        .search{border-color:blue;width: 200px;height:20px;outline: none;border-radius:10px;padding: 3px 0 3px 3px;}
        .sub{background-color: blue;border: 2px;width: 60px;height: 30px;font-size: 16px;font-family:YouYuan;}
        <!--下拉框样式-->
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(${pageContext.request.contextPath}/images/arrow.png) right center no-repeat;  vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 14px; width:100%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        #recruitinformation tr:nth-child(odd){ background: #dcdcdc;}
    </style>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--$("[value='搜索']").click(function () {--%>
                <%--var data1 = document.getElementById("data1").value;--%>
                <%--alert(data1);--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>
</head>
<body>
<div class="checkout-title" style="font-family: 微软雅黑;font-size: 20px;text-align: center;margin-top: 5px;font-weight: bold;">
    <span><hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/>招聘信息查询管理<hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->

    <div>
        <form action="${pageContext.request.contextPath}/JobInfoConditionQueryServlet" method="post">
            <div class="selectbox" style="margin: 20px 0 10px 80px;width: 200px;float: left;border: 2px solid blue;">
                <select name="e_check" id="data1" class="data">
                    <option value="">审核状态</option>
                    <option value="1" style="font-size: 16px;" >未审核</option>
                    <option value="0" style="font-size: 16px;">审核通过</option>
                </select>
            </div>
            <div class="selectbox" style="margin: 20px 0 10px 80px;width: 200px;float: left;border: 2px solid blue;">
                <select name="information_state" id="data2" class="data">
                    <option value="">信息状态</option>
                    <option value="0"  style="font-size: 16px;">正在招聘</option>
                    <option value="1" style="font-size: 16px;">已结束</option>
                </select>
            </div>
            <div class="sousuo">
                <input type="submit" value="搜索" class="sub"/>
            </div>

        </form>
    </div>

<div id="recruitinformation">
    <table width="100%" border="0px" cellpadding="0" cellspacing="0">
        <br>
            <tr align="center"  bgcolor="#FFFFFF" border: 0px;>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">招聘单位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">招聘职位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">详细信息</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">工资待遇</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">发布时间</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">审核状态</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">信息状态</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">详细信息</td>
            </tr>
            <c:forEach items="${jobInfoList}" var="ei" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                    <td  style="padding:7px 0 7px 0;">${ei.enterpriseName}</td>
                    <td>${ei.jobPosition}</td>
                    <td>${ei.jobInfo}</td>
                    <td>${ei.wage}</td>
                    <td>${ei.jobDate}</td>
                    <%--<td>${ei.eCheck}</td>--%>
                    <c:if test="${ei.eCheck == 1}">
                        <td>未审核</td>
                    </c:if>
                    <c:if test="${ei.eCheck == 0}">
                        <td>审核通过</td>
                    </c:if>


                <td>
                    <div class="selectbox">
                    <select>
                        <option value="1" ${ei.informationState == 1?"selected":""}>已结束</option>
                        <option value="0" ${ei.informationState == 0?"selected":""}>正在招聘</option>
                    </select>
                    </div>
                </td>
                    <td>
                        <div class="theme-buy">
                            <a class="btn btn-large theme-login" href="EnterpriseJobInfoQueryByIdServlet?jobid=${ei.jobId}">查看详情</a>
                        </div>
                    </td>
                    </td>
                </tr>
            </c:forEach>
        <tbody>
    </table>
</div>
</body>
</html>