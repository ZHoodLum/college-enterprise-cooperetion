<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta charset="UTF-8">
    <title>教师查询学生成绩</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
    <style type="text/css">
        /*搜索框*/
        .sousuo{float:right;margin: 20px 80px 10px 0;}
        .search{border-color:blue;width: 200px;height:20px;outline: none;border-radius:10px;padding: 3px 0 3px 3px;}
        .sub{background-color: blue;border: 2px;width: 60px;height: 30px;font-size: 16px;font-family:YouYuan;}
        <!--下拉框样式-->
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat;  vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 14px; width:100%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
</head>
<body>

<div class="checkout-title">
    <span><hr class="hrLine" style="width:300px;"/>学生企业实习成绩<hr class="hrLine" style="width:300px;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->
<div>
    <div class="sousuo">
        <input type="text" class="search" placeholder="根据姓名进行搜索"/>
        <input type="text" class="search" placeholder="根据学号进行搜索"/>
        <input type="submit" value="搜索" class="sub"/>
    </div>
</div>

<div id="recruitinformation">
    <form id="myform" name="myform" action="*****">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr align="center">
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">学生学号</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">学生姓名</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">专业</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">所在学院</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">在校指导教师</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">实习单位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">学生企业实习成绩</td>
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
                    <td>${si.major}</td>
                    <td>${si.studentCollege}</td>
                    <td>${si.teacherName}</td>
                    <td>${si.enterpriseName}</td>
                    <td>${si.studentGrade}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
<%--<tr align="center" style="padding:10px; border-bottom: 2px dashed #6bb642;">--%>
<%--<td style="padding:15px;">15231566</td>--%>
<%--<td style="padding:15px;">ZHoodLum</td>--%>
<%--<td style="padding:15px;">架构师</td>--%>
<%--<td style="padding:15px;">计科</td>--%>
<%--<td style="padding:15px;">王岩</td>--%>
<%--<td style="padding:15px;">辽宁科技有限公司</td>--%>
<%--<td style="padding:15px;">999</td>--%>
<%--</tr>--%>