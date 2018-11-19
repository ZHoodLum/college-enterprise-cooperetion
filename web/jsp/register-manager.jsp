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
  <script type="text/javascript" src="../js/registermanger.js" ></script>

</head>
<body>
<form id="myform" name="myform" action="${pageContext.request.contextPath}/InsertStudentInfoServlet" method="post"  onsubmit="return validate()">
  <div class="main1">
    <div class="main">
      <ul>
        <li class="first">
          <h3>管理员账号：</h3>
          <p>
            <input type="text" id="admin_id" name="admin_id" placeholder="请填写您的帐号！"/>
            <font color="#C0C0C0">3个以上数字，可使用数字！</font>
          </p>
        </li>
        <li class="first">
          <h3>管理员姓名：</h3>
          <p>
            <input type="text" id="admin_name" name="admin_name" placeholder="请填写您的姓名！"/>
            <font color="#C0C0C0">2位以上字符，可使用字母、汉字等其他字符！</font>
          </p>
        </li>
        <li>
          <h3>密码：</h3>
          <p>
            <input type="password" id="admin_password" name="admin_password" placeholder="请填写您的密码！"/>
            <font color="#C0C0C0">6-20个字符，可使用大小写字母、数字等特殊字符,区分大小写！</font>
          </p>
        </li>
        <li>
          <h3>确认密码：</h3>
          <p>
            <input type="password" id="admin_repassword" name="admin_repassword" placeholder="请填写再次确认您的密码！"/>
            <font color="#C0C0C0">请再次输入密码！</font>
          </p>
        </li>
        <li class="last">
          <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="注册" tabindex="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="reset" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="重置" tabindex="3">
        </li>
      </ul>
    </div>
  </div>
</form>
</body>
</html>