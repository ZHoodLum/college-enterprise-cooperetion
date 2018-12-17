<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>mangerpeople</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
    <!--
    下拉框样式
    -->
    <style type="text/css">
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(../images/arrow.png) right center no-repeat; border: 1px solid #dcdbdb; vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 15px; width:118%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
    </style>
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function del(id){
            var b = confirm("是否删除？"+id);
            if(b){
                location.href="${pageContext.request.contextPath}/DeleteJobInfoServlet?jobId="+id;
            }
        }
    </script>
</head>
<body>
    <div class="checkout-title">
        <span><hr class="hrLine" style="width:500px;"/>请审核企业发布招聘信息<hr class="hrLine" style="width:500px;"/></span>
    </div>
    <div id="recruitinformation">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr align="center">
                <td width="8%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">招聘单位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">招聘职位</td>
                <td width="15%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">招聘信息</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">工资待遇</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">发布时间</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">是否发布</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #6bb642;">编辑</td>

            </tr>
            <!-- 分页查询 -->
            <c:forEach items="${allJobInfoList}" var="ajf" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <form action="${pageContext.request.contextPath}/AdminUpdateJobInfoServlet" method="post">

                     <input type="hidden" name="jobId" value="${ajf.jobId}">
                    <td  style="padding:7px 0 7px 0;">${ajf.enterpriseName}</td>
                    <td>${ajf.jobPosition}</td>
                    <td>${ajf.jobInfo}</td>
                    <td>${ajf.wage}</td>
                    <td>${ajf.jobDate}</td>
                    <td>
                        <div class="selectbox">
                            <select name="eCheck" id="eCheck">
                                <option value="1" ${ei.eCheck == 1?"selected":""}>未审核</option>
                                <option value="0" ${ei.eCheck == 0?"selected":""}>审核通过</option>
                            </select>
                        </div>
                        <input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="发布" tabindex="3"/>
                        </form>
                    </td>
                     <td><a href="javascript:del(${ajf.jobId})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="footer" style="width: 100%;margin-top:1px; position: absolute;bottom:40px; left: 0;">
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr align="center" style="width:60%">
                <td width="335" align="center"  class="text_cray">&nbsp;</td>
                <td width="284" align="center"  class="text_cray">
                    <%--判断上一页下一下--%>
                    <c:if test="${pageNo == 1}">
                        <a>第一页</a>
                        <a>上一页</a>
                    </c:if>
                    <c:if test="${pageNo > 1}">
                        <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=1">第一页</a>
                        <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=${pageNo-1 }">上一页</a>
                    </c:if>
                    <%--循环页数--%>
                    <c:if test="${n%pageSize==0}">
                        <c:forEach begin="1" end="${n/pageSize}" var="vi" step="1">
                            <c:if test="${vi==pageNo }">
                                ${vi}
                            </c:if>

                            <c:if test="${vi!=pageNo }">
                                <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=${vi}">${vi}</a>
                            </c:if>
                        </c:forEach>
                    </c:if>

                    <c:if test="${n%pageSize!=0}">
                        <c:forEach begin="1" end="${n/pageSize+1}" var="vi" step="1">
                            <c:if test="${vi==pageNo }">
                                ${vi}
                            </c:if>

                            <c:if test="${vi!=pageNo }">
                                <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=${vi}">${vi}</a>
                            </c:if>

                        </c:forEach>
                    </c:if>
                    <%--判断下一页 最后一页--%>
                    <c:if test="${pageNo == n}">
                        <a>下一页</a>
                        <a>最后一页</a>
                    </c:if>
                    <c:if test="${pageNo < n }">
                        <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=${pageNo+1 }">下一页</a>
                        <a href="${pageContext.request.contextPath}/JobInfoQueryAllManageServlet?pageNo=${n }">最后一页</a>
                    </c:if>
                </td>

                </td>
            </tr>
        </table>
    </div>
</body>
</html>