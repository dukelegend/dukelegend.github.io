<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单评价</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/order_info.css"/>
</head>
<body>
<jsp:include page="Nheader.jsp"/>

<div class="container">

<c:if test="${sessionScope.loginUser != null}">
            <form id="orderForm" action="NDealEvaServlet" class="form-horizontal" method="get">

        <div class="row">
            <h1 class="title order_title">订单${evaBigOrders}详情</h1>
        </div>

        <div class="row" id="order_table_div">
            <table id="order_table" border="1">
                <thead>
                <tr id="table_head">
                <th width="20%" class="tcol1">子订单</th>
                    <th width="20%" class="tcol1">商品信息</th>
                    <th width="10%" class="tcol1">数量</th>
                    <th width="10%" class="tcol1">总价（元）</th>
                    <th width="10%" class="tcol1">等级</th>
                     <th width="30%" class="tcol1">评价内容</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${evaOrders}" var="cartItem">               
                <tr class="order_item">
                   <td class="tcol1">
                        <span>${cartItem.oid}</span>
                    </td>
                      <c:forEach items="${allBook}" var="Book">
                             <c:if  test = "${cartItem.ISBN eq Book.ISBN}">  
                    <td>
                        <a><img src="${Book.image}" width="20%"/></a>
                        <span>${Book.name}</span>
                    </td>
                     </c:if>       
                     </c:forEach>
                    <td class="tcol1">
                        <span>${cartItem.num}</span>
                    </td>
                    <td class="tcol1">
                        <span class="red">￥<fmt:formatNumber type="number" value="${cartItem.price}"
                                                             pattern="0.00"/></span>
                    </td>
                     <td class="tcol1">
                   <select name="level${cartItem.oid}" style="width: 50px;height: 30px;font-size: 17px">
                          <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                </select>
                 </td>
                    <td class="tcol1">
                        <div class="layui-input-inline">
                        <input type="text" name="context${cartItem.oid}"  style="width: 300px;height: 50px;" required lay-verify="reason" placeholder="评价内容" autocomplete="off" class="layui-input" id="context">
                    </div>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row" id="to_paid_div">
            <div id="to_paid_info">
                <button class="total_btn" type="submit" id="checkout_btn">提交</button>
            </div>
            <div id="return_cart">
                <a href="SearchOrderServlet">返回订单列表</a>
            </div>
        </div>
        <div class="clear"></div>
    </form>
        </c:if>
        <c:if test="${sessionScope.loginUser == null}">

            <div id="success">
                <span class="success_text">不好意思，您还未登录！。</span>
            </div>

        </c:if>
</div>


</body>
</html>