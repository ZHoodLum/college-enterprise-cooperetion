<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    function checkName() {
        var sno = $("#sno").val();
        if(sno.trim() != ""){
            var url = "resumeAction.action";
            var param = {"sno" : sno};
            $.post(url,param,function(data){
                if(data == "yes"){
                    $("#span1").html("<font color='red'>当前学生的简历已存在</font>");
                }else{
                    $("#span1").html("<font color='red'>当前学生还没有创建简历</font>");
                }
            });
        }
    }
</script>
<body>
<!-- header -->
<div class="col-sm-3 col-md-2 sidebar">
		 <div class="sidebar_top">
			 <h1>简历投递</h1> 
			 <img src="../images/avt.png" alt=""/>
		 </div>
		<div class="details">
			 <h3>注意事项</h3>
			 <p>在填写简历信息时，要注意信息是否正确</p>  	 
			 <h3>填写规范</h3>
			 <p>不得使用虚假的个人信息，需如实填写</p>
			
			 
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
				</script>
			 </ul>
		 </div>
		 <div class="company contact-grid">
			 <h3 class="clr1">Resume</h3>
			 <form theme="simple" action="addNewResume" method="post">
				 学号：<br/>
				 <textarea rows="1" id="sno" name="resumeVo.sno" onblur="checkName()"></textarea><span id="span1"></span>

				 <br/>姓名：<br/>
				 <textarea rows="1"  name="resumeVo.sname"></textarea><br/>

				 <br/>民族：<br/>
				 <textarea rows="1"  name="resumeVo.nationality"></textarea><br/><br/>

				 <br/>性别：
				 <div class="selectbox">
					 <select name="gender">
							 <option value="男">男</option>
							 <option value="女">女</option>
					 </select>
				 </div><br/><br/>

				 <br/>出生年月：
				 <input name="birthday" type="date"></input><br/><br/>

				 <br/>政治面貌：
				 <div class="selectbox">
					 <select name="politics">
						 <option value="群众">群众</option>
						 <option value="共青团员">共青团员</option>
						 <option value="党员">党员</option>
					 </select>
				 </div><br/><br/>

				 <br/>健康状况：
				 <div class="selectbox">
					 <select name="health">
						 <option value="健康">健康</option>
						 <option value="不健康">不健康</option>
					 </select>
				 </div><br/><br/>

				 <br/>毕业学校：<br/>
				 <textarea rows="1" name="resumeVo.college"></textarea>

				 <br/>籍贯：<br/>
				 <textarea rows="1" name="resumeVo.city" ></textarea><br/>

				 <br/>学历：<br/>
				 <textarea rows="1" name="resumeVo.education"></textarea>

				 <br/>专业：<br/>
				 <textarea rows="1" name="resumeVo.major"></textarea>

				 <br/>毕业时间：<br/>
				 <textarea rows="1" name="resumeVo.graduateTime"></textarea>

				 <br/>电子邮件：<br/>
				 <textarea rows="1" name="resumeVo.email"></textarea>

				 <br/>学习时间：<br/>
				 <textarea rows="1" name="resumeVo.studentContinueTime"></textarea>

				 <br/>主修：<br/>
				 <textarea rows="1" name="resumeVo.majorCourse"></textarea>

				 <p>获得过的证书：</p>
				<textarea  cols="77" rows="6" name="resumeVo.credential"></textarea>

				<br/><p>自我评价：</p>
				 <textarea cols="77" rows="6" name="resumeVo.selfEvaluation"></textarea>

				<div class="send">
					<input type="submit" value="提交"/>
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