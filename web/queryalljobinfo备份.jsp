<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.school.vo.JobInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>招聘信息</title>
    <!--整体界面布局-->
    <link rel="stylesheet" type="text/css" href="css/queryalljobinfo.css">
</head>
<body style="overflow-x: hidden; overflow-y: auto;">
<div>
    <!--界面头部-->
    <div id="titletop">
        <!--登陆注册按钮 login-->
        <img id="login">
        <span id="title">College Enterprise Cooperetion</span>
        <!--登陆前登陆后-->
        <span class="title_login1">
				<c:choose>
                    <c:when test="${sessionScope.StudentInfo.getStudentName() == null}"><!-- 如果 -->
                        <a href="jsp/login.jsp" id="modaltrigger">登录&nbsp;</a>
                        <img src="images/Cen_separate.gif" style="background-repeat:no-repeat;background-position:-25px -374px;height:16px;width:3px;margin-left: 1px;"/>&nbsp;
                        <a href="jsp/register.jsp"> 注册</a>
                    </c:when>
                    <c:otherwise> <!-- 否则 -->
                        <%--<a href="${pageContext.request.contextPath}/jsp/update-student-information.jsp">--%>
                        <a href="${pageContext.request.contextPath}/TeacherInfoQueryAllServlet">
                          欢迎：${sessionScope.StudentInfo.getStudentName()}
                        </a>
                        <img src="images/Cen_separate.gif" style="background-repeat:no-repeat;background-position:-25px -374px;height:16px;width:3px;margin-left: 3px;"/>&nbsp;
                        <span class="main2"><a href="LogoutServlet" target="_self">注销</a> </span>
                    </c:otherwise>
                </c:choose>
			</span>
    </div>
    <!--导航栏-->
    <div id="top">
        <!--标题栏置顶-->
        <div id="titlecontent">
            <div id="titlecontent_right" style="margin-right: 100px;">
                <span class="main1"><a href="main.jsp">HOME</a></span>
                <span class="main2"><a href="#recruitinformation">招聘信息</a></span>
                <span class="main2"><a href="#footers">界面底部</a></span>
            </div>
        </div>
        <%--<div>--%>
            <%--<jsp:include page="xuanzhuan.jsp"></jsp:include>--%>
        <%--</div>--%>
    </div>
    <!--招聘信息-->
    <div>
        <div id="tb"></div>
        <form name="meya" action="***">
            <div id="recruitinformation">
                <img id="logins">
                <span class="title_login1">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed">
                        <tr align="center" style="background: #b7b7b7;">
                            <td width="6px" height="40px" style="padding:10px;">招聘公司</td>
                            <td width="6px" style="padding:10px;">招聘职位</td>
                            <td width="6px" style="padding:10px;">具体要求</td>
                            <td width="6px" style="padding:10px;">发布时间</td>
                            <td width="6px" style="padding:10px;">操作</td>
                        </tr>
                        <%
                            ArrayList<JobInfo> allJobInfo = (ArrayList<JobInfo>)session.getAttribute("allJobInfo");
                            for (int i = 0; i < allJobInfo.size(); i++) {
                                JobInfo jobInfo = allJobInfo.get(i);
                        %>
                        <tr align="center" style="padding:10px;">
                            <td style="padding:15px;"><%=jobInfo.getEnterpriseName()%></td>
                            <td style="padding:15px;"><%=jobInfo.getJobPosition()%></td>
                            <td style="padding:15px;"><%=jobInfo.getJobInfo()%></td>
                            <td style="padding:15px;"><%=jobInfo.getJobDate()%></td>
                            <td style="padding:15px;">
                                <div class="theme-buy">
                                    <a class="btn btn-large theme-login" href="JobInfoQueryServlet?jobid=<%=jobInfo.getJobId()%>">查看详情</a>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
				</span>
            </div>
        </form>
    </div>
    <!--界面底部-->
    <div id="footers">
        <div style="margin-top: 40px;text-align: center">
            <table border="0" width="100%">
                <tr>
                    <td><p style="margin-top: 20px;">频道导航</p></td>
                    <td><p style="margin-top: 20px;">用户中心</p></td>
                    <td><p style="margin-top: 20px;">联系我们</p></td>
                    <td><p style="margin-top: 20px;">沈阳工学院</p></td>
                    <td><p style="margin-top: 20px;">完美校园</p></td>
                </tr>

                <tr>
                    <td><p><a href="javascript:scroll(0,0)" style="text-decoration:none;color: #96c7ec">HOME</a></p>
                    </td>
                    <td><p>使用帮助</p></td>
                    <td><p>关于我们</p></td>
                    <td><p><img src="images/sygxy.png" style="width: 70px;height: 70px;"></p></td>
                    <td><p><img src="images/sygxywmpt.png" style="width: 70px;height: 70px;"></p></td>
                </tr>
                <tr>
                    <td><p><a href="#recruitinformation" style="text-decoration:none;color: #96c7ec">招聘信息</a></p></td>
                    <td><p>用户协议</p></td>
                    <td><p></p></td>
                </tr>
                <tr>
                    <td><p><a href="#recruitstudentimages2" style="text-decoration:none;color: #96c7ec">招生向导</a></p>
                    </td>
                    <td><p>防骗指南</p></td>
                    <td><p></p></td>
                </tr>
                <tr>
                    <td><p></p></td>
                    <td><p></p></td>
                    <td><p></p></td>
                </tr>

            </table>
        </div>
    </div>
    <div>
        <table style="width: 100%;height:30px;text-align: center;background-color: white;">
            <tr>
                <td>
                    <p style="font-size: 16px;margin-top: 8px;">
                        Copyright by 沈阳工学院 地址：辽宁抚顺经济开发区（沈抚新城）滨河路（东段）1号 邮编:113122 辽ICP备 15004273号
                    </p>
                </td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>