<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="resources/layui/css/layui.css">
</head>
<script src="js/jquery-1.8.3.js"></script>
<script src="resources/layui/layui.js"></script>
<script>
$(function () {
    $("#qu").validate({
        //一失去焦点就校验
        onfocusout: function (element) {
            $(element).valid();
        },
        errorPlacement: function (error, element) {	//错误信息位置设置方法
            error.appendTo(element.parent().next());//这里的error是生成的错误对象，element是录入数据的对象,parent父元素，next()下一个
        },
        errorClass: "red",
        rules: {
        	
        	querys: {
                required: true,
                
            },
            
            
        },
        messages: {
        	querys: {
                required: "sf",
                
            },
        }
    });
});
</script>
<body>
<div class="col-sm-12">

	<div class="panel panel-default">
    	<div class="panel-heading">待收货订单</div>
        <div class="panel-body">
           <form action="WokServlet" role="form" method="get" id="qu" name="qu" class="form-inline">
           	<div class="form-group">
                   <label for="name">请输入</label>
                   <input type="text" class="form-control" name="query" >
               </div>
               
               <div class="form-group">
                	<button type="submit" class="btn btn-default">搜索</button>
               </div>
             <div class="form-group" style="float: right;">
                   <h4>总订单量：${num}</h4>
               </div>
           </form>
           
        </div>
     </div>
                    <!--
                        列表展示
                    -->
                    <div class="table-responsive">
                        <table class="table  ">
                        
                            <c:forEach items="${order}" var="ord">
                            <tbody style="width:305px">
                            <tr style="background-color:rgb(205, 248, 248)">
                                   <td>订单号:${ord.bigorder.BOid}</td><td></td>
                                    <td>下单时间:${ord.order[0].createTime }</td>
                                    <td>用户ID:${ord.bigorder.cid}</td>
                                    <td>总价:${ord.total}元</td>
                                    
                                    
                                    <td></td>
                                    <!-- 订单收货信息 -->
                                    
                                   
                                </tr>
                              
                           <c:forEach items="${ord.order}" var="od">
        							<tr>
        							<c:forEach items="${book }" var="bo">
        							<c:if test="${od.ISBN==bo.ISBN }" >
        							<td><br/>订单图书</td>
                                    <td><div class="form-inline"><img class="form-group" src="${bo.image }" style="width :50px;height:60px;">
                                    
                                    </div>
                                    </td>
                                    <td>
                                    <br/>
                                    	《${bo.name }》&nbsp;/&nbsp;${bo.author }
                					
                                    </td>
                                    </c:if>
                                    </c:forEach>
                                    
                					<td><br/>单价：<fmt:formatNumber type="number" value="${od.price/od.num}" maxFractionDigits="2"/>元</td>
                					
                					
                					<td><br/>数量：&nbsp;&nbsp;${od.num }</td>
                					<td><br/></td>
                					
                                	</tr> 
                                </c:forEach>
                               
                                	
    							
                            </tbody>
                            </c:forEach>
                             
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="WokServlet?num=${page-1}">&laquo;</a>
                        </li>
                        <li class="active"><a>${page}/${total}</a>
                        
                        <li><a href="WokServlet?num=${page+1}">&raquo;</a>
                        </li>
                    </ul>
                </div>	

</body>
</html>