<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>企业主页</title>
</head>
	<!--
		rows 列的高度
		cols 行的宽度
		style="background-color:#E6E6FA;"
	-->
 	<frameset rows="100%" cols="*" frameborder="yes" border="1" framespacing="1">


		  <frameset cols="12%,88%" frameborder="yes" framespacing="1">

		  <frame src="/college-enterprise-cooperetion/jsp/company-left.jsp" name="left" allowTransparency="true" scrolling="auto" noresize="noresize">

			  <frameset rows="7%,89%,5%" frameborder="yes" framespacing="1">
				  <frame src="/college-enterprise-cooperetion/jsp/company-head.jsp" name="head" allowTransparency="true" scrolling="no" >
				  <frame src="/college-enterprise-cooperetion/jsp/company-right.jsp" name="right" allowTransparency="true" scrolling="auto">
				  <frame src="/college-enterprise-cooperetion/jsp/footer.jsp" name="footer" allowTransparency="true" scrolling="no" >
			  </frameset>

		  </frameset>

	</frameset>
<body>
	
</body>
</html>