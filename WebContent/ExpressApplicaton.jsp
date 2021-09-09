<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ExpressApplication</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name = "viewport" content ="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

function Agree(d){
	confirm("您确认要同意吗？");
	$.ajax({
		type:"post",
		url:"UpdateExpressServlet",
		data:{"id":d.id,"state":"true"},
		success:function(data){
			console.log(data);
			$("#result").html(data);
		}
	});
}


function Reject(d){ 
	confirm("您确认要拒绝吗？");
	$.ajax({
		type:"post",
		url:"UpdateExpressServlet",
		data:{"id":d.id,"state":"false"},
		success:function(data){
			console.log(data);
			$("#result").html(data);
		}
	});
}
</script>
</head>
<body>
<div class="col-sm-10">
                    <ol class="breadcrumb">
                        <li class="active">菜单
                        </li>
                        <li class="active">物流申请处理
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            搜索
                        </div>
                        <div class="panel-body">
                            <form action="ExpressServlet" method="post" role="form" class="form-inline">
                                <div class="form-group">
                                    <label for="name">物流名称：</label>
                                    <input type="text" class="form-control" name="expname" placeholder="请输入物流名称" value="${expname}">
                                </div>
                                
                                <div class="form-group">
                                    <button type="submit" class="btn btn-default">开始搜索</button>
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
                                    <th>物流名称</th>
                                    <th>价格</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${expresslist}" var="exp" >
        							<tr>
                                    <td>${exp.id}</td>
                                    <td>${exp.name}</td>
                                    <td>${exp.price}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="" id="${exp.id}" class="btn btn-primary" onclick="Agree(this)">同意</a>
                                            <a href="" id="${exp.id}" class="btn btn-danger" onclick="Reject(this)">拒绝</a>
                                        </div>
                                    </td>
                                	</tr>
                                	<div id="result" align="center"></div>
    							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="#">&laquo;</a>
                        </li>
                        <li class="active"><a href="#">1</a>
                        </li>
                        <li><a href="#">&raquo;</a>
                        </li>
                    </ul>
                </div>
</body>
</html>