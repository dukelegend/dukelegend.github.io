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
<script type="text/javascript">
function tong(){
	alert("确认同意")
}
function bu(){
	alert("确认拒绝")
}
</script>
<body>
<div class="col-sm-12">
	<div class="panel panel-default">
    	<div class="panel-heading">退货单处理</div>
     </div>
                    <!--
                        列表展示
                    -->
                    <div class="table-responsive">
                        <table class="table table-striped ">
                         
                            <c:forEach items="${rorder}" var="ord">
                            
                            <tbody >
                            
                            <tr style="background-color:rgb(225,225,225)" >
                                   
                                  
                                    
                                    <td>订单号:${ord.bigorder.BOid}</td>
                                    
                                    <td>顾客ID:${ord.bigorder.cid}</td>
                                    
                                   
                                    <!-- 订单收货信息 -->
                                    <td>总价:${ord.total}元</td>
                                     <td></td><td></td><td></td>
                               </tr> 
                            
                               <tr>
                                <c:forEach items="${application}" var="ap">
                                    
        							<c:if test="${ap.oid==ord.bigorder.BOid }" >
                					
                					<td>申请时间:</td>
                					<td>${ap.date }</td>
                					<td>退货理由:</td>
                					<td>${ap.reason }</td>
                					</c:if>
                					</c:forEach>
                               </tr>
                           </tbody> 
                           <tbody>  
                           <tr style="background-color:white"> 
                           <c:forEach items="${ord.order}" var="od">
        							
        							<c:forEach items="${book }" var="bo">
        							<c:if test="${od.ISBN==bo.ISBN }" >
                                    <td><img src="${bo.image }" style="width :50px;height:60px;"></td>
                                    <td><br/>
                                    ${bo.name }
                                    </td>
                                    </c:if>
                                    </c:forEach>
                                    <td><br/>数量:${od.num }</td>
                					
                					
                                	
                                </c:forEach>
                              </tr>  
                                	<tr>
                                	<td></td><td></td><td></td><td></td><td></td>
                                	<td>
                                        <div class="btn-group" style="float: right;">
                                       		<a  onclick="tong()" href="WAgreeServlet?yes=${ord.bigorder.BOid}" style="width:100px" class="btn btn-success">同意</a>
                                       		<a onclick="bu()" href="WAgreeServlet?no=${ord.bigorder.BOid}" style="width:100px" class="btn btn-default">拒绝</a>
                                       	
                                        </div>
                                    </td>
                                    </tr>
                                	
    							</tbody> 
                           
                            </c:forEach>
                            
                        </table>
                    </div>
                   
                </div>	
</body>
</html>