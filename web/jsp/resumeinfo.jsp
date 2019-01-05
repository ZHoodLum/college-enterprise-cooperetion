<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery.json.js"></script>
<html>
<head>
	<meta charset="UTF-8">
	<title>审核简历信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/resumeinfo.css">
</head>
<script type="text/javascript">
    function tongguo() {
        if (confirm("确定通过吗？")) {
            alert("给予通过成功！");
        }
    }
    function butongguo() {
        if (confirm("确定不通过吗？")) {
            alert("不给予通过成功！");
        }
    }
</script>
<body>
	<div class="container">

        <div class="checkout-title">
            <span><hr class="hrLine" style="width:300px;"/>查看简历信息<hr class="hrLine" style="width:300px;"/></span>
        </div>
        <div style="margin-top: 20px;margin-left: 80px;">
        	<form id="myform" name="myform" action="***********" methd="post">
		        <table border="0" width="90%">
		            <tr>
		                <td>
		                   <label class="label2">姓名:</label>
		                   <textfield>${listenterpriseStudentInfo.studentName}</textfield>
		                </td>
						<td>
							<label class="label2">性别:</label>
							<textfield>${listenterpriseStudentInfo.studentSex}</textfield>
						</td>
					</tr>
					<tr>
						<td>
							<label class="label2">电话:</label>
							<textfield>${listenterpriseStudentInfo.studentTel}</textfield>
						</td>
						<td>
							<label class="label2">电子邮件:</label>
							<textfield>${listenterpriseStudentInfo.email}</textfield>
						</td>
		            </tr>

		           <tr>
		                <td>
		                	<label class="label2">民族:</label>
							<textfield>${listenterpriseStudentInfo.nationality}</textfield>
		                </td>
					   <td>
						   <label class="label2">生日:</label>
						   <textfield>${listenterpriseStudentInfo.birthday}</textfield>
					   </td>
					<tr>

					<tr>
		                <td>
		                	<label class="label2">籍贯:</label>
		                   <textfield>${listenterpriseStudentInfo.city}</textfield>
		                </td>
						<td>
							<label class="label2">政治面貌:</label>
							<textfield>${listenterpriseStudentInfo.politics}</textfield>
						</td>
		       		 </tr>

					<tr>
		                <td>
		                	<label class="label2">健康状况:</label>
		                   <textfield>${listenterpriseStudentInfo.health}</textfield>
		                </td>
						<td>
							<label class="label2">毕业学校:</label>
							<textfield>${listenterpriseStudentInfo.college}</textfield>
						</td>
		        	</tr>

					<tr>
		                <td>
		                	<label class="label2">学历:</label>
		                   <textfield>${listenterpriseStudentInfo.education}</textfield>
		                </td>
						<td>
							<label class="label2">专业:</label>
							<textfield>${listenterpriseStudentInfo.major}</textfield>
						</td>
		       		 </tr>

					<tr>
		                <td>
		                	<label class="label2">毕业时间:</label>
		                   <textfield>${listenterpriseStudentInfo.graduateTime}</textfield>
		                </td>
						<td>
							<label class="label2"></label>
							<textfield></textfield>
						</td>
		       		 </tr>
					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">主修:</label>
		                   <textarea class="text1" type="text" name="passwd">${listenterpriseStudentInfo.majorCourse}</textarea>
		                </td>
		      		  </tr>

					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">获得证书:</label>
		                   <textarea class="text1" type="text" name="passwd">${listenterpriseStudentInfo.credential}</textarea>
		                </td>
		        	</tr>
					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">自我评价:</label>
		                   <textarea class="text1" type="text" name="passwd">${listenterpriseStudentInfo.selfEvaluation}</textarea>
		                </td>
		        	</tr>
					<tr>
						<td style="text-align: center;border-bottom: none;" colspan="2">
							<a href="javascript:;" class="btn" onclick="tongguo()">审核通过</a>
							<a href="javascript:history.go(-1)" class="btn">返回上一级...</a>
							<a href="javascript:;" class="btn" onclick="butongguo()">审核不通过</a>
						</td>
					</tr>
		        </table>
	        </form>

		</div>
	</div>
</body>
</html>