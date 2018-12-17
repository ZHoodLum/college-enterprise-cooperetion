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
    <table width="100%" border="0px" cellpadding="0" cellspacing="0">
        <br>
            <tr align="center"  bgcolor="#FFFFFF" border: 0px;>
                <%--<td width="6%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学号</td>--%>
                <%--<td width="6%"  style="padding:5px 0 0 0;">学号</td>--%>
                <td width="6%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">姓名</td>
                <td width="7%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">性别</td>
                <td width="6%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">专业</td>
                <td width="12%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">籍贯</td>
                <td width="10%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">邮箱</td>
                <td width="12%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">电话</td>
                <td width="12%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">学院</td>
                <td width="7%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">是否实习</td>
                <td width="8%"  style="padding:10px 0 20px 0;border-bottom: 2px dashed #808080;">指导教师</td>
            </tr>
            <!-- 分页查询 -->
            <c:forEach items="${list}" var="si" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <%--<td>${si.studentAccount}</td>--%>
                    <td  style="padding:7px 0 7px 0;">${si.studentName}</td>
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
<div id="footer" style="width: 100%;margin-top:1px; position: absolute;bottom:40px; left: 0;">
    <!-- 分页导航 -->
    <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center" style="width:60%">
            <td width="335" align="center"  class="text_cray">&nbsp;</td>
            <td width="284" align="center"  class="text_cray">
                <%--判断上一页下一下--%>
                <c:if test="${pageNo == 1}">
                    <a>第一页</a>
                    <a>上一页</a>
                </c:if>
                <c:if test="${pageNo > 1}">
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=1&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">第一页</a>
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=${pageNo-1 }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">上一页</a>
                </c:if>

                <c:if test="${n%pageSize==0}">
                    <c:forEach begin="1" end="${n/pageSize}" var="i" step="1">
                        <c:if test="${i==pageNo }">
                            ${i}
                        </c:if>

                        <c:if test="${i!=pageNo }">
                            <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=${i}&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:if>

                <c:if test="${n%pageSize!=0}">
                    <c:forEach begin="1" end="${n/pageSize+1}" var="i" step="1">
                        <c:if test="${i==pageNo }">
                            ${i}
                        </c:if>

                        <c:if test="${i!=pageNo }">
                            <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=${i}&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">${i}</a>
                        </c:if>

                    </c:forEach>
                </c:if>

                <%--判断下一页 最后一页--%>
                <c:if test="${pageNo == n}">
                    <a>下一页</a>
                    <a>最后一页</a>
                </c:if>
                <c:if test="${pageNo < n }">
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=${pageNo+1 }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">下一页</a>
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=${n }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">最后一页</a>
                </c:if>
            </td>
        </tr>
    </table>
</div>
</body>
</html>