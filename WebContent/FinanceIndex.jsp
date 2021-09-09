<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FinanceIndex</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function Edit(d) {
		$.ajax({
			type : "post",
			url : "EditShopOwnerServlet",
			data : {
				"id" : d.id
			},
			success : function(data) {
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

.pageSidebar {
	width: 240px;
	height: 100%;
	padding-bottom: 30px;
	overflow: auto;
	background-color: #e3e3e3;
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

.pageContent {
	height: 100%;
	min-width: 768px;
	left: 246px;
	top: 0;
	right: 0;
	z-index: 3;
	padding-bottom: 30px;
	position: absolute;
}

.pageContainer {
	bottom: 0;
	left: 0;
	right: 0;
	top: 53px;
	overflow: auto;
	position: absolute;
	width: 100%;
}

li[role|=presentation] {
	border: 1px solid black;
}

a[class|=dropdown-toggle] {
	border: 1px solid black;
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
					<li role="presentation"><a href="#">当前用户：<span
							class="badge">${sa.nickname}</span></a></li>
					<li><a href="staffLogin.jsp"> <span
							class="glyphicon glyphicon-lock"></span>退出登录
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 中间主体内容部分 -->
	<div class="pageContainer">
		<!-- 左侧导航栏 -->
		<div class="pageSidebar"
			style="background-color: #222; border-color: #080808;">
			<ul class="nav nav-stacked nav-pills">
				<li role="presentation"><a href="SaleQueryStatistics.jsp"
					target="mainFrame">销售查询统计</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/CompensatoryServlet"
					target="mainFrame">补偿性申请处理</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/ExpressServlet"
					target="mainFrame">物流申请处理</a></li>
				<li role="presentation"><a href="InvoiceApplication.jsp" target="mainFrame">开具发票申请处理</a>
				</li>
				<li role="presentation"><a href="OutQueryStatistics.jsp"
					target="mainFrame">出账查询统计</a></li>
				<li role="presentation"><a href="FinancialCenter.jsp"
					id="${sa.id}" target="mainFrame" onclick="Edit(this)">系统设置</a></li>
			</ul>
		</div>
		<!-- 左侧导航和正文内容的分隔线 -->
		<div class="splitter"></div>
		<!-- 正文内容部分 -->
		<div class="pageContent">
			<iframe src="SaleQueryStatistics.jsp" id="mainFrame" name="mainFrame"
				width="100%" height="100%"></iframe>
		</div>
	</div>
</body>
</html>