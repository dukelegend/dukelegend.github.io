<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <link rel="shortcut icon" href="img/java.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bs.css"/>
<title>退货信息填写</title>
</head>
<body>
<jsp:include page="Nheader.jsp"/>
        <div style="margin-left: 780px;margin-top: 150px;">
           <form method="get" action="NDealReturnServlet" class="layui-form layui-form-pane" id="app_form" lay-filter="app_form">
                <div class="layui-form-item">
                    <label class="layui-form-label">订单号</label>
                    <div class="layui-input-inline">
                        <input type="text" style="width: 330px;" name="BOID" readonly  unselectable="on" required lay-verify="BOID" value="${TBOID}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货金额</label>
                    <div class="layui-input-inline">
                        <input type="text" name="money" style="width: 330px;"  required lay-verify="money" placeholder="该订单最大退款金额为：￥${Ttotolprice}" autocomplete="off" class="layui-input" id="money">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货原因</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reason"  style="width: 330px;height: 150px;" required lay-verify="reason" placeholder="退货原因及理由" autocomplete="off" class="layui-input" id="reason">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button  type="submit" style="width: 100px;height: 40px;" id="tijiao" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </form>
        </div>
</body>
</html>