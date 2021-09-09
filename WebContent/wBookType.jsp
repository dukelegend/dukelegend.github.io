<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/layer.css">
<script src="js/jquery-1.8.3.js"></script>
<script src="js/layer.js"></script>
</head>
<script type="text/javascript">
function de(){
	alert("该类型不可删除")
}
</script>
<body>
<div class="col-sm-12">
	<ol class="breadcrumb">
       <li class="active">图书类型管理</li>
       
    </ol>
	<div class="panel panel-default">
    	<div class="panel-heading">增添图书类型</div>
        <div class="panel-body">
           <form action="WBookTypeServlet" method="get" class="form-inline">
           	<div class="form-group">
                   <label for="name">类型</label>
                   <input type="text" class="form-control" name="type" placeholder="请输入">
               </div>
               <div class="form-group">
                   <label for="name">类型编号</label>
                   <input type="text" class="form-control" name="id" placeholder="请输入">
               </div>
               <div class="form-group">
                   <label for="name">简介</label>
                   <textarea class="form-control" name="outline" rows="2"></textarea>
               </div>
                        
               <div class="form-group">
                	<button type="submit" class="btn btn-default">添加</button>
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
                                    <th>图书类型</th>
                                    <th>类型编号</th>
                                    <th>类型简介</th>
                                    <th>操作</th>
                             
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${type}" var="ty" >
        							<tr>
        							<td>${ty.name}</td>
                                    <td >${ty.typeid}</td>
                					
                					<td>${ty.description}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a onclick="de()" class="btn btn-default">删除</a>
                                        </div>
                                    </td>
                                	</tr>
    							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="WBookTypeServlet?num=${page-1}">&laquo;</a>
                        </li>
                        <li class="active"><a>${page}/${total}</a>
                        
                        <li><a href="WBookTypeServlet?num=${page+1}">&raquo;</a>
                        </li>
                    </ul>
                </div>			
 <c:if test="${not empty meg}">
	  <script type="text/javascript">
 	layer.open({
	    content: '${meg}',
	    icon:2,
	    btnAlign: 'c'
	}); 
 	</script>
</c:if>         

</body>
</html>



