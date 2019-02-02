<%@ page import="com.zdy.school.vo.StudentInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zdy.school.vo.TeacherInfo" %>
<%@ page import="com.zdy.school.service.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员修改学生信息</title>
    <link rel="stylesheet" type="text/css" href="../css/manger-addinformation.css">
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <!--下拉框样式-->
    <style type="text/css">
        .selectbox{ float:left;margin-left:10px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        ul li{margin-left: 260px;}
    </style>
    <script type="text/javascript">
        function del(enterpriseId,pageNo){
            if(confirm("是否删除？")){
                document.location = "${pageContext.request.contextPath}/AdminDeleteEnterpriseInfoServlet?enterpriseId=" + enterpriseId + "&pageNo=" + pageNo + "";
                alert("删除成功");
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="checkout-title">
            <span><hr class="hrLine" style="width:300px;"/>修改企业信息<hr class="hrLine" style="width:300px;"/></span>
        </div>

        <div>
            <form id="myform" name="myform" theme="simple" method="post" action="${pageContext.request.contextPath}/AdminUpdateEnterpriseInfoServlet"  onsubmit="return validate()">
                <table border="0" width="98%">
                    <tr>
                        <td>
                            <ul>
                                <li>
                                    <h3>企业账号:</h3>
                                    <p>
                                        <input type="hidden" id="pageNo" name="pageNo" value="1" />
                                        <input class="text2" type="text" name="enterprise_id" value="${list.enterpriseId}" style="background-color: #9d9d9d;padding: 10px 0 10px 0"> </input>
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
                                        <input class="text2" type="text" name="enterprise_manager" value="${list.enterpriseManager}" style="padding: 10px 0 10px 0"> </input>
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
                                        <input class="text2" type="text" name="enterprise_name" value="${list.enterpriseName}"  style="padding: 10px 0 10px 0"></input>
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
                                        <input  class="text2" type="text" name="enterprise_password" value="${list.enterprisePassword}"  style="padding: 10px 0 10px 0"></input>
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
                                        <textarea class="text1" name="enterprise_introduce" value="" style=" height:300px;">${list.enterpriseIntroduce}</textarea>
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
                                        <input class="text2" type="text" name="enterprise_tel" value="${list.enterpriseTel}"  style="padding: 10px 0 10px 0"></input>
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
                                        <input class="text2" type="text" name="email" value="${list.email}"  style="padding: 10px 0 10px 0"></input>
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
                                        <textarea class="text1" name="enterprise_address" value="" style=" height:115px;">${list.enterpriseAddress}</textarea>
                                    </p>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" class="btn" style="float: left;margin-left: 420px;" value="保存信息">
                            <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>
                            <a href="javascript:void(0)" id="btn1" class="btn" style="float: left;margin-left: 10px;background-color: red" onclick="return del(${list.enterpriseId},1)">删除信息</a>
                        </td>
                    </tr>

                </table>
            </form>

        </div>
    </div>
</body>
</html>