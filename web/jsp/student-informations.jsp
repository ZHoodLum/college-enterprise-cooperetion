<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.school.vo.StudentInfo" %>
<%@ page import="com.zdy.school.service.StudentService" %>
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
</head>
<body>
<div class="checkout-title">
    <span><hr class="hrLine" style="width:260px;"/>学生的信息查询<hr class="hrLine" style="width:260px;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->
<div class="sousuo">
    <input type="text" class="search" placeholder="请填写学号进行搜索"/>
    <input type="submit" value="搜索" class="sub"/>
</div>
<div id="recruitinformation">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
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
            <!-- 分页查询 -->
            <c:forEach items="${list}" var="si" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5">
                </c:if>
                <td>${si.studentAccount}</td>
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
            <br>
            <!-- 分页导航 -->
            <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center" style="width:60%">
                    <td width="335" align="center"  class="text_cray">&nbsp;</td>
                    <td width="284" align="center"  class="text_cray">
                        <c:if test="${n%pageSize==0}">
                            <c:forEach begin="1" end="${n/pageSize}" var="i" step="1">
                                <c:if test="${i == pageNo }">
                                    ${i }
                                </c:if>

                                <c:if test="${i != pageNo }">
                                    <a href="${pageContext.request.contextPath}/StudentQueryAllServlet?pageNo=${i }">${i }</a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${n%pageSize!=0}">
                            <c:forEach begin="1" end="${n/pageSize+1}" var="i" step="1">
                                <c:if test="${i == pageNo }">
                                    ${i }
                                </c:if>

                                <c:if test="${i != pageNo }">
                                    <a href="${pageContext.request.contextPath}/StudentQueryAllServlet?pageNo=${i }">${i }</a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </td>
                </tr>
            </table>
        <tbody>
    </table>
</div>
</body>
</html>