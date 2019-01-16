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
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">学生姓名</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">性别</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">专业</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">地区</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">邮箱</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">电话</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">所在学校</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">成绩评分</td>
            </tr>
            <!-- 分页查询 -->
            <c:forEach items="${list}" var="si" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <td  style="padding:7px 0 7px 0;">
                    <input type="hidden" id="student_id" name="student_id" value="${si.studentId}"/>
                        ${si.studentName}
                </td>
                <td>${si.studentSex}</td>
                <td>${si.major}</td>
                <td>${si.city}</td>
                <td>${si.email}</td>
                <td>${si.studentTel}</td>
                <td>${si.studentCollege}</td>
                <td>
                    <input type="text" id="student_grade" name="student_grade" value="${si.studentGrade}"/>
                    <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="保存" tabindex="3"
                           onclick="if(confirm('确定要保存吗')){alert('保存成功!');return true;}return false;"></td>
                </tr>
            </c:forEach>
        </table>
    </form>
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
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=1&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">第一页</a>
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=${pageNo-1 }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">上一页</a>
                </c:if>

                <c:if test="${n%pageSize==0}">
                    <c:forEach begin="1" end="${n/pageSize}" var="i" step="1">
                        <c:if test="${i==pageNo }">
                            ${i}
                        </c:if>

                        <c:if test="${i!=pageNo }">
                            <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=${i}&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:if>

                <c:if test="${n%pageSize!=0}">
                    <c:forEach begin="1" end="${n/pageSize+1}" var="i" step="1">
                        <c:if test="${i==pageNo }">
                            ${i}
                        </c:if>

                        <c:if test="${i!=pageNo }">
                            <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=${i}&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">${i}</a>
                        </c:if>

                    </c:forEach>
                </c:if>

                <%--判断下一页 最后一页--%>
                <c:if test="${pageNo == n}">
                    <a>下一页</a>
                    <a>最后一页</a>
                </c:if>
                <c:if test="${pageNo < n }">
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=${pageNo+1 }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">下一页</a>
                    <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet02?pageNo=${n }&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}">最后一页</a>
                </c:if>
            </td>
        </tr>
    </table>
</div>
</body>
</html>