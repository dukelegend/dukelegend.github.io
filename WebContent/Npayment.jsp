<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>支付订单${BOID}</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/addcart.css"/>

</head>
<body>

<jsp:include page="Nheader.jsp"/>
<div class="container" style="border: 4px solid #f5f5f5;">
    <div class="tip_div" style="margin-left: 200px;">
        <div id="success">
            <span class="success_text">准备支付</span>
        </div>
        <div class="things">
            <p>
                <span>订单号</span>
                <span>${BOID}</span>
            </p>
            <p>
                <span>支付金额</span>
                <span class="red">${totolprice}</span>
            </p>
        </div>
    </div>

    <div class="next_div" style="margin-left: 320px;">
        <a href="Npay.jsp" class="toCart">支付</a>
        <a href="SearchOrderServlet" class="toShopping">查看所有订单</a>
    </div>

</div>
</body>
</html>