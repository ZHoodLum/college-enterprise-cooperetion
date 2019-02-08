<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>mangerhead</title>
    <style type="text/css">
        body{
            background-color: #b7b7b7;
            color: white;
        }
        #login{margin:2px 0 10px 0;}
        #title{font-size: 30px;margin:0 auto;float:left;margin-left:50px;transition: 2s;font-family:华文行楷}
        #title1{
            position:absolute;
            top:21px;
            left:1140px;
            font-size: 14px;
        }
        a{
            color: black;
            text-decoration: none;
        }
        #title:hover{cursor: pointer;/*光标点击 宽度向右移动50*/transform: translateX(80px);}
        #title1 a:visited {color:black;}
        #title1 a:hover {color:blue; text-decoration: none;}
        #circle {
            position:absolute;
            top:12px;
            left:1100px;
            width: 30px;
            height: 30px;
            border: 2px white solid;
            -moz-border-radius: 15px;
            -webkit-border-radius: 15px;
            border-radius:15px;
        }
    </style>
</head>
<body>
    <div id="login">
        <span id="title"><a href="${pageContext.request.contextPath}/JobInfoQueryAllServlet" style="text-decoration: none;color:black;" target="_top">沈工校企实习合作系统</a></span>
        <%--<span id="title"><a href="../main.jsp" style="text-decoration: none;color:black;" target="_top">沈工校企实习合作系统</a></span>--%>
        <%--<span id="title"><a href="../main.jsp" style="text-decoration: none;color:black;" target="_top">College Enterprise Cooperetion</a></span>--%>
        <a href="update-company-information.jsp" style="text-decoration: none;color:black;" target="right">
            <img src="../images/loginusers.png" id="circle">
            <span id="title1">
                欢迎：${sessionScope.EnterpriseInfo.getEnterpriseName()}&nbsp;&nbsp;&nbsp;${sessionScope.EnterpriseInfo.getEnterpriseManager()}
            </span>
        </a>
    </div>
</body>
</html>