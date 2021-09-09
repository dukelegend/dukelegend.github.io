<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/bs.css"/>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
   
<script type="text/javascript">
$(function () {

    $("#form2").validate({

        rules: {

            password: {

                required: true,

                minlength: 5

            },

            confirm_password: {

                required: true,

                minlength: 5,

                equalTo: "#password"

            }

        },

        messages: {

            password: {

                required: "没有填写密码",

                minlength: jQuery.format("密码不能小于{0}个字符")

            },

            confirm_password: {

                required: "没有确认密码",

                minlength: "确认密码不能小于{0}个字符",

                equalTo: "两次输入密码不一致嘛"

            }

        }

    });

});
</script>
</head>
<body>
<form class="form-horizontal" role="form" id="form2" method="post" action="NewFile.jsp"
          >
        <input type="hidden" name="storeId" value="${sessionScope.loginStore.storeId}">
        <div class="form-group">
            <label for="name" class="col-sm-1 control-label">标题：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="password" name="password" >
            </div>
            <span></span>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-1 control-label">价格：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="confirm_password" name="confirm_password">
            </div>
            
        </div>
        <div class="form-group">
            <div class="col-sm-5">
                <input type="submit" class="btn btn-lg btn-default" style="margin-top: 20px;">
                     添加图书
               
            </div>
        </div>
    </form>
</body>
</html>