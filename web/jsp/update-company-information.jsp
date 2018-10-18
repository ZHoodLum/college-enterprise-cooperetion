<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>修改企业信息</title>
    <link rel="stylesheet" type="text/css" href="../css/manger-addinformation.css">
    <style type="text/css">
        .selectbox{ float:left;margin-left:10px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
    <script type="text/javascript" src="../js/update_enterprise.js"></script>
    <script type="text/javascript">
        var txtFocus = document.getElementById("ap_CarUnit");
        var position = 0;
        var userAgent=window.navigator.userAgent.toLowerCase();
        var isMozilla = /firefox/.test(userAgent);//火狐
        var isWwebkit = /webkit/.test(userAgent);//谷歌
        var ismsie = /msie/.test(userAgent);//IE
        var isOpera = /opera/.test(userAgent);

        if(ismsie || isMozilla){
            //如果是ie浏览器
            var range = txtFocus.createTextRange();
            range.move("character", position);
            range.select();
        }
        if(isWwebkit){
            txtFocus.setSelectionRange(position, position);
            txtFocus.focus();
        }
        function check2pwd() {
            if(enterprise_password.value != enterprise_repassword.value) {
                alert("两次输入密码不一致！")
                enterprise_password.value = "";
                enterprise_repassword.value = "";
            }
        }
    </script>
</head>
<body style="overflow-x:hidden;text-align: center">
<div class="container">

    <div class="checkout-title">
        <span><hr class="hrLine" style="width:300px;"/>修改企业信息<hr class="hrLine" style="width:300px;"/></span>
    </div>

    <div>
        <form id="myform" name="myform" theme="simple" method="post" action="/UpdateEnterpriseManagerServlet">
            <table border="0" width="100%"  style="text-align: center;margin-left: 150px;">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>企业账号:</h3>
                                <p>
                                    <input class="text2" name="enterprise_id" value="<%=session.getAttribute("enterprise_id")%>"> </input>
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
                                    <input class="text2" name="enterprise_name" value="<%=session.getAttribute("enterprise_name")%>"></input>
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
                                    <input  class="text2" name="enterprise_password" value="<%=session.getAttribute("enterprise_password")%>"></input>
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
                                    <input  class="text2" name="enterprise_repassword" value=""  placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"></input>
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
                                    <input class="text2" name="enterprise_tel" value="<%=session.getAttribute("enterprise_tel")%>"></input>
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
                                    <input class="text2" name="email" value="<%=session.getAttribute("email")%>"></input>
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
                                    <textarea class="text1" name="enterprise_address" value=""><%=session.getAttribute("enterprise_address")%></textarea>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" class="btn" style="float: left;margin-left: 400px;" value="保存修改信息">
                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>