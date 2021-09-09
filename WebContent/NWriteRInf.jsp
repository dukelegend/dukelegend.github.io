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
        <div style="margin-left: 680px;margin-top: 100px;">
           <form method="get" action="NAlertReturnServlet" class="layui-form layui-form-pane" id="app_form" lay-filter="app_form">
                <div class="layui-form-item">
                    <label class="layui-form-label">订单号</label>
                    <div class="layui-input-inline">
                        <input type="text" style="width: 330px;" name="BOID" readonly  unselectable="on" required lay-verify="BOID" value="${returnApplication.oid}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货金额</label>
                    <div class="layui-input-inline">
                        <input type="text" name="money" style="width: 330px;" readonly  unselectable="on" required lay-verify="money" value="该订单退款金额为：￥${returnApplication.price}" autocomplete="off" class="layui-input" id="money">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货原因</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reason"  style="width: 330px;height: 100px;" readonly  unselectable="on" required lay-verify="reason" value="${returnApplication.reason}" autocomplete="off" class="layui-input" id="reason">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货地址</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reason"  style="width: 350px;height: 100px;" readonly  unselectable="on" required lay-verify="address" value="${storeAddress.name},${storeAddress.phonenum},${storeAddress.address}" autocomplete="off" class="layui-input" id="address">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">客服处理</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reason"  style="width: 150px;" readonly  unselectable="on" required lay-verify="address" value="${returnApplication.sstate}" autocomplete="off" class="layui-input" id="address">
                    </div>
                    <label class="layui-form-label">财务处理</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reason"  style="width: 150px;" readonly  unselectable="on" required lay-verify="address" value="${returnApplication.fstate}" autocomplete="off" class="layui-input" id="address">
                    </div>
                </div>
                <div style="margin-top:20px;" class="layui-form-item">
                    <label class="layui-form-label">退货单号</label>
                     <c:if test="${returnApplication.expressid == null || returnApplication.expressid == ''}">
					         <div class="layui-input-inline">
                        			<input type="text" name="expressid"  style="width: 330px" required lay-verify="reason" placeholder="请输入您的退货物流单号" autocomplete="off" class="layui-input" id="expressid">
                            </div>
					    </c:if>
					     <c:if test="${returnApplication.expressid != null && returnApplication.expressid != ''}">
					         <div class="layui-input-inline">
                              <input type="text" name="expressid"  style="width: 330px" required lay-verify="reason" value="${returnApplication.expressid}" autocomplete="off" class="layui-input" id="expressid">
                            </div>
					    </c:if>
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