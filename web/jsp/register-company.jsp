<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterCompany</title>
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
  <script type="text/javascript" src="../js/registercompany.js" ></script>
</head>
<body>
<div id="loginmodal"   style="overflow-y:auto;">

  <form id="myform" name="myform" action="*******" method="post" onsubmit="return validate()">
    <div class="main">
      <ul>
        <li class="first">
          <h3>企业账号：</h3>
          <p>
            <input type="text" id="eid" name="eid" placeholder="请填写贵公司账号！"
                    property="text" minLength="6" maxLength="10" requiredFieldError="请输入密码，6到10个字符，不允许输入特殊字符！" tooShortError="密码长度必须大于6"
                    tooLongError="密码不能超过12位"/>
            <font color="#C0C0C0">6-10个数字，可使用数字！</font>
          </p>
        </li>
        <li class="first">
          <h3>企业名称：</h3>
          <p>
            <input type="text" id="ename" name="ename" placeholder="请填写贵公司名称！"/>
            <font color="#C0C0C0">5位以上字符，可使用字母、数字、汉字等其他字符！</font>
          </p>
        </li>
        <li>
          <h3>密码：</h3>
          <p>
            <input type="password" id="epwd" name="epwd" placeholder="请填写您的密码！"
                    source="{passwd}" property="text" minLength="6" maxLength="12" requiredFieldError="请输入密码，6到12个字符，不允许输入特殊字符！" tooShortError="密码长度必须大于6"
                    tooLongError="密码不能超过12位"/>
            <font color="#C0C0C0">6-20个字符，可使用大小写字母、数字等特殊字符，区分大小写！</font>
          </p>
        </li>
        <li>
          <h3>确认密码：</h3>
          <p>
            <input type="password" id="repwd" name="repwd" placeholder="请填写再次确认您的密码！"/>
            <font color="#C0C0C0">请再次输入密码！</font>
          </p>
        </li>
        <li>
          <h3>地址：</h3>
          <p>
            <input type="text" id="eadd" name="eadd" placeholder="请填写贵公司的所在地址！"/>
            <font color="#C0C0C0">6-60个字符，可使用大小写字母、数字、汉字等特殊字符！</font>
          </p>
        </li>
        <li>
          <h3>电话：</h3>
          <p>
            <input type="text" id="ephone" name="ephone" placeholder="请填写贵公司的电话！"/>
            <font color="#C0C0C0">11位字符，仅限中国手机号！</font>
          </p>
        </li>
        <li>
          <h3>邮箱：</h3>
          <p>
            <input type="text" id="email" name="email" placeholder="请填写贵公司的邮箱！"/>
            <font color="#C0C0C0">可使用大小写字母、数字，例如195456587@qq.com!</font>
          </p>
        </li>
        <li>
          <h3>账号管理者：</h3>
          <p>
            <input type="text" id="emanger" name="emanger" placeholder="请填写此账号的账号管理者名！"/>
            <font color="#C0C0C0">2-20位字符，可输入大小写字母、汉字！</font>
          </p>
        </li>
        <li class="last">
          <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="注册" tabindex="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="reset" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="重置" tabindex="3">
          <!--onclick="javascript:if(confirm('确定要注册吗')){alert('注册成功!');return true;}return false;"-->
        </li>
      </ul>
    </div>
  </form>
</div>
</body>
</html>