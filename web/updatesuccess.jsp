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
    <title>Title</title>
    <style type="text/css">
        .base {height: 9em; left: 50%; margin: -7.5em; padding: 3em; position: absolute; top: 30%; width: 12em; transform: rotateX(45deg) rotateZ(45deg); transform-style: preserve-3d;}
        .cube, .cube:after, .cube:before {content: ''; float: left; height: 3em; position: absolute; width: 3em;}
        .cube i{position: absolute; font-style: normal; width: 100%; height: 100%; left:0; top:0; display: flex; justify-content:center; align-items: center; color: #fff;}
        /* Top */
        .cube {background-color: #42cca2; position: relative; transform: translateZ(3em); transform-style: preserve-3d; transition: .25s; box-shadow: 13em 13em 1.5em rgba(0, 0, 0, 0.1); animation: anim 1s infinite;}
        .cube:after {background-color: #2fb78e; transform: rotateX(-90deg) translateY(3em); transform-origin: 100% 100%;}
        .cube:before {background-color: #209974; transform: rotateY(90deg) translateX(3em); transform-origin: 100% 0;}
        .cube:nth-child(1) {animation-delay: 0.05s;}
        .cube:nth-child(2) {animation-delay: 0.1s;}
        .cube:nth-child(3) {animation-delay: 0.15s;}
        .cube:nth-child(4) {animation-delay: 0.2s;}
        .cube:nth-child(5) {animation-delay: 0.25s;}
        .cube:nth-child(6) {animation-delay: 0.3s;}
        .cube:nth-child(7) {animation-delay: 0.35s;}
        .cube:nth-child(8) {animation-delay: 0.4s;}
        .cube:nth-child(9) {animation-delay: 0.45s;}
        .cube:nth-child(10) {animation-delay: 0.5s;}
        .cube:nth-child(11) {animation-delay: 0.55s;}
        .cube:nth-child(12) {animation-delay: 0.6s;}
        .cube:nth-child(13) {animation-delay: 0.65s;}
        .cube:nth-child(14) {animation-delay: 0.7s;}
        @keyframes anim {
            50% {
                transform: translateZ(0.5em);
            }
        }
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
<h2>恭喜您，修改成功！</h2>
<!--<h5>提示：重新登录后即可生效！！！！！<a href="jsp/login.jsp">重新登陆</a> </h5>-->
<h5>提示：重新登录后即可生效！！！！！<a href="${pageContext.request.contextPath}/LogoutServlet"  target="_blank">重新登陆</a> </h5>
<div class='base'>

    <div class='cube'><i>新</i></div>
    <div class='cube'><i>的</i></div>
    <div class='cube'><i>希</i></div>
    <div class='cube'><i>望</i></div>
    <div class='cube'><i>新</i></div>
    <div class='cube'><i>的</i></div>
    <div class='cube'><i>征</i></div>
    <div class='cube'><i>程</i></div>
    <div class='cube'><i>新</i></div>
    <div class='cube'><i>的</i></div>
    <div class='cube'><i>收</i></div>
    <div class='cube'><i>获</i></div>
    <div class='cube'><i>！</i></div>
    <div class='cube'><i>！</i></div>
</div>
</body>
</html>