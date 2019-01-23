<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Psyduck
  Date: 2019/1/22
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生全部信息</title>
    <style type="text/css">
        a{color: black;}
        a:hover {color: blue;}
        /*超出部分使用省略号代替*/
        table {table-layout: fixed; }
        #recruitinformation tr td{text-overflow:ellipsis;overflow:hidden;white-space:nowrap;}
        /*搜索框*/
        .sousuo{float:right;margin: 20px 80px 10px 0;}
        .search{border-color:blue;width: 200px;height:30px;outline: none;border-radius:10px;padding: 3px 0 3px 3px;}
        .sub{background-color: blue;border: 2px;width: 60px;height: 30px;font-size: 16px;font-family:YouYuan;}
        <!--下拉框样式-->
            .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(images/arrow.png) right center no-repeat;  vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 14px; width:100%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
</head>
<body>
    <div class="checkout-title" style="font-family: 微软雅黑;font-size: 20px;text-align: center;margin-top: 5px;font-weight: bold;">
        <span><hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/>学生信息管理<hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/></span>
    </div>
    <!--搜索框 <div class="search"></div>-->
    <form action="${pageContext.request.contextPath}/StudentInfoConditionQueryServlet05" method="get">
        <div>
            <div class="sousuo">
                <input type="text" name="studentTel" class="search" placeholder="根据电话进行搜索"/>
                <input type="text" name="studentAccount" class="search" placeholder="根据学号进行搜索"/>
                <input type="submit" value="搜索" class="sub"/>
            </div>
        </div>
    </form>
    <div id="recruitinformation">
        <table width="100%" border="2px" cellpadding="0" cellspacing="0">
            <br>
            <tr align="center"  bgcolor="#FFFFFF" border: 0px;>
                <td width="6%"  style="padding:10px;" title="student_id">序列号</td>
                <td width="6%"  style="padding:10px;" title="student_account">学号</td>
                <td width="5%"  style="padding:10px;" title="student_name">姓名</td>
                <td width="5%"  style="padding:10px;" title="student_sex">性别</td>
                <td width="6%"  style="padding:10px;" title="major">专业</td>
                <td width="10%"  style="padding:10px;" title="city">籍贯</td>
                <td width="10%"  style="padding:10px;" title="email">邮箱</td>
                <td width="10%"  style="padding:10px;" title="student_tel">电话</td>
                <td width="8%"  style="padding:10px;" title="student_college">学院</td>
                <td width="6%"  style="padding:10px;">操作</td>
            </tr>
            <c:forEach items="${list}" var="si" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#dcdcdc" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <td  style="padding:7px 0 7px 0;" title="${si.studentId}">${si.studentId}</td>
                <td  style="padding:7px 0 7px 0;" title="${si.studentAccount}">${si.studentAccount}</td>
                <td title="${si.studentName}">${si.studentName}</td>
                <td title="${si.studentSex}">${si.studentSex}</td>
                <td title="${si.major}">${si.major}</td>
                <td title="${si.city}">${si.city}</td>
                <td title="${si.email}">${si.email}</td>
                <td title="${si.studentTel}">${si.studentTel}</td>
                <td title="${si.studentCollege}">${si.studentCollege}</td>
                <td ><a href="${pageContext.request.contextPath}/AdminGetByIdStudentInfoServlet?studentId=${si.studentId}">修改</a></td>
                </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>
    <div id="footer" style="width: 100%;margin-top:1px; position: absolute;bottom:40px; left: 0;">
    <!-- 分页导航 -->
    <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center" style="width:60%">
    <td width="335" align="center"  class="text_cray">&nbsp;&nbsp;当前页数：${pageNo}/${n}</td>
    <td width="284" align="center"  class="text_cray">
    <%--判断上一页下一下--%>
    <c:if test="${pageNo == 1}">
    <a>第一页</a>
    <a>上一页</a>
    </c:if>
    <c:if test="${pageNo > 1}">
    <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=1">第一页</a>
    <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=${pageNo-1 }">上一页</a>
    </c:if>

    <c:if test="${n%pageSize==0}">
    <c:forEach begin="1" end="${n/pageSize}" var="i" step="1">
    <c:if test="${i==pageNo }">
    ${i}
    </c:if>

    <c:if test="${i!=pageNo }">
    <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=${i}">${i}</a>
    </c:if>
    </c:forEach>
    </c:if>

    <c:if test="${n%pageSize!=0}">
        <c:forEach begin="1" end="${n/pageSize+1}" var="i" step="1">
            <c:if test="${i==pageNo }">
            ${i}
            </c:if>

            <c:if test="${i!=pageNo && i < 5}">
            <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=${i}">${i}</a>
            </c:if>

        </c:forEach>
    </c:if>

    <%--判断下一页 最后一页--%>
    <c:if test="${pageNo == n}">
    <a>下一页</a>
    <a>最后一页</a>
    </c:if>
    <c:if test="${pageNo < n }">
    <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=${pageNo+1 }">下一页</a>
    <a href="${pageContext.request.contextPath}/AdminQueryAllStudentInfoServlet?pageNo=${n }">最后一页</a>
    </c:if>
    </td>
    </tr>
    </table>
    </div>
</body>
</html>
