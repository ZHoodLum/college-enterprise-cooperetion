<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import = "com.zdy.school.vo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>404error</title>
    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 代码 开始 -->
<div id="container">
    <img class="png" src="${pageContext.request.contextPath}/images/404.png" />
    <%--<img class="png" src="images/500.PNG" />--%>
    <img class="png msg" src="${pageContext.request.contextPath}/images/404_msg.png" />
    <p>
        <!--点击按钮所要返回的界面-->
        <a href="javascript:history.go(-1);" target="_blank">
            <img class="png" src="${pageContext.request.contextPath}/images/404_to_index.png" />
        </a>
    </p>
    <p>
        <span id="totalSecond">2</span>秒后自动返回
    </p>
</div>
<div id="cloud" class="png"></div>
<!-- 代码 结束 -->
</body>
<script language="javascript" type="text/javascript">
    var second = document.getElementById('totalSecond').textContent;
    if (navigator.appName.indexOf("Explorer") > -1)  //判断是IE浏览器还是Firefox浏览器，采用相应措施取得秒数
    {
        second = document.getElementById('totalSecond').innerText;
    } else
    {
        second = document.getElementById('totalSecond').textContent;
    }
    setInterval("redirect()", 1000);  //每1秒钟调用redirect()方法一次
    function redirect()
    {
        if (second < 0)
        {

            //若不点击按钮，则自动返回的界面
            location.href ="javascript:history.go(-1);";
        } else
        {
            if (navigator.appName.indexOf("Explorer") > -1)
            {
                document.getElementById('totalSecond').innerText = second--;
            } else
            {
                document.getElementById('totalSecond').textContent = second--;
            }
        }
    }
</script>
</html>