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
    <!--下拉框样式-->
    <style type="text/css">
        .selectbox{ float:left;margin-left:20px;width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        .element::-webkit-scrollbar {display:none}
        #input1 input{
            width:10px;
        }
    </style>
    <script language="javascript">
        function validate(){
            //密码验证 ^\d{2,}$
            var teacher_password = document.myform.teacher_password.value;
            var exp = new RegExp(/^\d{2,}$/);
            if(!exp.test(teacher_password)){
                alert("密码不符");
                document.myform.teacher_password.focus();//光标定位
                return false;//防止向下进行
            }
            //重复密码
            var teacher_repassword = document.myform.teacher_repassword.value;
            if(teacher_repassword!=teacher_password){
                alert("密码不一致不符");
                document.myform.teacher_repassword.focus();//光标定位
                return false;//防止向下进行
            }
        }
    </script>
</head>
<body  style="overflow-x:hidden;text-align: center;">
<div class="container">

    <div class="checkout-title">
        <span><hr class="hrLine" style="width:500px;"/>修改教师信息<hr class="hrLine" style="width:500px;"/></span>
    </div>

    <div>
        <form id="myform" name="myform" action="${pageContext.request.contextPath}/UpdateTeacherInfoServlet" onsubmit="return validate()">
            <table border="0" width="100%"  style="text-align: center;margin-left: 260px;">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>教师编号:</h3>
                                <p>
                                    <input type="hidden" name="teacher_id" value="<%=session.getAttribute("teacher_id")%>" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                    <input type="text" name="teacher_account" value="<%=session.getAttribute("teacher_account")%>" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
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
                                <p><input type="text" name="teacher_name" value="<%=session.getAttribute("teacher_name")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>教师账号:</h3>
                                <p><input class="text2" type="text" name="teacher_tel" value="<%=session.getAttribute("teacher_tel")%>" style="padding: 10px 0 10px 0"/></p>
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
                                    <input  class="text2" type="password" name="teacher_password" value="<%=session.getAttribute("teacher_password")%>"  style="padding: 10px 0 10px 0"/>
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
                                    <input  class="text2" type="password" name="teacher_repassword" value=""  placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"  style="padding: 10px 0 10px 0"/>
                                </p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td >
                        <ul>
                            <%--<li id="input1">--%>
                            <li>
                                <h3>性别：</h3>
                                    <%--<input type="radio" name="teacher_sex" value="男" <%=session.getAttribute("teacher_sex").equals("男")?"checked":""%>/>男--%>
                                    <%--<input type="radio" name="teacher_sex" value="女" <%=session.getAttribute("teacher_sex").equals("女")?"checked":""%>/>女--%>
                                <div class="selectbox">
                                    <select name="teacher_sex">
                                        <option value="男" <%=session.getAttribute("teacher_sex").equals("男")?"selected":""%>>男</option>
                                        <option value="女" <%=session.getAttribute("teacher_sex").equals("女")?"selected":""%>>女</option>
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
                                <p><input type="text" name="teacher_job"  value="<%=session.getAttribute("teacher_job")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>邮箱:</h3>
                                <p><input type="text" name="email"  value="<%=session.getAttribute("email")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li id="lasts">
                                <h3>学院:</h3>
                                <p><input type="text" name="teacher_college" value="<%=session.getAttribute("teacher_college")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>

                <tr>
                    <td>
                        <%--<a href="" class="btn" style="float: left;margin-left: 320px;">保存修改信息</a>--%>
                            <input type="submit" class="btn" style="float: left;margin-left: 220px;" value="保存修改信息">
                            <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>

                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>