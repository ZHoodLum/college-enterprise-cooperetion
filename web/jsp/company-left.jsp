<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>manger-left</title>
    <link rel="stylesheet" type="text/css" href="../css/company-left.css">
    <script src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(".leftsidebar_box dt").css({"background-color":"#3992d0"});
        $(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
        $(function(){
            $(".leftsidebar_box dd").hide();
            $(".leftsidebar_box dt").click(function(){
                $(".leftsidebar_box dt").css({"background-color":"#3992d0"});
                $(this).css({"background-color": "#317eb4"});
                $(this).parent().find('dd').removeClass("menu_chioce");
                $(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
                $(this).parent().find('img').attr("src","../images/left/select_xl01.png");
                $(".menu_chioce").slideUp();
                $(this).parent().find('dd').slideToggle();
                $(this).parent().find('dd').addClass("menu_chioce");
            });
        })
    </script>
</head>
<body id="bg">
<div class="container">
    <div class="leftsidebar_box">
         <div class="line"></div>
        <dl class="system_log">
            <dt class="first_dd"><img src="../images/left/select_xl01.png">
                <a href="addinformation.jsp" target="right">发布招聘信息</a>
            </dt>
            <dd class="first_dd"></dd>
            <dd class="first_dd" style="height: 15px;"></dd>
        </dl>
        <dl class="statistics">
            <dt class="first_dd"><img src="../images/left/select_xl01.png">
                <a href="${pageContext.request.contextPath}/JobInfoQueryByEnterpriseIdServlet?enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}" target="right">招聘信息管理</a>
            </dt>
            <dd class="first_dd"></dd>
            <dd class="first_dd" style="height: 15px;"></dd>
        </dl>

        <%--<dl class="custom">--%>
            <%--<dt><img src="../images/left/select_xl01.png">--%>
                <%--<a href="resumeinfo.jsp" target="right">审核实习申请</a>--%>
            <%--</dt>--%>
            <%--<dd class="first_dd"></dd>--%>
            <%--<dd class="first_dd" style="height: 10px;"></dd>--%>
        <%--</dl>--%>

        <dl class="app">
            <dt><img src="../images/left/select_xl01.png">
                <a href="${pageContext.request.contextPath}/EnterpriseStudentQueryAllServlet?pageNo=1&pageSize=1&enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}" target="right">查询学生信息</a>
            </dt>
            <dd class="first_dd"></dd>
            <dd class="first_dd" style="height: 10px;"></dd>
        </dl>
        <dl class="cloud">
            <dt><img src="../images/left/select_xl01.png">
                <a href="student-score.jsp" target="right">评判学生成绩</a>
            </dt>
            <dd class="first_dd"></dd>
            <dd class="first_dd" style="height: 10px;"></dd>
        </dl>
        <dl class="syetem_management">
            <dt><img src="../images/left/select_xl01.png">
                <a href="${pageContext.request.contextPath}/EnterpriseQueryAllResumesServlet?enterpriseId=${sessionScope.EnterpriseInfo.getEnterpriseId()}" target="right">审核简历信息</a>
            </dt>
            <dd class="first_dd"></dd>
            <dd class="first_dd" style="height: 10px;"></dd>
        </dl>

        <dl class="source" style="position:absolute;bottom: 50px;width: 100%">
            <dt><img src="../images/left/select_xl01.png">
                <a href="${pageContext.request.contextPath}/LogoutServlet" target="_blank">注销</a>
            </dt>
            <%--<dd class="first_dd"></dd>--%>
            <%--<dd class="first_dd" style="height: 10px;"></dd>--%>
        </dl>

    </div>
</div>
</body>
</html>