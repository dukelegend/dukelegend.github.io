<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <link rel="stylesheet" href="css/book_info.css"/>


    <title>书籍详情</title>
    <script type="application/javascript">
        $(function () {

            $(".book_message li").click(function () {
                $(".book_message li").removeClass("active");
                $(this).addClass("active");
                $(".nav_content").hide();
                var name = $(this).attr("id");
                $("#" + name + "_content").show();
            });

            $("#num_add").click(function () {
                var num = parseInt($("#buy_num").val());
                if (num <  parseInt($("#XG").val())) {
                    $("#buy_num").val(num + 1);
                }
            });

            $("#num_sub").click(function () {
                var num = parseInt($("#buy_num").val());
                if (num > 1) {
                    $("#buy_num").val(num - 1);
                }
            });
        });

        function buyNow(bookId) {
            location.href =  "" + "NBuyNowServlet?bookId=" + bookId + "&buyNum=" + $("#buy_num").val();
        }

        function addCart(bookId) {
            location.href = "" + "NaddcartServlet?bookId=" + bookId + "&buyNum=" + $("#buy_num").val();
        }
    </script>
</head>
<body>

<jsp:include page="Nheader.jsp"/>
<div class="container">
    <div class="row" id="breadcrumb" style="margin-bottom:40px;">
        <a href="Nindex" target="_blank">
            <b>图书</b>
        </a>
        <span>&gt;</span>
        <a href="NbsearchServlet?cateId=${nBook_SalesBook.typeid}" target="_blank">${booktype}</a>
        <span>&gt;</span>
        <b>${nBook_SalesBook.name}</b>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="height: 400px;">
            <div>
                <a>
                    <img src="${nBook_SalesBook.image}" width="280px" height="350px"/>
                </a>
            </div>
        </div>
        <div class="col-lg-9 col-md-6 col-sm-12 col-xs-12">
            <div class="name_info">
                <h1 style="font-weight: bold;">${nBook_SalesBook.name}</h1>
                <h2>
                    <span>${nBook_SalesBook.description}</span>
                </h2>
            </div>
            <div class="book_info_base">
						<span class="book_info_span">
								作者:${nBook_SalesBook.author}著，
								${nBook_SalesBook.press}&nbsp;出版
							</span>
                <span class="book_info_span">
								出版社：${nBook_SalesBook.press}
							</span>
                <span class="book_info_span">
								出版日期： ${nBook_SalesBook.publishTime}
							</span>
            </div>
            <div class="book_price">
                <p class="what_price">特价</p>
                <p class="price_info">
                    <span class="rob" style="font-size: 30px;">￥${nBook_SalesBook.nowprice}</span>
                    <span>定价:</span>
                    <span class="oprice">￥${nBook_SalesBook.price}</span>
                </p>
            </div>

            <div class="buy_box">
                <div class="num buy_div">
                    <input type="text" class="text" id="buy_num" name="buy_num" disabled="disabled" value="1" width="30px"
                           height="30px"/>
                    <a href="javascript:void(0);" class="num_add" id="num_add" style="background: #CCCCCC">+</a>
                    <a href="javascript:void(0);" class="num_sub" id="num_sub" style="background: #CCCCCC">-</a>
                </div>
                <input type="hidden" id="XG" name="XG" value="${XG}">
                <div class="buy_div">
                    <div class="cart">
                        <a href="javascript:void(0);" onclick="addCart(${nBook_SalesBook.ISBN})" class="add_cart">
                            <i class="cart_icon"></i> 加入购物车
                        </a>
                    </div>
                </div>
                <div class="buy_div buy_now_div">
                    <a href="javascript:void(0);" onclick="buyNow(${nBook_SalesBook.ISBN})" class="buy_now">立即购买</a>
                </div>
                <div class="clear"></div>
                <div class="buy_tip">每账户最多可购买<b>${XG}</b>件</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="product_left">
                <h3 style="">浏览此商品的顾客也同时浏览</h3>
                <ul class="product_left_ul">

                    <c:forEach items="${recommendBookList}" var="recommendBook">
                        <c:if test="${recommendBook.ISBN != nBook_SalesBook.ISBN}">
                            <li class="product_li">
                                <p class="pic">
                                    <a href="NbookinforServlet?BISBN=${recommendBook.ISBN}" class="img" target="_blank">
                                        <img src="${recommendBook.image}"/>
                                    </a>
                                <p class="price">
                                    <span class="rob">￥${recommendBook.nowprice}</span>
                                    <span class="oprice">￥${recommendBook.price}</span>
                                </p>
                                <p class="name">
                                    <a href="NbookinforServlet?BISBN=${recommendBook.ISBN}">${recommendBook.name}</a>
                                </p>
                                <p class="author">${recommendBook.author}著，${recommendBook.press}出版</p>
                                
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">

            <ul class="nav nav-tabs nav-justified book_message">
                <li class="active" id="book_detail">
                    <a href="javascript:void(0)">书籍详情</a>
                </li>
                <li id="book_comment">
                    <a href="javascript:void(0)">书籍评论</a>
                </li>
            </ul>
            <div class="content">
                <div id="book_detail_content" class="nav_content">
                    <ul id="key">
                        <li>开 本：${nBook_SalesBook.bookSize}</li>
                        <li>类 型：${booktype}</li>
                        <li>国际标准书号ISBN：${nBook_SalesBook.ISBN}</li>
                    </ul>
                    <div id="detail" class="section">


                        <div id="bookDetail" class="section">
                            <div class="title">
                                <span class="title_span">书籍详情</span>
                            </div>
                            <p>
                                ${nBook_SalesBook.description}
                            </p>
                        </div>
                        <div class="abstract" class="section">
                            <div class="title">
                                <span class="title_span">作者简介</span>
                            </div>
                            <blockquote>
                                <pre>${nBook_SalesBook.author}</pre>
                            </blockquote>
                        </div>
                    </div>
                </div>
                <div id="book_comment_content" style="display: none;" class="nav_content">
                    商品评论${evaluates.size()}
                    <c:forEach items="${evaluates}" var="evaluate">
                    <ul id="key1">
                        <li>用户：${evaluate.cid}</li>
                        <li>评价等级：${evaluate.level}</li>               
                        <li>时间：${evaluate.time}</li>
                        <li>内容：${evaluate.context}</li>
                    </ul>
                     </c:forEach>
               </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>