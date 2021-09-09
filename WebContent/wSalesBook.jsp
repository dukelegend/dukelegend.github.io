<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="resources/layui/css/layui.css">

</head>
<script src="js/jquery-1.8.3.js"></script>
<script src="resources/layui/layui.js"></script>
<script>
function dow(){
	alert("确认下架？")
}

function update(e,price,num){
	
	var input = document.getElementById("isbn");
	document.getElementById("price").value=price;
	document.getElementById("num").value=num;
	
	input.value=e;
	
	layui.use(['form'],function(){
		var form = layui.form;
		layer.open({
            type: 1,
            title: '上架图书',
            area: ['350px', '300px'],
            offset: '20px',
            content: $("#up"),
            shadeClose:1,
        });
		
});

}

</script>
<body>
<div style="display: none" id="up">
<form class="layui-form layui-form-pane" action="WDownBookServlet" id="upform" >
                <input style="display: none" id="isbn" name="isbn">
                
                
                
               
                
                
                <div class="layui-form-item">
                    <label class="layui-form-label">售价</label>
                    <div class="layui-input-inline">
                        <input type="text" id="price" name="price" required  autocomplete="off" class="layui-input" id="pass1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">修改数量</label>
                    <div class="layui-input-inline">
                        <input type="text" id="num" name="num" required  autocomplete="off" class="layui-input" id="pass1">
                    </div>
                </div>
              <!-- <button type="submit" class="layui-btn" id="submit"> -->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" id="submit">提交</button>
                        
                    </div>
                </div>
            </form>
</div>

<div class="col-sm-12">
	<div class="panel panel-default">
    	<div class="panel-heading">搜索图书</div>
        <div class="panel-body">
           <form action="WSalesBookServlet" method="get" class="form-inline">
           	<div class="form-group">
                   <label for="name">请输入</label>
                   <input type="text" class="form-control" name="query" placeholder="ISBN号/书名">
               </div>
               
               <div class="form-group">
                	<button type="submit" class="btn btn-default">搜索</button>
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
                                   <th></th>
                                    <th>书名</th>
                                    <th>ISBN号</th>
                                    <th>售价</th>
                                    <th>数量</th>
                                    <th>上架类型</th>
                                    
                             
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${book}" var="bo" >
                                
                                <c:if test="${bo.sbook.rnum<=40 }">
        							<tr>
        							<td><img class="form-group" src="${bo.book.image }" style="width :40px;height:50px;"></td>
                                    <td><br/>${bo.book.name}</td>
                					<td><br/>${bo.book.ISBN}</td>
                					<td><br/>${bo.sbook.price}</td>
                					<td style="color:red"><br/>${bo.sbook.rnum}</td>
                					<td><br/>${bo.type.name}</td>
                					
                                    <td><br/>
                                        <div class="btn-group">
                                       		<a onclick="update(${bo.book.ISBN },${bo.sbook.price },${bo.sbook.rnum})" class="btn btn-default">编辑</a>
                                       		<a href="WDownBookServlet?down=${bo.book.ISBN }" onclick="dow()" class="btn btn-danger">下架</a>
                                        </div>
                                    </td>
                                    
                                	</tr>
                                </c:if>
    							</c:forEach>
    							<c:forEach items="${book}" var="bo" >
                                <c:if test="${bo.sbook.rnum>40 }">
        							<tr>
        							<td><img class="form-group" src="${bo.book.image }" style="width :40px;height:50px;"></td>
                                    <td><br/>${bo.book.name}</td>
                					<td><br/>${bo.book.ISBN}</td>
                					<td><br/>${bo.sbook.price}</td>
                					<td><br/>${bo.sbook.rnum}</td>
                					<td><br/>${bo.type.name}</td>
                					
                                    <td><br/>
                                        <div class="btn-group">
                                       		<a onclick="update(${bo.book.ISBN },${bo.sbook.price },${bo.sbook.rnum})" class="btn btn-default">编辑</a>
                                       		<a href="WDownBookServlet?down=${bo.book.ISBN }" onclick="dow()" class="btn btn-danger">下架</a>
                                        </div>
                                    </td>
                                    
                                	</tr>
                                </c:if>
    							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="WSalesBookServlet?num=${page-1}">&laquo;</a>
                        </li>
                        <li class="active"><a>${page}/${total}</a>
                        
                        <li><a href="WSalesBookServlet?num=${page+1}">&raquo;</a>
                        </li>
                    </ul>
                </div>
                
                	

</body>

</html>