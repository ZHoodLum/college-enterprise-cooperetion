<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterStudent</title>
<link rel="stylesheet" type="text/css" href="../css/register-information.css">
  <!--
    下拉框样式
    -->
  <style type="text/css">
    .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
    .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
    .selectbox select option{ padding:5px;}
  </style>

  <!--js验证注册信息-->
  <script type="text/javascript" src="../js/registerstudent.js" ></script>
  <script>  
           function check2pwd() {  
                   if(spwd.value != repwd.value) {  
                       alert("两次输入密码不一致！");
                       spwd.value = "";  
                       repwd.value = "";  
                   }  
           }  
       </script>
</head>
<body>
<form id="myform" name="myform" action="../RegisterServlet" method="post" theme="simple" onsubmit="return validate()">
  <div class="main1">
    <div class="main">
      <ul>
	    <li class="first">
          <h3>学生账号：</h3>
          <p>
            <input type="text" id="sid" name="student_id" placeholder="请填写您的学号！"/>
            <font color="#C0C0C0">6-10个数字，可使用数字！</font>
          </p>
        </li>
        <li>
          <h3>电话：</h3>
          <p>
            <input type="text" id="sphone" name="student_tel" placeholder="请填写您的电话,此手机号将作为您的账号"/>
            <font color="#C0C0C0">11位字符，仅限中国手机号！</font>
          </p>
        </li>
        <li class="first">
          <h3>学生姓名：</h3>
          <p>
            <input type="text" id="sname" name="student_name" placeholder="请填写您的真实姓名！"/>
            <font color="#C0C0C0">2位以上字符，可使用字母、汉字等其他字符！</font>
          </p>
        </li>
        <li>
          <h3>密码：</h3>
          <p>
            <input type="password" id="spwd" name="student_password" placeholder="请填写您的密码！"
                   source="{passwd}" property="text" minLength="6" maxLength="12" requiredFieldError="请输入密码，6到12个字符，不允许输入特殊字符！" tooShortError="密码长度必须大于6"
                   tooLongError="密码不能超过12位"/>
            <font color="#C0C0C0">6-20个字符，可使用大小写字母、数字等特殊字符,区分大小写！</font>
          </p>
        </li>
        <li>
          <h3>确认密码：</h3>
          <p>
            <input type="password" id="repwd" name="passwd_conf" placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"/>
            <font color="#C0C0C0">请再次输入密码！</font>
          </p>
        </li>
        <li>
          <h3>性别：</h3>
          <p>
            <div class="selectbox">
              <select name="student_sex">
                <option value="男">男</option>
                <option value="女">女</option>
              </select>
           </div>
          </p>
        </li>
        <li>
          <h3>专业：</h3>
          <p>
            <input type="text" id="smajor" name="major" placeholder="请填写您的所在专业！"/>
            <font color="#C0C0C0">2-30位字符，可输入大小写字母、汉字！</font>
          </p>
        </li>
        <li>
          <h3>籍贯：</h3>
          <p>
            <input type="text" id="scity" name="city" placeholder="请填写您的籍贯！"/>
            <font color="#C0C0C0">6-60个字符，可使用大小写字母、数字、汉字等特殊字符！</font>
          </p>
        </li>
        
        <li>
          <h3>邮箱：</h3>
          <p>
            <input type="text" id="semail" name="email" placeholder="请填写您的邮箱！"/>
            <font color="#C0C0C0">可使用大小写字母、数字，例如195456587@qq.com!</font>
          </p>
        </li>
        <li>
          <h3>学院：</h3>
          <p>
            <input type="text" id="scollege" name="student_college" placeholder="请填写您的学院！"/>
            <font color="#C0C0C0">2-30位字符，可输入大小写字母、汉字！</font>
          </p>
        </li>
        <li>
          <h3>在校指导教师：</h3>
          <p>
            <input type="text" id="tname" name="user_name" placeholder="请填写您的在校指导教师！"/>
            <font color="#C0C0C0">2-20位字符，可输入大小写字母、汉字！</font>
          </p>
        </li>
        <li class="last">
          <button type="submit" name="regiterstudent" id="loginbtn" class="flatbtn-blu hidemodal" value="学生" tabindex="3">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="reset" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="重置" tabindex="3">
        </li>
      </ul>
    </div>
  </div>
</form>
</body>
</html>