<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.school.vo.StudentInfo" %>
<%@ page import="com.zdy.school.service.StudentService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>studentinformation</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
</head>
<body>
<div class="checkout-title">
    <span><hr class="hrLine" style="width:300px;"/>学生的信息查询<hr class="hrLine" style="width:300px;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->
<div class="sousuo">
    <input type="text" class="search" placeholder="请填写学号进行搜索"/>
    <input type="submit" value="搜索" class="sub"/>
</div>
<div id="recruitinformation">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr align="center">
            <td width="6%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学号</td>
            <td width="6%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">姓名</td>
            <td width="7%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">性别</td>
            <td width="13%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">专业</td>
            <td width="15%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">籍贯</td>
            <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">邮箱</td>
            <td width="8%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">电话</td>
            <td width="12%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学院</td>
            <td width="7%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">是否实习</td>
            <td width="8%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">指导教师</td>
        </tr>
        <%
            ArrayList<StudentInfo> allStudentInfo = (ArrayList<StudentInfo>)session.getAttribute("allStudent");
            for (int i=0;i<allStudentInfo.size();i++){
                StudentInfo studentInfo = allStudentInfo.get(i);

        %>
        <tr align="center" style="padding:10px; border-bottom: 2px dashed #6bb642;">
            <td style="padding:10px;"><%=studentInfo.getStudentAccount()%></td>
            <td style="padding:10px;"><%=studentInfo.getStudentName()%></td>
            <td style="padding:10px;"><%=studentInfo.getStudentSex()%></td>
            <td style="padding:10px;"><%=studentInfo.getMajor()%></td>
            <td style="padding:10px;"><%=studentInfo.getCity()%></td>
            <td style="padding:10px;"><%=studentInfo.getEmail()%></td>
            <td style="padding:10px;"><%=studentInfo.getStudentTel()%></td>
            <td style="padding:10px;"><%=studentInfo.getStudentCollege()%></td>
            <td style="padding:10px;"><%=studentInfo.getStudentInternship()%></td>
            <td style="padding:10px;"><%=studentInfo.getTeacherName()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>