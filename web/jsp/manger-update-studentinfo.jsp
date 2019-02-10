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
        function del(studentId,pageNo){
            if(confirm("是否删除？")){
                document.location = "${pageContext.request.contextPath}/AdminDeleteStudentInfoServlet?studentId=" + studentId + "&pageNo=" + pageNo + "";
                alert("删除成功");
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="checkout-title">
        <span><hr class="hrLine" style="width:400px;"/>修改学生信息<hr class="hrLine" style="width:400px;"/></span>
    </div>
    <div>
        <form id="myform" name="myform" action="${pageContext.request.contextPath}/AdminUpdateStudentInfoServlet" onsubmit="return validate()">
            <table border="0" width="98%">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学生学号:</h3>
                                <p>
                                    <input type="hidden" id="student_id" name="student_id" value="${list.studentId}" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                    <input type="hidden" id="pageNo" name="pageNo" value="1" />
                                    <input class="text2" type="text" name="student_account" value="${list.studentAccount}"  style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学生账号:</h3>
                                <p><input class="text2" type="text" name="student_tel" value="${list.studentTel}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学生名称:</h3>
                                <p><input class="text2" type="text" name="student_name" value="${list.studentName}" style="padding: 10px 0 10px 0"/></p>
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
                                    <input  class="text2" type="text" name="student_password" value="${list.studentPassword}"  style="padding: 10px 0 10px 0"></input>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>性别：</h3>
                                <div class="selectbox">
                                    <select name="student_sex">
                                        <option value="男" ${list.studentSex.equals("男")?"selected":""}>男</option>
                                        <option value="女" ${list.studentSex.equals("女")?"selected":""}>女</option>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li >
                                <h3>专业:</h3>
                                <p><input class="text2" type="text" name="major" value="${list.major}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>籍贯:</h3>
                                <p><input class="text2" type="text" name="city" value="${list.city}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>邮箱:</h3>
                                <p><input class="text2" type="text" name="email" value="${list.email}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学院:</h3>
                                <p><input class="text2" type="text" name="student_college" value="${list.studentCollege}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" class="btn" style="float: left;margin-left:420px;" value="保存信息">
                        <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>
                    <a href="javascript:void(0)" id="btn1" class="btn" style="float: left;margin-left: 10px;background-color: red" onclick="return del(${list.studentId},1)">删除信息</a>
                    </td>
                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>