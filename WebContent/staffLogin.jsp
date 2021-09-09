<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet" href="css/layer.css">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/layer.js"></script>

</head>
<body class="boxed_wrapper">
	
    <!--   <div class="preloader"></div>-->
    
    <header class="main-header header-style-two">
        
        <div class="header-bottom">
            <div class="container clearfix">
                <figure class="logo-box"><a href="index.jsp"><img src="image/logo2.png" alt=""></a></figure>
            </div>
         </div>
    </header>

 

    <!-- Main slider -->
    <section class="main-slider slider-style-two">
        <div class="container-fluid">
            <ul>
                <li class="slider-wrapper">
                    <div class="image"><img src="image/face1.jpg" alt=""></div>
                    
                    <div class="slider-caption">
                        <div class="container">
                            <div class="content-box">
                                <div class="tp-title">三人行<br />书店后台</div>
                                <div class="text">Welcome to Three People Walk </div>
                                <div class="filter-content">
                                    <div class="title"><h3>登入</h3></div>
                                    <form action="StaffLoginServlet" method="get" class="content">
                                        <div class="single-item">
                                            <div class="form-group">
                                                <label>账号</label>
                                                <input type="text" name="count" placeholder="账号" >
                                            </div>
                                        </div>
                                        <div class="single-item">
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input type="password" name="pasw" placeholder="密码" >
                                            </div>
                                        </div>
                                        <div class="single-item">
                                           
                                        </div>
                                        <div class="single-item">
                                            <div class="form-group">
                                                <div class="link"><button type="submit" class="theme-btn">登入</button></div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>                             
                    </div>
                    <div class="slide-overlay"></div>
                </li>
            </ul>
        </div>
    </section>
    <script></script>

    <!-- main-slider end -->
 	<c:if test="${num==1 }">
	  <script type="text/javascript">
 	layer.open({
	    title: '错误提示',
	    content: '登入失败！账号或密码错误！',
	    icon:2,
	    btnAlign: 'c'
	}); 
 	</script>
 	</c:if>
</body>
</html>