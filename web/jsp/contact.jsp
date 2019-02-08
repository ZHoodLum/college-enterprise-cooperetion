<%@ page import="com.zdy.school.vo.Resumes" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="currentdate" />
<!DOCTYPE html>
<html>
<head>
	<title>我的简历</title>
	<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
	<script src="../js/jquery.min.js"></script>
	 <link href="../css/dashboard.css" rel="stylesheet">
	<link href="../css/style.css" rel='stylesheet' type='text/css' />
	<link href="../js/jquery-1.9.1.min.js"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Curriculum Vitae Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href='' rel='stylesheet' type='text/css'>
	<%--<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>--%>
	<%--<link href='http://fonts.useso.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>--%>
	<link href='' rel='stylesheet' type='text/css'>
	<%--<link href='http://fonts.useso.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>--%>
	<!--
    下拉框样式
    -->
	<style type="text/css">
		.selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
		.selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 12px; width:118%; padding-right: 18%; background:none; border: none;}
		.selectbox select option{ padding:5px;}
	</style>
<!-- start menu -->
</head>
<script>
    // function checkName() {
    //     var sno = $("#sno").val();
    //     if(sno.trim() != ""){
    //         var url = "resumeAction.action";
    //         var param = {"sno" : sno};
    //         $.post(url,param,function(data){
    //             if(data == "yes"){
    //                 $("#span1").html("<font color='red'>当前学生的简历已存在</font>");
    //             }else{
    //                 $("#span1").html("<font color='red'>当前学生还没有创建简历</font>");
    //             }
    //         });
    //     }
    // }
    <%--$(document).ready(function(){--%>
        <%--// alert("ssssss");--%>
		<%--$.ajax({--%>
			<%--type:"POST",--%>
			<%--url:"${ pageContext.request.contextPath }/ResumesQueryAllServlet",--%>
			<%--async:false,--%>
			<%--dataType:"json",--%>
			<%--data:{--%>
				<%--student_id:$("input[name='student_id']").val()--%>
			<%--},--%>
			<%--success:function(data,textStatus){--%>
				<%--if(textStatus=="success"){--%>
                    <%--$("[value='提交']").prop("disabled",true);--%>
				<%--}--%>
			<%--}--%>
		<%--});--%>
    <%--});--%>
</script>

<body>
<!-- header -->
<div class="col-sm-3 col-md-2 sidebar">
		 <div class="sidebar_top">
			 <h1><a href="javascript:history.back()">简历投递</a> </h1>
			 <img src="../images/avt.png" alt=""/>
		 </div>
		<div class="details">
			 <h3>注意事项</h3>
			 <p>在填写简历信息时，要注意信息是否正确</p>  	 
			 <p>不得使用虚假的个人信息，需如实填写</p>
            <p><span id="span1"></span></p>
			<h3>用户须知</h3>
			<p style="color: red">此简历模板仅限修改一次，若再次修改请联系管理员</p>
			<p><h3>管理员邮箱</h3>1553230605@qq.com</p>
			<h3>通知.....</h3>

		</div>
		<div class="clearfix"></div>
</div>
<!---->
<link href="../css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!---//pop-up-box---->			
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	 <div class="content">
		 <div class="details_header">
			 <ul>
				 <li><span class="glyphicon glyphicon-file" aria-hidden="true"></span>简历</li>
				 
				 <div id="small-dialog" class="mfp-hide">
					 <img src="../images/g4.jpg" alt=""/>
				 </div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
                        function fanhui() {
                            location.href="${pageContext.request.contextPath}/JobInfoQueryAllServlet";
                        }
                        $(document).ready(function () {
                            var time = new Date();
                            var day = ("0" + time.getDate()).slice(-2);
                            var month = ("0" + (time.getMonth() + 1)).slice(-2);
                            var today = time.getFullYear() + "-" + (month) + "-" + (day);
                            $('#birthday').val(today);
                            $('#graduate_time').val(today);
                        })
				</script>
			 </ul>
		 </div>
		 <div class="company contact-grid">
			 <h3 class="clr1">Resume</h3>
			 <form theme="simple" id="myform" name="myform"  action="${pageContext.request.contextPath}/StudentAddResumesServlet" method="post">
				 学号：<br/>
				 <input type="hidden" id="student_id" name="student_id" value="<%=session.getAttribute("student_id")%>" readonly style="background-color: #9d9d9d;padding: 10px 0 10px 0"/>
				 <textarea rows="1" id="student_account" name="student_account" readonly style="overflow: hidden;"><%=session.getAttribute("student_account")%></textarea>


				 <br/>姓名：<br/>
				 <textarea rows="1"  id="student_name" name="student_name" readonly><%=session.getAttribute("student_name")%></textarea><br/>

				 <br/>民族：<br/>
				 <textarea rows="1"  id="nationality" name="nationality" >${sessionScope.resumes.nationality}</textarea><br/><br/>

				 <br/>性别：
				 <div class="selectbox">
					 <select id="student_sex" name="student_sex" disabled="disabled">
						 <option value="男" <%=session.getAttribute("student_sex").equals("男")?"selected":""%>>男</option>
						 <option value="女" <%=session.getAttribute("student_sex").equals("女")?"selected":""%>>女</option>
					 </select>
				 </div><br/><br/>

				 <br/>出生年月：
				 <input  name="birthday" type="date" id="birthday"  value="${sessionScope.resumes.birthday}"><br/><br/>

				 <br/>政治面貌：
				 <div class="selectbox">
					 <select id="politics" name="politics">
						 <%--<option <%=session.getAttribute("politics").equals("群众")?"selected":""%> value="群众">群众</option>--%>
						 <%--<option <%=session.getAttribute("politics").equals("共青团员")?"selected":""%> value="共青团员">共青团员</option>--%>
						 <%--<option <%=session.getAttribute("politics").equals("党员")?"selected":""%> value="党员">党员</option>--%>
						 <option ${sessionScope.resumes.politics.equals("群众")?"selected":""} value="群众">群众</option>
						 <option ${sessionScope.resumes.politics.equals("共青团员")?"selected":""} value="共青团员">共青团员</option>
						 <option ${sessionScope.resumes.politics.equals("党员")?"selected":""} value="党员">党员</option>
					 </select>
				 </div><br/><br/>

				 <br/>健康状况：
				 <div class="selectbox">
					 <select id="health" name="health">
						 <option ${sessionScope.resumes.health.equals("健康")?"selected":""} value="健康"  >健康</option>
						 <option ${sessionScope.resumes.health.equals("不健康")?"selected":""} value="不健康"  >不健康</option>
					 </select>
				 </div><br/><br/>

				 <br/>毕业学校：<br/>
				 <textarea rows="1" id="college" name="college">${sessionScope.resumes.college}</textarea>

				 <br/>籍贯：<br/>
				 <textarea rows="1" id="city" name="city" readonly><%=session.getAttribute("city")%></textarea><br/>

				 <br/>学历：<br/>
				 <textarea rows="1" id="education" name="education">${sessionScope.resumes.education}</textarea>

				 <br/>专业：<br/>
				 <textarea rows="1" id="major" name="major" readonly><%=session.getAttribute("major")%></textarea><br/>

				 <br/>毕业时间:
				 <input rows="1" id="graduate_time" name="graduate_time"  type="date" value="${sessionScope.resumes.graduateTime}" ><br/><br/>

				 <br/>电子邮件：<br/>
				 <textarea rows="1" id="email" name="email" readonly><%=session.getAttribute("email")%></textarea>

				 <br/>学习时间（结束时间 例如：2019/2/4-2019/6/24）：<br/>
				 <textarea rows="1" id="student_continue_time" name="student_continue_time">${sessionScope.resumes.studentContineTime}</textarea>

				 <br/>主修：<br/>
				 <textarea rows="1" id="major_course" name="major_course">${sessionScope.resumes.majorCourse}</textarea>

				 <p>获得过的证书：</p>
				<textarea  cols="77" rows="6" id="credential" name="credential">${sessionScope.resumes.credential}</textarea>

				<br/><p>自我评价：</p>
				 <textarea cols="77" rows="6" id="self_evaluation" name="self_evaluation">${sessionScope.resumes.selfEvaluation}</textarea>
				<div class="send" id="send">
					<c:choose>
						<c:when test="${sessionScope.resumes.resumeId == 0}"><!-- 如果 -->
						<%--<c:when test="<%=session.getAttribute("resume_id").equals("党员")%>"><!-- 如果 -->--%>
							<input type="submit" value="提交"/>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>

                    <a href="${pageContext.request.contextPath}/JobInfoQueryAllServlet" style="margin:0 auto;font-size: 18px;text-decoration:underline">
						返回上一级...
					</a>
				</div>
			 </form>
		 </div>
		 <div class="copywrite">
			 <p>© 2018 Curriculum Vitae All Rights Reseverd | Design by </p>
		 </div>
	 </div>
</div>
<!---->
</body>
</html>