<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopOwnerIndex</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name = "viewport" content ="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

function Edit(d){
	$.ajax({
		type:"post",
		url:"EditShopOwnerServlet",
		data:{"id":d.id},
		success:function(data){
			console.log(data);
			$("#result").html(data);
		}
	});
}
</script>

<style type="text/css">
	body {
    width: 100%;
    height: 100%;
    margin: 0;
    overflow: hidden;
    background-color: #FFFFFF;
    font-family: "Microsoft YaHei", sans-serif;
 }
 .pageSidebar{
    width: 240px;
    height:100%;
    padding-bottom: 30px;
    overflow: auto;
    background-color: #222;    border-color: #080808;
 }
 .splitter {
     width: 5px;
     height: 100%;
     bottom: 0;
     left: 240px;
     position: absolute;
     overflow: hidden;
     background-color: #fff;
 }
 .pageContent{
     height: 100%;
     min-width: 768px;
     left: 246px;
     top: 0;
     right: 0;
     z-index: 3;
     padding-bottom: 30px;
     position: absolute;
 }
 .pageContainer{
     bottom: 0;
     left:0;
     right: 0;
     top: 53px;
     overflow: auto;
     position: absolute;
     width: 100%;
 }
  li[role|=presentation]{
 	border:1px solid black;
 	
 }
  a[class|=dropdown-toggle]{
 	border:1px solid black;
 	
 }
</style>
</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="#">三人行</a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
               <li role="presentation">
                   <a href="#">当前用户：<span class="badge">${sa.nickname}</span></a>
               </li>
               <li>
                   <a href="staffLogin.jsp">
                         <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
       </div>
    </div>      
</nav>
<!-- 中间主体内容部分 -->
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar">
         <ul class="nav nav-stacked nav-pills">
          <li>
                    <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                         管理员信息管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="${pageContext.request.contextPath}/AdminInfoServlet" target="mainFrame" ><i class="glyphicon glyphicon-th-list"></i>管理员信息</a></li>
                        <li><a href="AddAdmin.jsp" target="mainFrame" ><i class="glyphicon glyphicon-th-list"></i>增加管理员</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#tuihuo" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                         客户信息管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="tuihuo" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="${pageContext.request.contextPath}/CustomerInfoServlet" target="mainFrame"><i class="glyphicon glyphicon-th-list"></i>客户信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/CvipInfoServlet" target="mainFrame" ><i class="glyphicon glyphicon-th-list"></i>会员客户信息</a></li>
                        <li><a href="AddCustomer.jsp" target="mainFrame" ><i class="glyphicon glyphicon-th-list"></i>添加</a></li>
                    </ul>
                </li>
             <li role="presentation">
                 <a href="ShopOwnerCenter.jsp" id="${sa.id}" class="btn btn-default" onclick="Edit(this)" target="mainFrame" style="border:1px solid #080808; background: rgba(0,0,0,0); color:#337ab7;   text-align: -webkit-match-parent;"> <i class="glyphicon glyphicon-cog"></i>个人中心</a>
             </li>
         </ul>
     </div>
     <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
         <iframe src = "${pageContext.request.contextPath}/AdminInfoServlet" id="mainFrame" name="mainFrame"  width="100%"  height="100%"></iframe>
     </div>
 </div>
</body>
</html>