<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>updatemanger-information</title>
    <link rel="stylesheet" type="text/css" href="../css/manger-addinformation.css">
    <!--
   下拉框样式
   -->
    <style type="text/css">
        .selectbox{ float:left;margin-left:10px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
    <script language="javascript">
        function validate(){
            //密码验证 ^\d{2,}$
            var admin_password = document.myform.admin_password.value;
            var exp = new RegExp(/^\d{2,}$/);
            if(!exp.test(admin_password)){
                alert("密码不符");
                document.myform.admin_password.focus();//光标定位
                return false;//防止向下进行
            }
            //重复密码
            var admin_repassword = document.myform.admin_repassword.value;
            if(admin_repassword!=admin_password){
                alert("密码不一致不符");
                document.myform.admin_repassword.focus();//光标定位
                return false;//防止向下进行
            }
        }
    </script>
</head>
<body>
<div class="container">

    <div class="checkout-title">
        <span><hr class="hrLine" style="width:500px;"/>修改您的信息<hr class="hrLine" style="width:500px;"/></span>
    </div>

    <div>
        <form id="myform" name="myform" action="${pageContext.request.contextPath}/UpdateAdminInfoServlet" onsubmit="return validate()">
            <table border="0" width="100%"  style="text-align: center;margin-left: 260px;">
                <tr>
                    <td>
                        <ul>
                            <li id="firtsts">
                                <h3>管理员账号:</h3>
                                <p>
                                    <input type="hidden" name="id" value="${sessionScope.AdminInfo.getId()}"/>
                                    <input type="text" name="admin_id" value="${sessionScope.AdminInfo.getAdminId()}"/>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li id="twos">
                                <h3>管理员名称:</h3>
                                <p><input type="text" name="admin_name" value="${sessionScope.AdminInfo.getAdminName()}"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>登陆密码:</h3>
                                <p>
                                    <input  class="text2" type="password" name="admin_password" value="${sessionScope.AdminInfo.getAdminPassword()}"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>重复密码:</h3>
                                <p>
                                    <input  class="text2" type="password" name="admin_repassword" value=""  placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" class="btn" style="float: left;margin-left: 210px;" value="保存修改信息">
                        <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>
                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>