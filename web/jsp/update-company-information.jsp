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
    <%--<meta http-equiv="refresh" content="10">--%>
    <meta charset="UTF-8">
    <title>修改企业信息</title>
    <link rel="stylesheet" type="text/css" href="../css/manger-addinformation.css">
        <!--下拉框样式-->
    <style type="text/css">
        .selectbox{ float:left;margin-left:10px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        .element::-webkit-scrollbar {display:none}
    </style>
    <script type="text/javascript" src="../js/update_enterprise.js"></script>
    <script language="javascript">
        function validate(){
            //密码验证 ^\d{2,}$
            var enterprise_password = document.myform.enterprise_password.value;
            var exp = new RegExp(/^\d{2,}$/);
            if(!exp.test(enterprise_password)){
                alert("密码不符");
                document.myform.enterprise_password.focus();//光标定位
                return false;//防止向下进行
            }
            //重复密码
            var enterprise_repassword = document.myform.enterprise_repassword.value;
            if(enterprise_repassword!=enterprise_password){
                alert("密码不一致不符");
                document.myform.enterprise_repassword.focus();//光标定位
                return false;//防止向下进行
            }
        }
    </script>
    <%--<script type="text/javascript">--%>
        <%--if(window !=top){--%>
            <%--top.location.href=location.href;--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body style="overflow-x:hidden;text-align: center;">
<div class="container">

    <div class="checkout-title">
        <span><hr class="hrLine" style="width:300px;"/>修改企业信息<hr class="hrLine" style="width:300px;"/></span>
    </div>

    <div>
        <form id="myform" name="myform" theme="simple" method="post" action="${pageContext.request.contextPath}/UpdateEnterpriseManagerServlet"  onsubmit="return validate()">
            <table border="0" width="100%"  style="text-align: center;margin-left: 150px;">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>企业账号:</h3>
                                <p>
                                    <input class="text2" type="text" name="enterprise_id" value="<%=session.getAttribute("enterprise_id")%>" readonly="readonly" style="padding: 10px 0 10px 0"> </input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>账户管理员:</h3>
                                <p>
                                    <input class="text2" type="text" name="enterprise_manager" value="<%=session.getAttribute("enterprise_manager")%>" style="padding: 10px 0 10px 0"> </input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>企业名称:</h3>
                                <p>
                                    <input class="text2" type="text" name="enterprise_name" value="<%=session.getAttribute("enterprise_name")%>"  style="padding: 10px 0 10px 0"></input>
                                </p>
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
                                    <input  class="text2" type="password" name="enterprise_password" value="<%=session.getAttribute("enterprise_password")%>"  style="padding: 10px 0 10px 0"></input>
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
                                    <input  class="text2" type="password" name="enterprise_repassword" value=""  placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>企业简介:</h3>
                                <p>
                                    <textarea class="text1" name="enterprise_introduce" value="" style=" height:300px;"><%=session.getAttribute("enterprise_introduce")%></textarea>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>电话:</h3>
                                <p>
                                    <input class="text2" type="text" name="enterprise_tel" value="<%=session.getAttribute("enterprise_tel")%>"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>邮箱:</h3>
                                <p>
                                    <input class="text2" type="text" name="email" value="<%=session.getAttribute("email")%>"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>地址:</h3>
                                <p>
                                    <textarea class="text1" name="enterprise_address" value="" style=" height:115px;"><%=session.getAttribute("enterprise_address")%></textarea>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" class="btn" style="float: left;margin-left: 300px;" value="保存修改信息">
                        <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>
                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>