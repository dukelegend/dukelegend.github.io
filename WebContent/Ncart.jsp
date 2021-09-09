<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/cart.css"/>

    <script type="text/javascript">

        function deleteCartItem(Id) {
            var isDelete = confirm("真的要删除?");
            if (isDelete) {
                location.href = "NDeleteCartServlet?id=" + Id;
            }
        }

        function checkTotal() {
            var all_total_text = $("#all_total").text();
            var allTotal = parseFloat(all_total_text.substring(all_total_text.indexOf("￥") + 1)).toFixed(2);
            if (allTotal <= 0) {
                alert("亲，请至少购买一件商品!");
            } else {
                location.href = "order_info.jsp";
            }
        }

    </script>
</head>
<body>

<jsp:include page="Ncart_header.jsp"/>

<div class="container">
    <c:if test="${shoppingCarts == null}">
        <div class="row">
            <h1 class="h1">亲，您的购物车为空，<a href="NMainServlet">再逛一逛吧!</a></h1>
            <img src="img/empty.png" alt="您的购物车为空">
        </div>
    </c:if>

    <c:if test="${shoppingCarts != null}">
        <div class="row" id="cart_table_div">
            <table id="cart_table" border="0" cellpadding="0" cellspacing="0">
                <thead>
                <tr id="table_head">
                    <th width="40%">商品信息</th>
                    <th width="15%">单价（元）</th>
                    <th width="10%">数量</th>
                    <th width="15%">小计（元）</th>
                    <th width="10%">操作</th>
                </tr>
                </thead>

                <tbody>
                <tr class="shop_intro">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <c:forEach items="${shoppingCarts}" var="cartItem">
                    <tr class="cart_item" id="cart_item${cartItem.nBook_SalesBook.ISBN}">
                        <td class="tcol1" hidden="hidden">
                            <input type="checkbox" class="shop_checkbox" />
                        </td>
                        <td>
                            <a href="#"><img src="${cartItem.nBook_SalesBook.image}" width="20%"/></a>
                            <span>   ${cartItem.nBook_SalesBook.name}</span>
                        </td>
                        <td>
                            <span class="red">￥<fmt:formatNumber type="number" value="${cartItem.nBook_SalesBook.nowprice}"
                                                                 pattern="0.00"/></span>
                        </td>
                        <td>
                            <div class="num">
                                <input type="text" disabled class="buy_num" value="${cartItem.num}"/>                    
                            </div>
                        </td>
                        <td>
                            <span class="red">￥</span>
                            <span class="red subTotal">
										<fmt:formatNumber type="number" value="${cartItem.totolprice}"
                                                          pattern="0.00"/>
									</span>
                        </td>
                        <td>
                            <a href="javascript:void(0);"
                               onclick="deleteCartItem(${cartItem.id})" style="font-size: 18px; color: #0080c0;">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            <tr class="tfoot">
            <td colspan="5">
             <div id="pages2">
		        <p align="right"> 当前页数:[${sessionScope.pageNum}/${sessionScope.total}]<br>
		        <a href="NCartItemsServlet?num=1">首页</a>| 
		        <a href="NCartItemsServlet?num=${sessionScope.pageNum-1}">上一页</a>|
		        <a href="NCartItemsServlet?num=${sessionScope.pageNum+1}">下一页</a>|
		        <a href="NCartItemsServlet?num=${sessionScope.total}">末页</a> 
		        </p> 
		  	 </div>
		  	 </td>
		   </tr>
                <tr class="tfoot">
                    <td>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td class="shop_total">合计：￥<fmt:formatNumber type="number" value="${allprice}" pattern="0.00"/></td>
                    <td></td>
                </tr>

                </tbody>

            </table>
        </div>

        <div class="row account_div">
            <div id="batch">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="NMainServlet" style="font-size: 20px;color: #000000">继续购物</a>
            </div>
            <div id="shopping_total">
                <p class="total_p">
                    <span>总计：</span>
                    <span id="all_total">
                        ￥<fmt:formatNumber type="number" value="${allprice}" pattern="0.00"/>
                    </span>
                </p>
                <a href="javascript:void(0);" class="total_btn" onclick="checkTotal()">填写订单</a>
            </div>
        </div>
    </c:if>

</div>
<div class="clear"></div>
</body>
</html>

