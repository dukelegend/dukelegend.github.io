<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerInfo</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name = "viewport" content ="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">

function Edit(d){
	$.ajax({
		type:"post",
		url:"EditCustomerServlet",
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
		url:"DeleteCustomerServlet",
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
                        <li class="active">客户信息
                        </li>
                    </ol>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            搜索
                        </div>
                        <div class="panel-body">
                            <form action="CustomerInfoServlet" method="post" role="form" class="form-inline">
                                <div class="form-group">
                                    <label for="name">编号</label>
                                    <input type="text" class="form-control" name="id" placeholder="请输入编号" value="${id}">
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
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="cus" >
        							<tr>
                                    <td>${cus.id}</td>
                                    <td>${cus.name}</td>
                                    <td>${cus.sex}</td>
                                    <td>${cus.email}</td>
                                    <td>${cus.phonenum}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="EditCustomer.jsp" id="${cus.id}" class="btn btn-default" onclick="Edit(this)">修改</a>
                                            <a href="${pageContext.request.contextPath}/CustomerInfoServlet" id="${cus.id}" class="btn btn-danger" onclick="Delete(this)">删除</a>
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