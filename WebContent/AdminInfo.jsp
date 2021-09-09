<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminInfo</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name = "viewport" content ="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">

function Edit(d){
	$.ajax({
		type:"post",
		url:"EditAdminServlet",
		data:{"id":d.id},
		success:function(data){
			console.log(data);
			$("#result").html(data);
		}
	});
}


function Delete(d){ 
	confirm("您确认要删除吗？");
	$.ajax({
		type:"post",
		url:"DeleteAdminServlet",
		data:{"id":d.id},
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
                        <li class="active">管理员信息
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            搜索
                        </div>
                        <div class="panel-body">
                            <form action="AdminInfoServlet" method="post" role="form" class="form-inline">
                                <div class="form-group">
                                    <label for="name">名字</label>
                                    <input type="text" class="form-control" name="name" placeholder="请输入名字" value="${name}">
                                </div>
                                <div class="form-group">
                                    <label for="name">职位</label>
                                    <input type="text" class="form-control" name="type" placeholder="请输入职位" value="${type}">
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
                                    <th>名字</th>
                                    <th>性别</th>
                                    <th>邮箱</th>
                                    <th>电话</th>
                                    <th>地址</th>
                                    <th>职位</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="sa" >
        							<tr>
                                    <td>${sa.id}</td>
                                    <td>${sa.name}</td>
                                    <td>${sa.sex}</td>
                                    <td>${sa.email}</td>
                                    <td>${sa.phonenum}</td>
                                    <td>${sa.address}</td>
                                    <td>${sa.type}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="EditAdmin.jsp" id="${sa.id}" class="btn btn-default" onclick="Edit(this)">修改</a>
                                            <a href="${pageContext.request.contextPath}/AdminInfoServlet" id="${sa.id}" class="btn btn-danger" onclick="Delete(this)">删除</a>
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