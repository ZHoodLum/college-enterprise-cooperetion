<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>addinformation</title>
	<link rel="stylesheet" type="text/css" href="../css/addinformation.css">

</head>
<body>
	<div class="container">

        <div class="checkout-title">
            <span><hr class="hrLine" style="width:300px;"/>请填写招聘信息<hr class="hrLine" style="width:300px;"/></span>
        </div>
        <div>
        	<form id="myform" name="myform" action="../JobInfoAddServlet" method="post">
		        <table border="0" width="100%"  style="text-align: center;">
					<tr>
						<td>
							<ul>
								<li class="firtst">
									<h3>招聘企业：</h3>
									<p>
										<h3></h3>
										<input type="text" name="enterprise_name" value="<%=session.getAttribute("enterprise_name")%>" style="border:0px; ">
										<%--<textarea  class="text1" type="text" name="enterprise_name" placeholder="请填写招聘单位，可精确到街道单元！例如：辽宁省抚顺市望花区滨河路东段2号宏达公司！">--%>
											<%----%>
										<%--</textarea>--%>
									</p>
								</li>
							</ul>
						</td>
					</tr>
		            <tr>
		                <td>
		                    <ul>
		                        <li class="firtst">
		                             <h3>招聘详情：</h3>
		                            <p>
		                            	<textarea  class="text1" type="text" name="job_info" placeholder="请填写招聘单位！">
		                            		
		                            	</textarea>
		                            </p>
		                        </li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <ul>
		                        <li id="twos">
		                             <h3>招聘职位：</h3>
		                            <p>
		                            	<textarea class="text1" type="text" name="job_position" placeholder="请填写招聘职位，例如程序员，高级架构师等，也可更加详细！">
		                            		
		                            	</textarea>
		                            </p>
		                        </li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <ul>
		                        <li id="threes">
		                        	<h3>工资待遇：</h3>
		                            <p>
		                            	<input  class="text2" type="text" name="wage" placeholder="请填写工资待遇！例如：10k,100k" value="" />
		                            </p>
		                        </li>
		                    </ul>
		                </td>
					<tr>
						<!--***********************************************提交 重置发布信息按钮***********************************************************************-->
						<!-- <td style="float: left;margin: 20px 0 0 270px;"> -->
						<td style="text-align: center;">
							<input type="submit" name="button" class="btn" value="提交发布信息">
							<input type="reset" name="button" class="btn" value="重置发布信息" style="margin-left: 50px;">
						</td>


					</tr>

		        </table>
	        </form>

		</div>
	</div>
</body>
</html>