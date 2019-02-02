<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterManager</title>
<link rel="stylesheet" type="text/css" href="../css/register-information.css">
  <!--
    下拉框样式
    -->
  <style type="text/css">
    .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
    .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
    .selectbox select option{ padding:5px;}
  </style>

  <!--js验证注册信息-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/registermanger.js" ></script>

</head>
<body>
<div style="text-align: center;font-size: 22px;font-family: YouYuan;margin-top: 100px;">
  抱歉，您没有该权限！
</div>
</body>
</html>