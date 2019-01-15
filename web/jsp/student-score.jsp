<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>studentscore</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
</head>
<!--
    学生成绩修改界面  主要向公司提供展示界面
    由公司管理员给学生实习成绩，同时方便校方进行查询
-->
<body>
<div class="checkout-title">
    <span><hr class="hrLine" style="width:300px;"/>评判学生实习成绩<hr class="hrLine" style="width:300px;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->
<form action="${pageContext.request.contextPath}/StudentInfoConditionQueryServlet04" method="get">
    <div>
        <div class="sousuo">
            <input type="text" name="studentTel" class="search" placeholder="根据电话进行搜索"/>
            <input type="submit" value="搜索" class="sub"/>
        </div>
    </div>
</form>
<div id="recruitinformation">
    <form id="myform" name="myform" action="*****">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr align="center">
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学生学号</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学生姓名</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">专业</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">所在学院</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">在校指导教师</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">成绩</td>
            </tr>
            <tr align="center" style="padding:10px; border-bottom: 1px dashed #6bb642;">
                <td style="padding:15px;">15231566</td>
                <td style="padding:15px;">ZHoodLum</td>
                <td style="padding:15px;">架构师</td>
                <td style="padding:15px;">计科</td>
                <td style="padding:15px;">王岩</td>
                <td style="padding:15px;">
                    <input type="text" id="userName" name="user_name" />
                    <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="保存" tabindex="3"
                           onclick="if(confirm('确定要保存吗')){alert('保存成功!');return true;}return false;">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>