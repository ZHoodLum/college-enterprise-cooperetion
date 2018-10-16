<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login用户登录</title>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-3.3.4.css">
	<link rel="stylesheet" type="text/css" href="../css/font-awesome.4.6.0.css">
	<link rel="stylesheet" href="../css/btabs.css" type="text/css">
	<!--登陆界面 弹窗-->
	<link rel="stylesheet" type="text/css" media="all" href="../css/login.css">
	<style type="text/css">
		div.menuSideBar { }
		div.menuSideBar li.nav-header { font-size: 14px; padding: 3px 15px; }
		div.menuSideBar .nav-list > li > a, div.menuSideBar .dropdown-menu li a { -webkit-border-radius: 0px; -moz-border-radius: 0px; -ms-border-radius: 0px; border-radius: 0px; }
		<!--下拉框样式-->
		.selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
		.selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:100%; padding-right: 18%; background:none; border: none;}
		.selectbox select option{ padding:5px;} 
	</style>
	<script src="../js/jquery-1.10.2.js"></script>
	<script src="../js/bootstrap-3.3.4.js"></script>
	<script type="text/javascript" src="../js/b.tabs.min.js" ></script>
	<script type="text/javascript" src="../js/demo.js" ></script>

	<script type="text/javascript" src="<%=path %>/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/particles.js"></script>
	<script type="text/javascript" src="<%=path %>/js/app.js"></script>
	<script>
		var path = "<%=path %>";
	</script>
	<script language="javascript">
	     function check(form){
	         if (form.getElementById("username").value==""){
	             alert("请输入帐号!");form.name.focus();return false;[]
	         }
	         if (form.getElementById("username").value==""){
	             alert("输入的账号不正确，请重新输入帐号!");form.name.focus();return false;
	         }
	         if (form.getElementById("password").value==""){
	             alert("请输入密码!");form.pwd.focus();return false;
	         }
	         if (form.getElementById("password").value==""){
	             alert("输入的密码不正确，请输入密码!");form.pwd.focus();return false;
	             request.setAttribute("输入的密码不正确，请输入密码!")
	
	         }
	     }
	 </script> 
</head>
<body>
<div class="navs">
  <div class="nav_left">
    <a href="../main.jsp">校企实习信息网</a>
    
  </div>
</div>
<div class="content"/>
<div class="container"/>
    <div class="col-md-10" id="mainFrameTabs" style="padding : 0px;">
      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active noclose"><a href="#bTabs_navTabsMainPage" data-toggle="tab" style="font-size: 16px;margin-top: 20px;margin-left: 80px;">欢迎来到登陆界面</a></li>
      </ul>

      <!-- Tab panes -->
      <div class="tab-content">

        <div id="loginmodal"   style="overflow-y:auto;">

          <h1>登陆入口</h1>
          <!-- 响应action-->
	          <!--  <form id="loginform" name="loginform" method="post" action="../LoginServletController">-->
	         <form id="loginform" name="loginform" method="post" action="../LoginServlet"> 

	            <label id="username">用户名:</label>
	            <!-- 登录名-->
	            <input type="text"name="useraccount" id="useraccount" class="txtfield" tabindex="1" value="14798765432">
	
	            <label id="password">密码:</label>
	            <!--密码-->
	            <input type="password" name="userpassword" id="userpassword" class="txtfield" tabindex="2" value="12345678">
	
	            <label>登陆者身份:</label>
	            <div class="selectbox" style="margin-bottom: 20px;">
	              <select name="limits">
	                <option value="学生" style="font-size: 16px;" selected>学生</option>
	                <option value="教师" style="font-size: 16px;">教师</option>
	                <option value="企业" style="font-size: 16px;">企业</option>
	                <option value="管理员" style="font-size: 16px;">管理员</option>
	              </select>
	            </div>
	            <div class="group-inputs">
		  <table>
		  	<tr>   
				<td> <input type="text" class="input-wrapper border no-border-b" id="captcha" name="code" placeholder="验证码" required="required" value=""></td>
				<td> <img src="<%=path %>/codeServlet" alt="验证码" class="captcha" width="100" height="38" onclick="javascript:this.src='<%=path %>/codeServlet?'+ new Date().getTime()"></td>
			</tr>
		  </table> 
				<%--
	             <input type="text" class="input-wrapper border no-border-b" id="captcha" placeholder="验证码" required="required">
					<img src="../images/captcha.gif" alt="验证码" class="captcha" width="100" height="38">
				--%>
	            	
				</div>
	            <div class="center" style="margin-top:20px;">
	              <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="登陆" tabindex="3">
	              
	              <input type="button" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="注册" tabindex="3"
	                     onclick="document.location.href='register.jsp'">
	            </div>
	          </form>
      	  </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>