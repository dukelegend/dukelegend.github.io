 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
    <title>三人行-网上书店</title>
</head>
<body>
<jsp:include page="Nheader.jsp"/>
<div style="height: 3px; background-color: #ff2832;"></div>
<div class="container" style="margin-top:10px ;">
    <div class="row" style="height: 850px;">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 sort" style="width: 17.5%;height: 100%;padding: 0;">
            <div id="sort_header">
                <span>图书分类</span>
            </div>
            <ul id="sort_ul">
            <li class="sort_li">
                        <a href="NbsearchServlet?cateId=QBTS">全部图书</a>
                        <span class="sort_span">></span>
                    </li>
                <c:forEach items="${sessionScope.booktypes}" var="BookType">
                    <li class="sort_li">
                        <a href="NbsearchServlet?cateId=${BookType.typeid}">${BookType.name}</a>
                        <span class="sort_span">></span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12" style="width: 65%;height: 80%;">
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0"
                        class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="img/lunbo1.jpg" style="width: 730px;height: 360px" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo2.jpg" style="width: 730px;height: 360px" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo3.jpg" style="width: 730px;height: 360px" alt="Third slide">
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <div class="index_product_top">
                <span class="title">新书上架</span>
                <div class="div_hr"></div>
            </div>
            <div class="product_div">
                <ul class="product_ul">
                   <c:if  test = "${sessionScope.allSalesBookSize <=  6}">  
				   <c:forEach items="${sessionScope.allSalesBook}" var="SalesBook">
                       <c:forEach items="${sessionScope.allBook}" var="Book">
                       <c:if  test = "${SalesBook.ISBN eq Book.ISBN}">  
                        <li class="product_li">
                            <a href="NbookinforServlet?BISBN=${Book.ISBN}" class="img" target="_blank">
                                <img src="${Book.image}"/>
                            </a>
                            <p class="name">
                                <a href="NbookinforServlet?BISBN=${Book.ISBN}">${Book.name}</a>
                            </p>
                            <p class="sxinformation">库存:${SalesBook.rnum} | 已售:${SalesBook.snum}</p>
                            <p class="price">
                                <span class="rob">￥${SalesBook.price}</span>
                                <span class="oprice">￥${Book.price}</span>
                            </p>
                      	  </li>
                      	 </c:if>
                      	  </c:forEach>
                   		</c:forEach>
				       	</c:if>
				     <c:if  test = "${sessionScope.allSalesBookSize >  6}">  
				   		<c:forEach items="${sessionScope.allSalesBook}" begin="0" end="5" var="SalesBook">
                       <c:forEach items="${sessionScope.allBook}" var="Book">
                       <c:if  test = "${SalesBook.ISBN eq Book.ISBN}">  
                        <li class="product_li">
                            <a href="NbookinforServlet?BISBN=${Book.ISBN}" class="img" target="_blank">
                                <img src="${Book.image}"/>
                            </a>
                            <p class="name">
                                <a href="NbookinforServlet?BISBN=${Book.ISBN}">${Book.name}</a>
                            </p>
                            <p class="sxinformation">库存:${SalesBook.rnum} | 已售:${SalesBook.snum}</p>
                            <p class="price">
                                <span class="rob">￥${SalesBook.price}</span>
                                <span class="oprice">￥${Book.price}</span>
                            </p>
                      	  </li>
                      	 </c:if>
                      	  </c:forEach>
                   		</c:forEach>
				       </c:if>
                </ul>
            </div>
        </div>

        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="width: 17.5%;height: 100%; padding: 0;">
            <div class="news">
                <p class="title">最新动态</p>
                <ul>
	                 <c:forEach items="${ZXDT}" var="keyword">
	                    <li style="font-size: 18px;line-height: 25px">${keyword}</li>
	                </c:forEach>
                </ul>
            </div>
            <div class="hot_book">
                <p class="title">最近公告</p>
                <ul>
                    <c:forEach items="${ZJGG}" var="keyword">
	                    <li style="font-size: 18px;line-height: 30px">${keyword}</li>
	                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 30px;height: 500px;">
        <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12" style="width: 82.5%;padding-left: 0;">
            <div class="index_product_top">
                <span class="title">特价图书</span>
                <div class="div_hr"></div>
            </div>
            <div class="product_div">
                <ul class="product_ul">
                   	<c:forEach var="SalesBook" items="${sessionScope.lstSalesBooks}" varStatus="vs">
                       <c:forEach items="${sessionScope.allBook}" var="Book">
                       <c:if  test = "${SalesBook.ISBN eq Book.ISBN}">  
                        <li class="product_li">
                            <a href="NbookinforServlet?BISBN=${Book.ISBN}" class="img" target="_blank">
                                <img src="${Book.image}"/>
                            </a>
                            <p class="name">
                                <a href="NbookinforServlet?BISBN=${Book.ISBN}">${Book.name}</a>
                            </p>
                            <p class="sxinformation">库存:${SalesBook.rnum} | 已售:${SalesBook.snum}</p>
                            <p class="price">
                                <span class="rob">￥${SalesBook.price}</span>
                                <span class="oprice">￥${Book.price}</span>
                            </p>
                      	  </li>
                      	  </c:if>
                   		</c:forEach>
        			</c:forEach>
                </ul>
               <div id="pages">
		        <p align="right"> 当前页数:[${sessionScope.pageNum}/${sessionScope.total}]<br>
		        <a href="NMainServlet?num=1">首页</a>| 
		        <a href="NMainServlet?num=${sessionScope.pageNum-1}">上一页</a>|
		        <a href="NMainServlet?num=${sessionScope.pageNum+1}">下一页</a>|
		        <a href="NMainServlet?num=${sessionScope.total}">末页</a> 
		        </p> 
		        </div>
            </div>
        </div>
        <div class="col-lg-2 col-md-12 col-sm-12 col-xs-12" style="width: 17.5%;padding: 0;padding-top:20px ;">
            <div class="hot_book1">
                <p class="title">畅销图书</p>
                <ul>
                    <c:forEach items="${CXTS}" var="keyword">
	                    <li style="font-size: 18px;line-height: 28px">${keyword}</li>
	                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<div style="height: 3px; background-color: #ff2832; margin-top:-50px ;"></div>
<jsp:include page="Nfooter.jsp"/>
</body>
</html>