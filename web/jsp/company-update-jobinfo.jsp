<%@ page import="com.zdy.school.vo.JobInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Dynamic Scrolling Shadow</title>
  <link href="../css/jobinfo.css" type="text/css" rel="stylesheet" media="screen,projection" />
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	<style type="text/css">
		<!--下拉框样式-->
		.selectbox{ width: 50px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(${pageContext.request.contextPath}/images/arrow.png) right center no-repeat;  vertical-align: middle;}
		.selectbox select{cursor: pointer; text-align: center ; padding: 0 8px; height: 28px; line-height: 28px; font-size: 18px; width:100%; padding-right: 18%; background:none; border: none;}
		.selectbox select option{ padding:8px;}
		#recruitinformation tr:nth-child(odd){ background: #dcdcdc;}
	</style>
<script type="text/javascript">

</script>
</head>
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
		  <form action="${ pageContext.request.contextPath }/EnterpriseUpdateJobInfoServlet01">
				<div class="theme-popover">
					 <div class="theme-poptit"> </div>
					 <div class="theme-popbod" style="font-size: 18px;color: black;">
						 <% JobInfo jobInfo = (JobInfo) session.getAttribute("jobInfo");%>
						<ol>
						<li style="text-align: center;margin-right: 35px;">
							<strong>信息状态</strong>：
							<div style="padding: 15px 0 20px 0;">
								<div class="selectbox">
									<select name="information_state" id="information_state" style="width: auto;padding: 0 1%;;margin: 0;background-color: palegreen ">
										<option <%=jobInfo.getInformationState().equals("1")?"selected":""%> value="1" style="text-align: center">已结束</option>
										<option <%=jobInfo.getInformationState().equals("0")?"selected":""%> value="0"  style="text-align: center">正在招聘</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<strong>招聘单位：</strong>
                            <input type="hidden" name="enterprise_id" value="${sessionScope.EnterpriseInfo.getEnterpriseId()}">
                            <input type="hidden" name="job_id" value="<%=jobInfo.getJobId()%>">
							<textarea name="enterprise_name" disabled="disabled" class="textarea1" style="background: #dcdcdc"><%=jobInfo.getEnterpriseName()%></textarea>
						</li>
						<li>
							<strong>企业电话：</strong>
							<textarea name="enterprise_tel" disabled="disabled" class="textarea1" style="background: #dcdcdc"><%=jobInfo.getEnterpriseTel()%></textarea>
						</li>
						<li>
							<strong>企业邮箱：</strong>
							<textarea name="email" disabled="disabled" class="textarea1" style="background: #dcdcdc"><%=jobInfo.getEmail()%></textarea>
						</li>
						<li>
							<strong>企业地址：</strong>
							<textarea name="enterprise_address" disabled="disabled" class="textarea1" style="background: #dcdcdc"><%=jobInfo.getEnterpriseAddress()%></textarea>
						</li>
						<li>
							<strong>招聘职位：</strong>
							<textarea name="job_position"  class="textarea1"><%=jobInfo.getJobPosition()%></textarea>
						</li>
						<li>
							<strong>详细信息：</strong>
							<textarea name="job_info"  class="textarea2" style="height:300px;"><%=jobInfo.getJobInfo()%></textarea>
						</li>
						<li>
							<strong>工资待遇：</strong>
							<textarea name="wage" class="textarea1"><%=jobInfo.getWage()%></textarea>
						</li>
						<li>
							<strong>发布时间：</strong>
							<textarea name="job_date" disabled="disabled" class="textarea1"><%=jobInfo.getJobDate()%></textarea>
						</li>
						<li>
							<a href="#" class="btn"><input type="submit" class="btn" value="保存修改" style="width: 100%;height: 100%"></a>
							<%--<input type="submit" class="btn" value="保存修改">--%>
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
		  </form>
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

