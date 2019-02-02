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
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <!--下拉框样式-->
    <style type="text/css">
        .selectbox{ float:left;margin-left:20px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        #input1 input{width:10px;}
        ul li{margin-left: 260px;}
    </style>
    <script type="text/javascript">
        function del(teacherId,pageNo){
            if(confirm("是否删除？")){
                document.location = "${pageContext.request.contextPath}/AdminDeleteTeacherInfoServlet?teacherId=" + teacherId + "&pageNo=" + pageNo + "";
                alert("删除成功");
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="checkout-title">
        <span><hr class="hrLine" style="width:500px;"/>修改教师信息<hr class="hrLine" style="width:500px;"/></span>
    </div>
    <div>
        <form id="myform" name="myform" action="${pageContext.request.contextPath}/AdminUpdateTeacherInfoServlet" onsubmit="return validate()">
            <table border="0" width="98%">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>教师编号:</h3>
                                <p>
                                    <input type="hidden" name="teacher_id" value="${list.teacherId}" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                    <input type="hidden" id="pageNo" name="pageNo" value="1" />
                                    <input type="text" name="teacher_account" value="${list.teacherAccount}"  style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>教师名称:</h3>
                                <p><input type="text" name="teacher_name" value="${list.teacherName}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>教师账号:</h3>
                                <p><input class="text2" type="text" name="teacher_tel" value="${list.teacherTel}" style="padding: 10px 0 10px 0"/></p>
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
                                    <input  class="text2" type="text" name="teacher_password" value="${list.teacherPassword}"  style="padding: 10px 0 10px 0"/>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td >
                        <ul>
                            <li>
                                <h3>性别：</h3>
                                <div class="selectbox">
                                    <select name="teacher_sex">
                                        <option value="男" ${list.teacherSex.equals("男")?"selected":""}>男</option>
                                        <option value="女" ${list.teacherSex.equals("女")?"selected":""}>女</option>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>职称:</h3>
                                <p><input type="text" name="teacher_job"  value="${list.teacherJob}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>邮箱:</h3>
                                <p><input type="text" name="email"  value="${list.email}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li id="lasts">
                                <h3>学院:</h3>
                                <p><input type="text" name="teacher_college" value="${list.teacherCollege}" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>

                <tr>
                    <td>
                             <input type="submit" class="btn" style="float: left;margin-left: 420px;" value="保存信息">
                            <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>
                            <a href="javascript:void(0)" id="btn1" class="btn" style="float: left;margin-left: 10px;background-color: red" onclick="return del(${list.teacherId},1)">删除信息</a>
                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>