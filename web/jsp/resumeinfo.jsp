<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>审核简历信息</title>
	<link rel="stylesheet" type="text/css" href="../css/resumeinfo.css">

</head>
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
		                   <label class="label2">学号:</label>
		                   <textfield>
		                     153011031
		                   </textfield>
		                </td>
						<td>
							<label class="label2">姓名:</label>
							<textfield>
								张三
							</textfield>
						</td>
		            </tr>

		           <tr>
		                <td>
		                	<label class="label2">民族:</label>
							<textfield>
							汉
							</textfield>
		                </td>
					   <td>
						   <label class="label2">生日:</label>
						   <textfield>
							   1996-9-9
						   </textfield>
					   </td>
					<tr>

					<tr>
		                <td>
		                	<label class="label2">籍贯:</label>
		                   <textfield>
							内蒙古通辽市
		                   </textfield>
		                </td>
						<td>
							<label class="label2">政治面貌:</label>
							<textfield>
								共青团员
							</textfield>
						</td>
		       		 </tr>

					<tr>
		                <td>
		                	<label class="label2">健康状况:</label>
		                   <textfield>
							健康
		                   </textfield>
		                </td>
						<td>
							<label class="label2">毕业学校:</label>
							<textfield>
								沈阳工学院
							</textfield>
						</td>
		        	</tr>

					<tr>
		                <td>
		                	<label class="label2">学历:</label>
		                   <textfield>
								本科
		                   </textfield>
		                </td>
						<td>
							<label class="label2">专业:</label>
							<textfield>
								内蒙古通辽市
							</textfield>
						</td>
		       		 </tr>

					<tr>
		                <td>
		                	<label class="label2">毕业时间:</label>
		                   <textfield>
							1996-9-9
		                   </textfield>
		                </td>
						<td>
							<label class="label2">电子邮件:</label>
							<textfield>
								1546464@qq.com
							</textfield>
						</td>
		       		 </tr>
					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">主修:</label>
		                   <textarea class="text1" type="text" name="passwd">
							java\html
		                   </textarea>
		                </td>
		      		  </tr>

					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">获得证书:</label>
		                   <textarea class="text1" type="text" name="passwd">
							大学英语四级
		                   </textarea>
		                </td>
		        	</tr>
					<tr>
		                <td colspan="2" style="border-bottom: none;">
		                	<label class="label2">自我评价:</label>
		                   <textarea class="text1" type="text" name="passwd">
							内蒙古通辽市
		                   </textarea>
		                </td>
		        	</tr>
					<tr>
						<td style="text-align: center;border-bottom: none;" colspan="2">
							<a href="javascript:" class="btn" >审核中</a>
							<a href="javascript:" class="btn">通过</a>
							<a href="javascript:" class="btn">不通过</a>
						</td>
					</tr>
		        </table>
	        </form>

		</div>
	</div>
</body>
</html>