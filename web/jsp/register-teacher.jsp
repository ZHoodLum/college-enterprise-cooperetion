<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterTeacher</title>
<link rel="stylesheet" type="text/css" href="../css/register-information.css">
  <!--
    下拉框样式
    -->
  <style type="text/css">
    .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
    .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
    .selectbox select option{ padding:5px;}
  </style>
</head>
<body>
<form id="myform" name="myform" action="*******" method="post">
  <div class="main">
    <ul>
      <li class="first">
        <h3>教师账号：</h3>
        <p>
          <input type="text" id="tid" name="name" placeholder="请填写您的学号！"/>
          <font color="#C0C0C0">6-10个数字，可使用数字！</font>
        </p>
      </li>
      <li class="first">
        <h3>教师姓名：</h3>
        <p>
          <input type="text" id="tname" name="name" placeholder="请填写您的姓名！"/>
          <font color="#C0C0C0">2位以上字符，可使用字母、汉字等其他字符！</font>
        </p>
      </li>
      <li>
        <h3>密码：</h3>
        <p>
          <input type="password" id="tpwd" name="passwd" placeholder="请填写您的密码！"/>
          <font color="#C0C0C0">6-20个字符，可使用大小写字母、数字等特殊字符,区分大小写！</font>
        </p>
      </li>
      <li>
        <h3>确认密码：</h3>
        <p>
          <input type="password" id="repwd" name="passwd_conf" placeholder="请填写再次确认您的密码！"/>
          <font color="#C0C0C0">请再次输入密码！</font>
        </p>
      </li>
      <li>
        <h3>性别：</h3>
        <p>
        <div class="selectbox">
          <select>
            <option value="0">男</option>
            <option value="1">女</option>
          </select>
        </div>
        </p>
      </li>
      <li>
        <h3>职称：</h3>
        <p>
          <input type="text" id="tjob" name="user_name" placeholder="请填写您的所在专业！"/>
          <font color="#C0C0C0">2-30位字符，可输入大小写字母、汉字！</font>
        </p>
      </li>
      <li>
        <h3>电话：</h3>
        <p>
          <input type="text" id="tphone" name="user_name" placeholder="请填写您的电话！"/>
          <font color="#C0C0C0">11位字符，仅限中国手机号！</font>
        </p>
      </li>
      <li>
        <h3>邮箱：</h3>
        <p>
          <input type="text" id="email" name="user_name" placeholder="请填写您的邮箱！"/>
          <font color="#C0C0C0">可使用大小写字母、数字，例如195456587@qq.com!</font>
        </p>
      </li>
      <li>
        <h3>学院：</h3>
        <p>
          <input type="text" id="tcollege" name="user_name" placeholder="请填写您的学院！"/>
          <font color="#C0C0C0">2-30位字符，可输入大小写字母、汉字！</font>
        </p>
      </li>
      <li class="last">
        <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="注册" tabindex="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="重置" tabindex="3">
      </li>
    </ul>
  </div>
</form>
</body>
</html>