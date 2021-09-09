<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SaleQueryStatistics</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.bootcss.com/moment.js/2.22.1/moment-with-locales.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
	$(function() {
		var picker1 = $('#datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
		//minDate: '2016-7-1'
		});
		var picker2 = $('#datetimepicker2').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn')
		});
		//动态设置最小值
		picker1.on('dp.change', function(e) {
			picker2.data('DateTimePicker').minDate(e.date);
		});
		//动态设置最大值
		picker2.on('dp.change', function(e) {
			picker1.data('DateTimePicker').maxDate(e.date);
		});
	});
	
	
</script>
<body>
	<div class="row">
		<div class="col-sm-10">
			<ol class="breadcrumb">
				<li class="active">菜单</li>
				<li class="active">销售查询统计</li>
			</ol>

			<div class="panel panel-default">
				<div class="panel-heading">搜索</div>
				<div class="panel-body">
					<form action="SaleQueryServlet" method="post" role="form"
						class="form-inline">

						<div class="form-group">
							<label>选择开始时间：</label>
							<!--指定 date标记-->
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' class="form-control" name="begintime"
									value="${begintime}" /> <span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>

							</div>
						</div>

						<div class="form-group">
							<label>选择结束时间：</label>
							<!--指定 date标记-->
							<div class='input-group date' id='datetimepicker2'>
								<input type='text' class="form-control" name="endtime"
									value="${endtime}" /> <span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>

						</div>
						<div class="form-group">
							<label for="name">ISBN：</label> <input type="text"
								class="form-control" name="isbn" placeholder="请输入ISBN码"
								value="${isbn}">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default">查询</button>
						</div>
					</form>
				</div>
			</div>
			<!--
                        列表展示
                    -->
			<div class="table-responsive">
				<table class="table table-striped ">
					<thead>
						<tr>
							<th>编号</th>
							<th>ISBN</th>
							<th>价格(单位：元)</th>
							<th>自动收货时间</th>
							<th>Remarks</th>
							<th>数量</th>
							<th>生成时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${salelist}" var="od">
							<tr>
								<td>${od.oid}</td>
								<td>${od.ISBN}</td>
								<td>${od.price}</td>
								<td>${od.zdTime}</td>
								<td>${od.remarks}</td>
								<td>${od.num}</td>
								<td>${od.createTime}</td>
							</tr>
							<div id="result" align="center"></div>
						</c:forEach>
					</tbody>
				</table>
			</div> 

			<ul class="pagination" style="float: right;">
				<li><a href="#">&laquo;</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>


		</div>
		<div class="col-sm-10">
			<div class="panel panel-default">
				<div class="panel-heading">统计</div>
				<div class="panel-body">
				<form action="SaleStatisticsServlet" method="post" role="form"
						class="form-inline">
					<div class="form-group" >
						<button type="submit" class="btn btn-primary">统计</button>
					</div>
					<div class="table-responsive">
				<table class="table table-striped ">
					<thead>
						<tr>
							<th>总价格(单位：元)</th>
							<th>总数量</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${totalForPrice}</td>
								<td>${totalForNum}</td>
							</tr>
					</tbody>
				</table>
			</div>
				</form>				
				</div>
			</div>			
		</div>
	</div>
</body>
</html>