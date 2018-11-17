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
    <script type="text/javascript" src="../js/update_enterprise.js"></script>
    <script language="javascript">
        function validate(){
            //密码验证 ^\d{2,}$
            var student_password = document.myform.student_password.value;
            var exp = new RegExp(/^\d{2,}$/);
            if(!exp.test(student_password)){
                alert("密码不符");
                document.myform.student_password.focus();//光标定位
                return false;//防止向下进行
            }
            //重复密码
            var student_repassword = document.myform.student_repassword.value;
            if(student_repassword!=student_password){
                alert("密码不一致不符");
                document.myform.student_repassword.focus();//光标定位
                return false;//防止向下进行
            }
        }
    </script>
</head>
<body>
<div class="container">

    <div class="checkout-title">
        <span><hr class="hrLine" style="width:500px;"/>修改学生信息<hr class="hrLine" style="width:500px;"/></span>
    </div>

    <div>
        <form id="myform" name="myform" action="${pageContext.request.contextPath}/UpdateStudentInfoServlet" onsubmit="return validate()">
            <table border="0" width="100%"  style="text-align: center;margin-left: 260px;">
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学生学号:</h3>
                                <p>
                                    <input type="hidden" name="student_id" value="<%=session.getAttribute("student_id")%>" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
                                    <input class="text2" type="text" name="student_account" value="<%=session.getAttribute("student_account")%>" readonly="readonly"   style="padding: 10px 0 10px 0"/>
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
                                <p><input class="text2" type="text" name="student_tel" value="<%=session.getAttribute("student_tel")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学生名称:</h3>
                                <p><input class="text2" type="text" name="student_name" value="<%=session.getAttribute("student_name")%>" style="padding: 10px 0 10px 0"/></p>
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
                                    <input  class="text2" type="password" name="student_password" value="<%=session.getAttribute("student_password")%>"  style="padding: 10px 0 10px 0"></input>
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
                                    <input  class="text2" type="password" name="student_repassword" value=""  placeholder="请填写再次确认您的密码！"  onblur="check2pwd()"  style="padding: 10px 0 10px 0"></input>
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
                                <%--<input type="radio" name="teacher_sex" value="男" <%=session.getAttribute("teacher_sex").equals("男")?"checked":""%>/>男--%>
                                <%--<input type="radio" name="teacher_sex" value="女" <%=session.getAttribute("teacher_sex").equals("女")?"checked":""%>/>女--%>
                                <div class="selectbox">
                                    <select name="student_sex">
                                        <option value="男" <%=session.getAttribute("student_sex").equals("男")?"selected":""%>>男</option>
                                        <option value="女" <%=session.getAttribute("student_sex").equals("女")?"selected":""%>>女</option>
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
                                <p><input class="text2" type="text" name="major" value="<%=session.getAttribute("major")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>籍贯:</h3>
                                <p><input class="text2" type="text" name="city" value="<%=session.getAttribute("city")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>邮箱:</h3>
                                <p><input class="text2" type="text" name="email" value="<%=session.getAttribute("email")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>学院:</h3>
                                <p><input class="text2" type="text" name="student_college" value="<%=session.getAttribute("student_college")%>" style="padding: 10px 0 10px 0"/></p>
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>班级:</h3>
                                <div class="selectbox">
                                    <select name="class_id">
                                        <c:forEach items="${classinfolist}" var="ct">
                                            <option value="${ct.classId }"  ${ct.classId==sessionScope.StudentInfo.getClassId()?"selected":""}>${ct.className }</option>
                                        </c:forEach>
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
                                <h3>在校指导教师:</h3>
                                <div class="selectbox">
                                    <select name="teacher_id">
                                        <c:forEach items="${list}" var="st">
                                            <option value="${st.teacherId }" ${st.teacherId==sessionScope.StudentInfo.getTeacherId()?"selected":""}>${st.teacherName }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>
               <%-- <tr>
                    <td>
                        <ul>
                            <li id="lasts">
                                <h3>在校指导教师:</h3>
                                <div class="selectbox">
                                    <select name="teacher_id">
                                        <%
                                            TeacherInfo teacherInfo = new TeacherInfo();
                                            TeacherService teacherService = new TeacherServiceImpl();

                                            List<TeacherInfo> allTeacherInfo = teacherService.queryAllTeacherInfo(teacherInfo);
                                            for(int i=0;i<allTeacherInfo.size();i++){
                                                teacherInfo = allTeacherInfo.get(i);
                                        %>

                                        <option value="<%=teacherInfo.getTeacherId()%>" ${teacherInfo.getTeacherId()==sessionScope.StudentInfo.getTeacherId()?"selected":""} style="font-size: 16px;"><%=teacherInfo.getTeacherName()%></option>

                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>--%>
               <%-- <tr>
                    <td>
                        <ul>
                            <li>
                                <h3>班级:</h3>
                                <div class="selectbox">
                                    <select name="class_id">
                                        <%
                                            StudentInfo studentInfo = new StudentInfo();
                                            StudentService studentService = new StudentServiceImpl();

                                            List<StudentInfo> allStudentInfo = studentService.queryAllStudentInfo(studentInfo);
                                            for(int i=0;i<allStudentInfo.size();i++){
                                                studentInfo = allStudentInfo.get(i);
                                        %>
                                        <option value="<%=studentInfo.getClassId()%>" ${studentInfo.getClassId() == sessionScope.StudentInfo.getClassId()?"selected":""} style="font-size: 16px;"><%=studentInfo.getClassName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>--%>
                <tr>
                    <td>
                        <%--<a href="javascript:" class="btn" style="float: left;margin-left: 320px;">保存修改信息</a>--%>
                        <input type="submit" class="btn" style="float: left;margin-left: 320px;" value="保存修改信息">
                        <a href="javascript: window.history.go(-1);" class="btn" style="float: left;margin-left: 10px;">返回上一页</a>

                    </td>
                </tr>

            </table>
        </form>

    </div>
</div>
</body>
</html>