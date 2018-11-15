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
    <title>Main主页</title>
    <!--整体界面布局-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript">
        function queryclass() {
            location.href="${pageContext.request.contextPath}/ClassInfoQueryAllServlet";
        }
    </script>
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
                        <a href="${pageContext.request.contextPath}/TeacherInfoQueryAllServlet" onclick="queryclass()">
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
                <span class="main1"><a href="javascript:scroll(0,0)">HOME</a></span>
                <span class="main2"><a href="#recruitinformation">招聘信息</a></span>
                <span class="main2"><a href="#recruitstudentimages2">实习向导</a></span>
                <span class="main2"><a href="#footers">界面底部</a></span>
                <%--<span class="main2"><a href="Send? url=WEB-INF/jsp/contact.jsp">我的简历</a></span>--%>
                <span class="main2"><a href="jsp/contact.jsp">我的简历</a></span>
            </div>
        </div>
        <div>
            <jsp:include page="xuanzhuan.jsp"></jsp:include>
        </div>
    </div>
    <!--招聘信息-->
    <div>
        <form name="meya" action="***">
            <div id="recruitinformation">
                <img id="logins">
                <span class="title_login1">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed">
					<tr align="center" style="background: #b7b7b7;">
						<td width="6px" height="40px" style="padding:10px;">招聘公司</td>
						<td width="6px" style="padding:10px;">招聘职位</td>
						<td width="6px" style="padding:10px;">发布时间</td>
						<td width="6px" style="padding:10px;">查看详情</td>
					</tr>
					<%
                        ArrayList<JobInfo> allJobInfo = (ArrayList<JobInfo>)session.getAttribute("allJobInfo");
                        for (int i = 0; i < allJobInfo.size(); i++) {
                            JobInfo jobInfo = allJobInfo.get(i);
                    %>
					<tr align="center" style="padding:10px;">
						<td style="padding:15px;">
                            <%=jobInfo.getEnterpriseName()%>
                        </td>
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
                <span>
					<div>
                        <a href="" style="text-align: center"><h3>查看更多招聘信息.......</h3></a>
					</div>
				</span>
            </div>
        </form>
    </div>
    <!--招生向导-->
    <img id="recruitstudentimages2">
    <!-- style="background-color: mintcream"-->
    <div>
        <div id="recruitstudent">

            <h1>实习，你真的准备好了吗？</h1>

            <p class="p2">一、请准备好合适的时间，并且诚实地告诉面试官，你究竟能来几天。能来的那几天是否有课，你长期旷课的后果是否知道。
                请不要面试的时候答应4天，开始工作后，发现扛不住了，改成三天。你的诚信令我不安。</p>
            <p class="p2">二、请处理好校园事务，不要带到公司来。不要在领导走到你跟前时，紧急关掉MSN、飞信等聊天界面和不相关网页，公司花钱请你来工作，
                不是请你坐在这里君临天下、坐镇指挥、威慑四方。也许你没有耽误工作，但是你会让公司觉得你不安定。</p>
            <p class="p2">三、请学会正确认识自己的能力，不要自以为是一抓一大把的牛人。实习意味着每天至少8小时在公司呆着，不能处理诸如社团、学生会、论文、课业等。
                倘若你处理不好，请学会放弃，无论是放弃实习还是放弃学生会。如果你加班到深夜，我理解你的挣扎、纠结，可我什么都做不了。</p>
            <p class="p2">四、请记得你是员工，不是学生。不要总用“学生”这个理由让自己做事不完美。
                随便写两句话就扔给组长的PPT、看都不看就胡编的英文报告、不来公司从不请假，或是半夜请假、迟到早退毫无征兆、晚来早走理所当然，这让我们感到很遗憾。</p>
            <p class="p2">五、请准备好体力和意志力。商业区和校园终不是宿舍和食堂的距离，特别是一线城市的实习生，坐地铁坐一个多小时是常事，
                要么租房子、要么坚持来回跑，请做好思想准备。</p><br><br>

            <h1>实习途径</h1>
            <div>
                <table border="0" style="text-align: center;" width="100%">
                    <tr>
                        <td>
                            <div class="comment_bubble">
                                <p>招聘网站</p>
                            </div>
                        </td>
                        <td>
                            <div class="comment_bubble">
                                <p>学校资源</p>
                            </div>
                        </td>
                        <td>
                            <div class="comment_bubble">
                                <p>企业宣讲</p>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="comment_bubble">
                                <p>知乎平台</p>
                            </div>
                        </td>
                        <td>
                            <div class="comment_bubble">
                                <p>Linkedin</p>
                            </div>
                        </td>
                        <td>
                            <div class="comment_bubble">
                                <p>微信公众号</p>
                            </div>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
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