<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.school.vo.StudentInfo" %>
<%@ page import="com.zdy.school.service.StudentService" %>
<%@ page import="com.zdy.school.vo.ClassInfo" %>
<%@page import="com.zdy.school.service.ClassInfoService"%>
<%@ page import="java.util.List" %>
<%@ page import="com.zdy.school.service.ClassInfoServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>招聘信息查询管理</title>
    <link rel="stylesheet" type="text/css" href="../css/applicationaudit.css">
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery.json.js"></script>
    <style type="text/css">
        /*搜索框*/
        .sousuo{float:right;margin: 20px 80px 10px 0;}
        .search{border-color:blue;width: 200px;height:20px;outline: none;border-radius:10px;padding: 3px 0 3px 3px;}
        .sub{background-color: blue;border: 2px;width: 60px;height: 30px;font-size: 16px;font-family:YouYuan;}
        <!--下拉框样式-->
        .selectbox{ width: 200px; display: inline-block; overflow-x: hidden; height: 28px; line-height: 28px; font-size: 0;  background:#fff url(${pageContext.request.contextPath}/images/arrow.png) right center no-repeat;  vertical-align: middle;}
        .selectbox select{cursor: pointer; padding: 0 8px; height: 28px; line-height: 28px; font-size: 14px; width:100%; padding-right: 18%; background:none; border: none;}
        .selectbox select option{ padding:5px;}
        #recruitinformation tr:nth-child(odd){ background: #dcdcdc;}
    </style>
    <!--修改信息状态样式js-->
    <script src="${ pageContext.request.contextPath }/js/lc_switch_jquery.js"></script>
    <script src="${ pageContext.request.contextPath }/js/lc_switch.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/lc_switch.css">
    <script type="text/javascript">
        // 异步请求正确
        $(document).ready(function() {
            $('input').lc_switch();
            $('p').delegate('.lcs_check', 'lcs-statuschange', function() {
                // $("input[type='checkbox']").click(function(){
                //     this.checked = !this.checked;
                // });
                var  jobId = document.getElementsByName("jobId").value;
                var  jobId = $("input[name='jobId']").val()
                alert("修改此招聘信息的ID:"+jobId);
                $.ajax({
                    type:"POST",
                    url:"${ pageContext.request.contextPath }/EnterpriseUpdateJobInfoServlet02?jobId="+jobId,
                    async:false,
                    dataType:"json",
                    data:{
                        informationState:($(this).is(':checked')) ? '0' : '1'
                    },
                    success:function(data,textStatus){
                        if(textStatus=="success"){
                            alert(informationState+"修改成功");
                        }
                    }
                });
            });
        });
        // var data = ($(this).is(':checked')) ? '0' : '1';
        // alert("向后AJAX后的数据显示："+data);
        <%--var url = "${ pageContext.request.contextPath }/EnterpriseUpdateJobInfoServlet02?jobId="+jobId;--%>
        // $.get(url,data,function(callbackData){
        // alert("向后AJAX后的数据显示："+data+url);
        // if(callbackData.length == 0){
        // alert("修改成功！！！！！");
        // return;
        // }
        // });
        //先加载界面 保证select响应
        // function show_sub(v){
        //     alert(v);
        // }

        <%--$(function(){--%>
            <%--//根据ID响应select下拉框--%>
            <%--$("#selectValue").onclick(function(){--%>
                <%--//可以获取到响应的选中项--%>
                <%--var Obj = document.getElementById("selectValue");--%>
                <%--// var informationState = Obj.options[Obj.selectedIndex].value;--%>
                <%--// alert("可以获取到响应的选中项："+informationState);--%>
                <%--// 或者此招聘信息的ID--%>
                <%--var  jobId = document.getElementById("jobId").value;--%>
                <%--alert("或者此招聘信息的ID:"+jobId);--%>

                <%--$("#selectValue").click(function(){--%>
                    <%--$.ajax({--%>
                            <%--type:"POST",--%>
                            <%--url:"${ pageContext.request.contextPath }/EnterpriseUpdateJobInfoServlet02?jobId="+jobId,--%>
                            <%--async:false,--%>
                            <%--dataType:"json",--%>
                            <%--data:{--%>
                            <%--informationState:Obj.options[Obj.selectedIndex].value--%>
                        <%--},--%>
                        <%--success:function(data,textStatus){--%>
                            <%--if(textStatus=="success"){--%>
                                <%--alert(informationState+"修改成功");--%>
                            <%--}--%>
                        <%--}--%>
                    <%--});--%>
                <%--});--%>
            <%--});--%>
        <%--});--%>
    </script>
</head>
<body>
<div class="checkout-title" style="font-family: 微软雅黑;font-size: 20px;text-align: center;margin-top: 5px;font-weight: bold;">
    <span><hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/>招聘信息查询管理<hr class="hrLine" style="width:260px;vertical-align:middle; display:inline-block;"/></span>
</div>
<!--搜索框 <div class="search"></div>-->

    <div>
        <form action="${pageContext.request.contextPath}/JobInfoConditionQueryServlet?enterprise_id=${sessionScope.EnterpriseInfo.getEnterpriseId()}" method="post">
            <div class="selectbox" style="margin: 20px 0 10px 80px;width: 200px;float: left;border: 2px solid blue;">
                <select name="e_check" id="data1" class="data">
                    <option value="">审核状态</option>
                    <option value="1" style="font-size: 16px;" >未审核</option>
                    <option value="0" style="font-size: 16px;">审核通过</option>
                </select>
            </div>
            <div class="selectbox" style="margin: 20px 0 10px 80px;width: 200px;float: left;border: 2px solid blue;">
                <select name="information_state" id="data2" class="data">
                    <option value="">信息状态</option>
                    <option value="0"  style="font-size: 16px;">正在招聘</option>
                    <option value="1" style="font-size: 16px;">已结束</option>
                </select>
            </div>
            <div class="sousuo">
                <input type="submit" value="搜索" class="sub"/>
            </div>

        </form>
    </div>

<div id="recruitinformation">
    <table width="100%" border="0px" cellpadding="0" cellspacing="0">
            <tr align="center"  bgcolor="#FFFFFF" border: 0px;>
                <td width="8%"  style="padding:10px; border-bottom: 2px dashed #808080;">招聘单信息流水号</td>
                <td width="8%"  style="padding:10px; border-bottom: 2px dashed #808080;">招聘单位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">招聘职位</td>
                <td width="20%"  style="padding:10px; border-bottom: 2px dashed #808080;">详细信息</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">工资待遇</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">发布时间</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">审核状态</td>
                <td width="10%"  style="padding:10px; border-bottom: 2px dashed #808080;">信息状态</td>
                <td width="6%"  style="padding:10px; border-bottom: 2px dashed #808080;">详细信息</td>
            </tr>
            <c:forEach items="${jobInfoList}" var="ei" varStatus="i">
                <c:if test="${i.index%2 == 0 }">
                    <tr align="center" bgcolor="#FFFFFF" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <c:if test="${i.index%2 == 1 }">
                    <tr align="center" bgcolor="#F5F5F5" style="border:0px;padding: 3px 0 3px 0">
                </c:if>
                <input id="jobId" name ="jobId" type="hidden" value="${ei.jobId}">
                <input id="enterprise_id" name ="enterprise_id" type="hidden" value="${sessionScope.EnterpriseInfo.getEnterpriseId()}">
                    <td  style="padding:7px 0 7px 0;">${ei.jobId}</td>
                    <td  style="padding:7px 0 7px 0;">${ei.enterpriseName}</td>
                    <td>${ei.jobPosition}</td>
                    <td>${ei.jobInfo}</td>
                    <td>${ei.wage}</td>
                    <td>${ei.jobDate}</td>
                    <%-- 审核状态 ${ei.eCheck}--%>
                    <c:if test="${ei.eCheck == 1}">
                        <td>未审核</td>
                    </c:if>
                    <c:if test="${ei.eCheck == 0}">
                        <td>审核通过</td>
                    </c:if>
                <td>
                    <%--下拉框--%>
                    <%--<div class="selectbox">--%>
                        <%--<select id="selectValue" >--%>
                            <%--<option value="1" ${ei.informationState == 1?"selected":""}>已结束</option>--%>
                            <%--<option value="0" ${ei.informationState == 0?"selected":""}>正在招聘</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <p>
                        <%--<input id="jobId" name ="jobId" type="hidden" value="${ei.jobId}">--%>
                        <%--<input type="checkbox" id="informationState" name="informationState" class="lcs_check lcs_tt1" value="${ei.informationState}"  onclick="return false" autocomplete="off" ${ei.informationState == 0?"checked":""}/>--%>
                        <input type="checkbox" id="informationState" disabled="disabled"   name="informationState" class="lcs_check lcs_tt1" value="${ei.informationState}"  onclick="return false" autocomplete="off" ${ei.informationState == 0?"checked":""}/>
                    </p>
                </td>
                </td>
                    <td>
                        <div class="theme-buy">
                            <a class="btn btn-large theme-login" href="EnterpriseJobInfoQueryByIdServlet?jobid=${ei.jobId}">查看详情</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        <tbody>
    </table>
</div>
</body>
</html>