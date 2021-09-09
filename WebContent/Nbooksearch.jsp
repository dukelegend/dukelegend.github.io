<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/book_list.css"/>
    <title>三人行-网上书店</title>
</head>
<script type="text/javascript">
		function appfapiao() {
			alert("收藏成功");
		}
</script>
<body>

<jsp:include page="Nheader.jsp"/>
<div class="container">

    <div class="search_tab">
        <ul>
            <li>所选图书</li>
        </ul>
    </div>

    <div class="crumbs">
        <div>
            <a href="NbsearchServlet?cateId=QBTS">全部</a>
            <span>&gt;</span>
            <span class="search_word">${sessionScope.bookTypeName}</span>
        </div>
        <span class="total_search_book_count">
					共<em class="red">${sessionScope.bookNum}</em>本图书
		</span>
    </div>
    <div class="search_result">
    <c:if  test = "${sessionScope.searchmethod eq 'type'}">  
        <div class="shoplist">
            <ul class="shoplist_ul">
           
				<c:forEach var="SalesBook" items="${sessionScope.SalesBooksByType}" varStatus="vs">
                       <c:forEach items="${sessionScope.allBook}" var="Book">
                       <c:if  test = "${SalesBook.ISBN eq Book.ISBN}">  
                        <li>
                            <a href="NbookinforServlet?BISBN=${Book.ISBN}" title="${Book.name}" target="_blank">
                                <img src="${Book.image}" width="200px" height="200px"/>
                            </a>
                            <p class="name">
                                <a href="NbookinforServlet?BISBN=${Book.ISBN}" title="${Book.name}" target="_blank">${Book.name}</a>
                            </p>
                            <p class="sxinformation1">库存:${SalesBook.rnum} | 已售:${SalesBook.snum}</p>
                            <p class="price">
                            <span class="search_now_price">￥ ${SalesBook.price}</span>
                            <span style="color: #C0C0C0;">定价：</span>
                            <span class="oprice">￥${Book.price}</span>
                        </p>
                        <p class="search_book_author">
                            <span>${Book.author} 著</span>
                            <span> /${Book.publishTime}</span>
                            <span>  /${Book.press}</span>
                        </p>
                        <p class="detail">
                                ${SalesBook.description}
                        </p>
                        <div class="shop_button">
                            <p class="bottom_p">
                                <a class="search_btn_cart" href="NaddcartServlet?bookId=${Book.ISBN}&buyNum=1">加入购物车</a>
                                <a class="search_btn_collect" href="javascript:void(0);" onclick ="appfapiao()">收藏</a>
                            </p>
                        </div>
                      	  </li>
                      	  </c:if>
                   		</c:forEach>
        			</c:forEach>
        			</ul>
       				 </div>
       				  <ul class="pagination pagination-lg">
         <div id="pages1">
		        <p align="right"> 当前页数:[${sessionScope.pageNum}/${sessionScope.total}]<br>
		        <a href="NbsearchServlet?num=1">首页</a>| 
		        <a href="NbsearchServlet?num=${sessionScope.pageNum-1}">上一页</a>|
		        <a href="NbsearchServlet?num=${sessionScope.pageNum+1}">下一页</a>|
		        <a href="NbsearchServlet?num=${sessionScope.total}">末页</a> 
		        </p> 
		   </div>
        </ul>
       </c:if>
        	<c:if  test = "${sessionScope.searchmethod eq 'keyword'}">  
				        <div class="shoplist">
				            <ul class="shoplist_ul">
					<c:forEach var="Sales_Book" items="${sessionScope.allBookByMHsearch}" varStatus="vs">
                        <li>
                            <a href="NbookinforServlet?BISBN=${Sales_Book.ISBN}" title="${Sales_Book.name}" target="_blank">
                                <img src="${Sales_Book.image}" width="200px" height="200px"/>
                            </a>
                            <p class="name">
                                <a href="NbookinforServlet?BISBN=${Sales_Book.ISBN}" title="${Sales_Book.name}" target="_blank">${Sales_Book.name}</a>
                            </p>
                            <p class="sxinformation1">库存:${Sales_Book.rnum} | 已售:${Sales_Book.snum}</p>
                            <p class="price">
                            <span class="search_now_price">￥ ${Sales_Book.nowprice}</span>
                            <span style="color: #C0C0C0;">定价：</span>
                            <span class="oprice">￥${Sales_Book.price}</span>
                        </p>
                        <p class="search_book_author">
                            <span>${Sales_Book.author} 著</span>
                            <span> /${Sales_Book.publishTime}</span>
                            <span>  /${Sales_Book.press}</span>
                        </p>
                        <p class="detail">
                                ${Sales_Book.description}
                        </p>
                        <div class="shop_button">
                            <p class="bottom_p">
                                <a class="search_btn_cart" href="NaddcartServlet?bookId=${bookInfo.bookId}&buyNum=1">加入购物车</a>
                                <a class="search_btn_collect" href="javascript:void(0);">收藏</a>
                            </p>
                        </div>
                      	  </li>
                   		</c:forEach>
        			 </ul>
       				 </div>
       				  <ul class="pagination pagination-lg">
         <div id="pages1">
		        <p align="right"> 当前页数:[${sessionScope.pageNum}/${sessionScope.total}]<br>
		        <a href="NMHSearchServlet?num=1">首页</a>| 
		        <a href="NMHSearchServlet?num=${sessionScope.pageNum-1}">上一页</a>|
		        <a href="NMHSearchServlet?num=${sessionScope.pageNum+1}">下一页</a>|
		        <a href="NMHSearchServlet?num=${sessionScope.total}">末页</a> 
		        </p> 
		   </div>
        </ul>
        </c:if>
        </div>
   </div>
</body>
</html>
