<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>加入购物车</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/addcart.css"/>

</head>
<body>

<jsp:include page="Nheader.jsp"/>
<div class="container" style="border: 4px solid #f5f5f5;">
    <div class="tip_div">

        <c:if test="${sessionScope.loginUser != null}">
            <div id="success">
                <span class="success_text">商品已成功添加到购物车中！</span>
            </div>
            <div class="things">
                <span>${nBook_SalesBook.name}</span>
                <span>x${buynum}</span>
            </div>

        </c:if>

        <c:if test="${sessionScope.loginUser == null}">

            <div id="success">
                <span class="success_text">不好意思，添加到购物车失败！您还未登录。</span>
            </div>

        </c:if>

    </div>
    <div class="next_div">
        <a href="NCartItemsServlet" class="toCart">去购物车结算</a>
        <a href="NMainServlet" class="toShopping">继续购物</a>
    </div>
</div>
</body>
</html>
