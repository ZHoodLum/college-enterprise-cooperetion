<%@ page import="com.zdy.school.vo.JobInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  	<title>招聘信息详情</title>
  	<link href="css/jobinfo.css" type="text/css" rel="stylesheet" media="screen,projection" />
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery.json.js"></script>
</head>
<
<script type="text/javascript">
    $(document).ready(function(){
        $("#btn").click(function(){
            var studentId = document.getElementById("student_id").value;
            if (studentId == 0) {
                alert("请先进行登录，才可以提交简历信息！");
                window.location.href = "jsp/login.jsp";
                return false;
            } else {
                alert("响应Ajax");
                var enterpriseId = document.getElementById("enterprise_id").value;
                // alert("企业信息 ID"+enterpriseId);
				$.ajax({
                    type:"POST",
                    url:"${ pageContext.request.contextPath }/StudentIdAndEnterpriseIdQueryServlet?enterpriseId="+enterpriseId,
                    async:false,
                    dataType:"json",
                    data:{
                        studentId:document.getElementById("student_id").value,
						 // enterpriseId:document.getElementById("enterprise_id").value,
                    },
                    success:function(data,textStatus){
                        alert(studentId + enterpriseId);
                        alert(studentId+"可以进行简历申请");
                    },
                    error: function (data,textStatus) {
                        alert(studentId + enterpriseId);
                        alert(studentId+"对不起，该条招聘信息您已提交过简历！");
                        return false;
                    }
                });
            }
        });
    })
</script>
<body>
  <div id="demo-bar" class="bottom right"></div>
  <div class="container">
	  <div class="navs">
		  <div class="nav_left">
			 <a href="main.jsp"> <h1>招聘信息详情</h1></a>
		  </div>
	  </div>
    <div class="grid-container blue">
      <div class="shadow-box">
        	<!---->
        	<div class="theme-popover">
			     <div class="theme-poptit"> </div>
			     <div class="theme-popbod" style="font-size: 18px;color: black;">
					 <% JobInfo jobInfo = (JobInfo) session.getAttribute("jobInfo");%>
			        <ol>
					<li>
						<strong>招聘单位：</strong>
						<input type="hidden" id="enterprise_id" name="enterprise_id" value="<%=jobInfo.getEnterpriseId()%>">
						<input type="hidden" id="student_id" name="student_id" value="${sessionScope.StudentInfo.studentId}" >
						<textarea name="enterprise_name" disabled="disabled" class="textarea1"><%=jobInfo.getEnterpriseName()%></textarea>
					</li>
					<li>
						<strong>企业电话：</strong>
						<textarea name="enterprise_name" disabled="disabled" class="textarea1"><%=jobInfo.getEnterpriseTel()%></textarea>
					</li>
					<li>
						<strong>企业邮箱：</strong>
						<textarea name="enterprise_name" disabled="disabled" class="textarea1"><%=jobInfo.getEmail()%></textarea>
					</li>
					<li>
						<strong>企业地址：</strong>
						<textarea name="enterprise_name" disabled="disabled" class="textarea1"><%=jobInfo.getEnterpriseAddress()%></textarea>
					</li>
					<li>
						<strong>招聘职位：</strong>
						<textarea name="job_position" disabled="disabled" class="textarea1"><%=jobInfo.getJobPosition()%></textarea>
					</li>
					<li>
						<strong>详细信息：</strong>
						<textarea name="job_info" disabled="disabled" class="textarea2" style="height:300px;"><%=jobInfo.getJobInfo()%></textarea>
					</li>
					<li>
						<strong>工资待遇：</strong>
						<textarea name="wage" disabled="disabled" class="textarea1"><%=jobInfo.getWage()%></textarea>
					</li>
					<li>
						<strong>发布时间：</strong>
						<textarea name="job_date" disabled="disabled" class="textarea1"><%=jobInfo.getJobDate()%></textarea>
					</li>
					<li>
						<a href="StudentSubmitResumesServlet" class="btn" id="btn">提交简历</a>
						<%--<a href="" class="btn" id="btn">提交简历</a>--%>
						<a href="#" onClick="history.go(-1);" class="btn">返回上一级</a>
					</li>
					<!--
					<li>
						<a href="student-resume.html"><input class="btn" type="submit" name="submit" value="提交简历" /></a>
					</li>
					-->
				</ol>
			     </div>
			</div>
        <div class="shadows">
          <div class="shadow top"></div>
          <div class="shadow bottom"></div>
        </div>
      </div>
    </div>
  </div>
  <!-- Javascript -->
  <script src="js/jquery.min.js"></script>
  <script src="js/init.js"></script>
  <script> 
    $(function(){
      $("#demo-bar").load("../demo-bar.html"); 
    });
  </script> 
</body>
</html>

