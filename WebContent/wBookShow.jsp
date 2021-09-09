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

<body>
<div style="display: none" id="up">
<form class="layui-form layui-form-pane" action="WUpBookServlet" id="upform" >
                <input style="display: none" id="isbn" name="isbn">
                <div class="layui-form-item">
                    <label class="layui-form-label">售价</label>
                    <div class="layui-input-inline">
                        <input type="text" id=price name="price" required  placeholder="请输入售价" autocomplete="off" class="layui-input" id="pass1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上架数量</label>
                    <div class="layui-input-inline">
                        <input type="text" id="num" name="num" required  placeholder="请输入数量" autocomplete="off" class="layui-input" id="pass2">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上架类型</label>
                    <div class="layui-input-inline">
                       <select name="type" id="type" class="form-control" style="width: 100px;">
                    	<c:forEach items="${type}" var="ty">
                        <option value="${ty.typeid}">${ty.name}</option>
                    	</c:forEach>
                		</select>
                   </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">图书描述</label>
                    <div class="layui-input-inline">
                        <textarea id="des" name="des"  rows="3" required  placeholder="请输入图书描述" autocomplete="off" class="layui-input"></textarea>
                        
                    </div>
                </div>
              <!-- <button type="submit" class="layui-btn" id="submit"> -->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" id="submit">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
</div>
<div class="col-sm-12">
	<div class="panel panel-default">
    	<div class="panel-heading">搜索图书</div>
        <div class="panel-body">
           <form action="WBookServlet" method="get" class="form-inline">
           	<div class="form-group">
                   <label for="name">请输入</label>
                   <input type="text" class="form-control" name="querys" placeholder="ISBN号/书名">
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
                                    <th>作者</th>
                                    <th>出版社</th>
                                    <th>ISBN号</th>
                                    <th>定价</th>
                                    
                                    <th>开本</th>
                                    <th>出版时间</th>
                             
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${book}" var="bo" >
        							<tr>
        							<td><img class="form-group" src="${bo.image }" style="width :40px;height:50px;"></td>
                                    <td ><br/>${bo.name}</td>
                					<td><br/>${bo.author}</td>
                					<td><br/>${bo.press}</td>
                					<td><br/>${bo.ISBN}</td>
                					<td><br/>${bo.price}</td>
                					
                					<td><br/>${bo.bookSize}</td>
                					<td><br/>${bo.publishTime}</td>
                					
                					
                                    <td><br/>
                                        <div class="btn-group">
                                        <c:if test="${bo.issale==false}">
                                       		<a onclick="up(${bo.ISBN})" class="btn btn-default">上架</a><a onclick="delet()" class="btn btn-danger">删除</a>
                                        </c:if>
                                        <c:if test="${bo.issale==true }">
                                        	<a onclick="xia()" href="WUpBookServlet?down=${bo.ISBN}" class="btn btn-success">下架</a>
                                        </c:if>
                                            
                                        </div>
                                    </td>
                                	</tr>
    							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="WBookServlet?num=${page-1}">&laquo;</a>
                        </li>
                        <li class="active"><a>${page}/${total}</a>
                        
                        <li><a href="WBookServlet?num=${page+1}">&raquo;</a>
                        </li>
                    </ul>
                </div>			
       
<script src="js/jquery-1.8.3.js"></script>

<script src="resources/layui/layui.js"></script>
</body>

<script>
function up(e){
	
	var input = document.getElementById("isbn");

	input.value=e;
	layui.use(['form'],function(){
		var form = layui.form;
		layer.open({
            type: 1,
            title: '上架图书',
            area: ['550px', '600px'],
            offset: '20px',
            content: $("#up"),
            shadeClose:1,
        });
		
});

}
function delet(){
	alert("该图书不可删除")
}
function xia(){
	alert("确认下架")
}
    
 /*
 layer.open({
            type: 1,
            title: '上架图书',
            area: ['550px', '600px'],
            offset: '20px',
            content:'<select name="bookCategoryId" id="bookCategoryId" class="form-control" style="width: 100px;">'+
            	'<c:forEach items="${book}" var="bo">'+
            '<option value="${bo.ISBN}">${bo.name}</option>'+
        	'</c:forEach>'+
    		'</select>',
            
            
            shadeClose:1,
        });
 */


/*layui.use('form',function () {$(function() {
	$("#but").click(function() {
		
        layer.open({
            type: 1,
            title: "注册页面",
            area: ['550px', '600px'],
            offset: '20px',
            content: $("#up"),
            closeBtn: 0,
            shadeClose:1
        })
       
    })
})*/


</script>

</html>