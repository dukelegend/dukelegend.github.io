<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单结算</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/order_info.css"/>

    <script type="text/javascript">

        function toPay(orderId) {
            location.href = "NOrderPayServlet?ZBOID="+orderId;
        }

        function deleteOrder(orderId) {
            if (confirm("确认取消订单吗?")) {
                location.href = "NQorderServlet?Qid="+orderId;
            }
        }

        function confirmReceiving(orderId) {
            if(confirm("确认收货吗?")){
                location.href = "NCompleteServlet?Qid="+orderId;
            }
        }

        function lookShipping(expressid) {
            alert("物流单号为："+expressid);
        }
        
        function applyReturn(orderId) {
        	if(confirm("确认申请退货吗?")){
                location.href = "NApplyReturnServlet?Qid="+orderId;
            }
        }
        
        function QapplyReturn(orderId) {
        	if(confirm("确认取消申请退货吗?")){
                location.href = "NQApplyReturnServlet?Qid="+orderId;
            }
        }
        
        function appfapiao(orderId) {
        	alert("已提交单号为"+orderId+"的发票申请");
        }
        
        function returnok(orderId) {
        	if(confirm("确认完成退货吗?")){
                location.href = "NApplyReturnOKServlet?Qid="+orderId;
            }
        }
        
        function evaluate(orderId) {
        	if(confirm("对订单"+orderId+"进行评价吗?")){
                location.href = "NEvaluateOrderServlet?Qid="+orderId;
            }
        }
        
        function dealreturn(orderId) {
            location.href = "NdealreturnInforServlet?Qid="+orderId;
        }
        
    </script>
</head>
<body>
<jsp:include page="Nheader.jsp"/>

<div class="container">

    <c:if test="${orderCustom == null || empty orderCustom}">
        <div class="row">
            <h1 class="h1">亲，您还没有已提交的订单，<a href="NMainServlet">再逛一逛吧!</a></h1>
            <img src="img/empty.png" alt="您暂时没有订单">
        </div>
    </c:if>

    <c:if test="${orderCustom != null && !empty orderCustom}">

    <div class="row">
        <h1 class="title order_title">订单列表</h1>
    </div>

    <div class="row" id="order_table_div">
        <table id="order_table" border="0" cellpadding="0" cellspacing="0">
            <thead>
            <tr id="table_head">
                <th width="10%" class="tcol1" style="text-align: center;">订单编号</th>
                <th width="30%" class="tcol1" style="text-align: center;">物品</th>
                <th width="10%" style="text-align: center;">订单状态</th>
                <th width="10%" style="text-align: center;">金额</th>
                <th width="15%" style="text-align: center;">收货地址</th>
                <th width="25%" style="text-align: center;">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderCustom}" var="orderCustom">
                <tr class="order_item" id="order_item${orderCustom.BOid}">

                    <td style="text-align: center;">
                        <span>${orderCustom.BOid}</span>
                    </td>
                    <td style="padding-left: 20px">
                        <c:forEach items="${orderCustom.orders}" var="orderDetail">
                          <c:forEach items="${allBook}" var="Book">
                             <c:if  test = "${orderDetail.ISBN eq Book.ISBN}">  
                            <span>${orderDetail.price}->&nbsp;</span>
                            <a href="NbookinforServlet?BISBN=${Book.ISBN}"  target="_blank" title="${Book.name}"><img src="${Book.image}"
                                                                           width="15%"/>${Book.name}x${orderDetail.num}</a>
                                     </c:if>                                    
                                </c:forEach>                                          
                        </c:forEach>
                    </td>
                    <td style="text-align: center;">
                        <span>${orderCustom.state}</span>
                    </td>
                    <td style="text-align: center;">
                    <span class="red">￥<fmt:formatNumber type="number" value="${orderCustom.totolprice}"
                                                             pattern="0.00"/></span>
                    </td>
                    <td style="text-align: center;">
                        <span>${orderCustom.address}</span>
                    </td>
                    <td style="text-align: center;">
                        <c:if test="${orderCustom.state eq '待付款'}">
                            <button type="button" class="btn btn-info btn-xs" onclick="toPay('${orderCustom.BOid}')">
                                去支付
                            </button>
                            <button type="button" class="btn btn-xs btn-danger" onclick="deleteOrder('${orderCustom.BOid}')">
                                取消订单
                            </button>
                        </c:if>
                        <c:if test="${orderCustom.state eq '待发货' || orderCustom.state eq '待收货'}">
                                <button type="button" class="btn btn-xs btn-info" onclick="confirmReceiving('${orderCustom.BOid}')" >
                                    确认收货
                                </button>
                                <c:if test="${orderCustom.state eq '待收货'}">
                            <button type="button" class="btn btn-xs btn-info" onclick="lookShipping('${orderCustom.expressid}')" >
                                查看物流
                            </button>
                             </c:if>
                            <button type="button" class="btn btn-xs btn-danger" onclick="applyReturn('${orderCustom.BOid}')">
                                申请退货
                            </button>
                         </c:if>  
                         <c:if test="${orderCustom.state eq '已收货'}">
                         <button type="button" class="btn btn-xs btn-info" onclick="lookShipping('${orderCustom.expressid}')" >
                                查看物流
                            </button>
                                <button type="button" class="btn btn-xs btn-info" onclick="evaluate('${orderCustom.BOid}')" >
                                    评价
                                </button>
                            <button type="button" class="btn btn-xs btn-danger" onclick="applyReturn('${orderCustom.BOid}')">
                                申请退货
                            </button>
                        </c:if>
                        <c:if test="${orderCustom.state eq '已完成'}">
                        <button type="button" class="btn btn-xs btn-info" onclick="lookShipping('${orderCustom.expressid}')" >
                                查看物流
                            </button>
                                <button type="button" class="btn btn-xs btn-info" onclick="appfapiao('${orderCustom.BOid}')" >
                                    申请发票
                                </button>
                            <button type="button" class="btn btn-xs btn-danger" onclick="applyReturn('${orderCustom.BOid}')">
                                申请退货
                            </button>
                        </c:if>
                          <c:if test="${orderCustom.state eq '申请退货中'}">
                          <button type="button" class="btn btn-xs btn-info" onclick="lookShipping('${orderCustom.expressid}')" >
                                查看物流
                            </button>
                                <button type="button" class="btn btn-xs btn-info" onclick="QapplyReturn('${orderCustom.BOid}')" >
                                    取消申请退货
                                </button>
                        </c:if>
                        <c:if test="${orderCustom.state eq '退货中'}">
                        <button type="button" class="btn btn-xs btn-info" onclick="lookShipping('${orderCustom.expressid}')" >
                                查看物流
                            </button>
                             <button type="button" class="btn btn-xs btn-info" onclick="dealreturn('${orderCustom.BOid}')" >
                               查看退货信息
                            </button>
                                <button type="button" class="btn btn-xs btn-info" onclick="returnok('${orderCustom.BOid}')" >
                                    退货完成
                                </button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="pages2" style="margin-top: 30px;">
		        <p align="right"> 当前页数:[${sessionScope.pageNum}/${sessionScope.total}]<br>
		        <a href="SearchOrderServlet?num=1">首页</a>| 
		        <a href="SearchOrderServlet?num=${sessionScope.pageNum-1}">上一页</a>|
		        <a href="SearchOrderServlet?num=${sessionScope.pageNum+1}">下一页</a>|
		        <a href="SearchOrderServlet?num=${sessionScope.total}">末页</a> 
		        </p> 
		 </div>
    </div>
    </c:if>
</div>

</body>
</html>
