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

</head>
<body>
<jsp:include page="order_header.jsp"/>

<div class="container">

<c:if test="${sessionScope.loginUser != null}">
            <form id="orderForm" action="NDealOrderServlet" class="form-horizontal" method="get">
        <div class="row">
            <h1 class="title order_title"style="margin-top: -40px;">收货人信息</h1>
            <div class="form-group" style="margin-left: 280px;">
                <label for="inputPassword3" class="col-sm-1 control-label">姓名：</label>
                <div class="col-sm-5">
                    <input type="text" style="width: 400px;" class="form-control" id="inputPassword3" name="username"
                           placeholder="请确认收货人" value="${sessionScope.loginUser.name}">
                </div>
            </div>
            <div class="form-group" style="margin-left: 280px;">
                <label for="confirmPassword" class="col-sm-1 control-label">电话：</label>
                <div class="col-sm-5">
                    <input type="text" style="width: 400px;" class="form-control" id="confirmPassword" name="phone"
                           placeholder="请输入联系方式" value="${sessionScope.loginUser.phonenum}">
                </div>
            </div>
             <div class="form-group" style="margin-left: 280px;">
                <label for="address" class="col-sm-1 control-label">地址：</label>
                <div class="col-sm-5">
                    <input style="width: 400px;height: 80px;" type="text" class="form-control" id="address" name="detailAddress"
                           value="">
                </div>
            </div>
             <div class="form-group" style="margin-left: 280px;">
                <label for="address" class="col-sm-1 control-label">备注：</label>
                <div class="col-sm-5">
                    <input style="width: 400px;height: 80px;" type="text" class="form-control" id="remarks" name="remarks"
                           value="">
                </div>
            </div>
        </div>

        <div class="row">
            <h1 class="title order_title">订单详情</h1>
        </div>

        <div class="row" id="order_table_div">
            <table id="order_table" border="1">
                <thead>
                <tr id="table_head">
                    <th width="20%" class="tcol1">商品信息</th>
                    <th width="10%">单价（元）</th>
                    <th width="10%">数量</th>
                    <th width="10%">总价（元）</th>
                </tr>
                </thead>

                <c:forEach items="${shoppingCarts}" var="cartItem">               
                <tbody>
                <tr class="order_item">
                    <td>
                        <a><img src="${cartItem.nBook_SalesBook.image}" width="20%"/></a>
                        <span>${cartItem.nBook_SalesBook.name}</span>
                    </td>
                    <td>
                        <span class="red">￥<fmt:formatNumber type="number" value="${cartItem.nBook_SalesBook.nowprice}"
                                                             pattern="0.00"/></span>
                    </td>
                    <td>
                        <span>${cartItem.num}</span>
                    </td>
                    <td>
                        <span class="red">￥<fmt:formatNumber type="number" value="${cartItem.totolprice}"
                                                             pattern="0.00"/></span>
                    </td>
                </tr>
                </c:forEach>

                <tr class="tfoot">
                    <td class="tcol1">
                        <span>店铺合计	</span>
                    </td>
                    <td></td>
                    <td></td>
                    <td class="shop_total">￥<fmt:formatNumber type="number" value="${allprice}" pattern="0.00"/></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="row" id="payment">
            <h1 class="title order_title">支付方式</h1>
            <dl>
                <dt style="font-size: 16px;margin-top: 20px;">&nbsp;网上支付</dt>
                <select name="payMethod" style="width: 120px;height: 40px;font-size: 17px">
                    <option value="2">支付宝</option>
                    <option value="1">微信</option>
                </select>
            </dl>
        </div>

        <div class="row" id="to_paid_div">
            <div id="to_paid_info">
                应付金额
                <span class="shop_total">￥<fmt:formatNumber type="number" value="${allprice}" pattern="0.00"/></span>
                <button class="total_btn" type="submit" id="checkout_btn">结算订单</button>
            </div>
            <div id="return_cart">
                <a href="NCartItemsServlet">返回购物车</a>
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