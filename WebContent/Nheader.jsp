<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="img/java.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>三人行-网上书店</title>
</head>
<jsp:include page="Ntop.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12 logo">
            <a href="NMainServlet" target="_blank"><img src="img/logo1.jpg" width="90%" height="120%"
                                                 alt="三人行"/></a>
        </div>
        <div class="col-lg-6 col-md-6 col-xs-12 search">
            <form action="NMHSearchServlet?cateId=QBTS" class="form-inline" id="searchForm" role="form" method="get">
                <div class="form-group">
                    <label class="sr-only" for="keywords">关键字</label>
                    <input type="text" class="form-control" id="keywords" name="keywords" value="${keywords}"size="55"
                           placeholder="java">
                </div>
                <button type="button" onclick="submitSearchForm()" class="btn btn-primary">
                    <span class="glyphicon glyphicon-search"></span>搜索
                </button>
            </form>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12 search">
            <button type="button" onclick="window.open('NCartItemsServlet')"
                    style="background-color: #ff2832;border-color: #ff2832" class="btn btn-info">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                我的购物车
            </button>
            <button type="button" onclick="window.open('SearchOrderServlet')"
                    style="background-color: #ff2832;border-color: #ff2832" class="btn btn-info">我的订单
            </button>
        </div>
    </div>
    <div class="row">
        <ul class="nav nav-tabs" style="margin-left: 300px">
            <li id="SY100"><a href="NMainServlet">首页</a></li>
             <li id="QBTS100"><a href="NbsearchServlet?cateId=QBTS">全部图书</a></li>
            <c:forEach items="${booktypes}" var="BookType">
                <li id="${BookType.typeid}"><a href="NbsearchServlet?cateId=${BookType.typeid}">${BookType.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<div style="height: 3px; background-color: #ff2832;"></div>
        <script type="text/javascript">
    $(function () {
        //轮播图间隔时间
        $('.carousel').carousel({
            interval: 2000
        });
    });

    function submitSearchForm() {
        var keywords = $("#keywords").val();
        if("" == keywords.trim()){
            $("#keywords").val("java");
        }

        $("#searchForm").submit();
    }
</script>
</html>
