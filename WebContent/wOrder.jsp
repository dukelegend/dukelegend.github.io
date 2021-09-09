<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="resources/layui/layui.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="resources/layui/css/layui.css">

</head>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script>
function send(e){
	
	document.getElementById("boid").value=e;
	layui.use(['form'],function(){
		var form = layui.form;
		layer.open({
            type: 1,
            title: '',
            area: ['350px', '200px'],
            offset: '20px',
            content: $("#up"),
            shadeClose:1,
        });
		
	})
}

</script>
<body>
<div style="display: none" id="up">
<form class="layui-form layui-form-pane" action="WsendOrderServlet" id="upform">
                <input style="display: none" id="boid" name="boid">
                <br/>
                <div class="layui-form-item">
                    <label class="layui-form-label">填写快递单号</label>
                    <div class="layui-input-inline">
                        <input type="text" id="di" name="di" required  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">快递公司</label>
                    <div class="layui-input-inline">
                        <input type="text" id="go" name="go" required value="顺丰" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" id="submit">发货</button>
                        
                    </div>
                </div>
            </form>
</div>
 <div class="col-sm-12">
	<div class="panel panel-default">
    	<div class="panel-heading">待发货订单</div>
     </div>
                    <!--
                        列表展示
                    -->
                    <div class="table-responsive">
                        <table class="table  ">
                        
                            <c:forEach items="${order}" var="ord">
                            <tbody>
                            <tr style="background-color:rgb(205, 248, 248)">
                                   
                                    <td>下单时间:${ord.order[0].createTime }</td>
                                    <td>订单号:${ord.bigorder.BOid}</td>
                                    
                                    <td>用户ID:${ord.bigorder.cid}</td>
                                    <td>总价:${ord.total}元</td>
                                    
                                    <!-- 订单收货信息 -->
                                    
                                   
                                </tr>
                              <tr>
                              <td>收货人：${ord.rinfo.name}</td>
                              <td>收货地址：${ ord.rinfo.address}</td>
                              <td>手机号：${ord.rinfo.phoneNum}</td>
                              <td></td>
                              </tr>   
                           <c:forEach items="${ord.order}" var="od">
        							<tr>
        							<c:forEach items="${book }" var="bo">
        							<c:if test="${od.ISBN==bo.ISBN }" >
                                    <td><div class="form-inline"><img class="form-group" src="${bo.image }" style="width :50px;height:60px;">
                                    
                                    <div class="form-group"><div>&nbsp;&nbsp;${bo.name }</div><a>&nbsp;&nbsp;&nbsp;${bo.author }</a></div>
                					
                					</div>
                                    </td>
                                    </c:if>
                                    </c:forEach>
                					<td>单价<br/><fmt:formatNumber type="number" value="${od.price/od.num}" maxFractionDigits="2"/></td>
                					<td>数量<br/>&nbsp;&nbsp;${od.num }</td>
                					<td>备注<br/>${od.remarks }</td>
                                	</tr>
                                </c:forEach>
                                
                                	<tr>
                                	<td></td>
                                	<td></td>
                                	<td></td>
                                	<td>
                                        <div class="btn-group" style="float: right;">
                                       		<a onclick="send('${ord.bigorder.BOid}')" style="width:100px" class="btn btn-success">发货</a>
                                       		<a  style="width:100px" class="btn btn-default">拒绝</a>
                                       		
                                       
                                        </div>
                                    </td>
                                    
                                	</tr>
    							
                            </tbody>
                            </c:forEach>
                             
                        </table>
                    </div>
                    <ul class="pagination" style="float: right;">
                        <li><a href="WOrderServlet?num=${page-1}">&laquo;</a>
                        </li>
                        <li class="active"><a>${page}/${total}</a>
                        
                        <li><a href="WOrderServlet?num=${page+1}">&raquo;</a>
                        </li>
                    </ul>
                </div>	

</body>

</html>