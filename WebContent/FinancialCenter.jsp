<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FinancialCenter</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta name = "viewport" content ="width=device-width, initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js" > </script>

<script type="text/javascript">
//自定义校验电话号码
$.validator.addMethod("isPhone", function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
   });


$(function(){
	$("#myform").validate({
		rules:{
			"id":{
				"required":true,
				"number":true,
				"rangelength":[8,8]
			},
			"name":{
				"required":true,
				"rangelength":[2,18]
			},
			"nickname":{
				"required":true,
				"rangelength":[2,18]
			},
			"phonenum":{
				"required":true,
				"number":true,
				"isPhone":true,
				"rangelength":[11,11]
			},
			"email":{
				"required":true,
				"email":true
			},
			"address":{
				"required":true
				
			},
			"password":{
				"required":true,
				"minlength":6
			}
		},
		messages:{
			"id":{
				"required":"id不能为空",
				"number":"id为数字",
				"rangelength":"请输入8位的id"
			},
			"name":{
				"required":"姓名不能位空",
				"rangelength":"名字长度位2-18个字符串"
			},
			"nickname":{
				"required":"昵称不能位空",
				"rangelength":"昵称长度位2-18个字符串"
			},
			"phonenum":{
				"required":"电话号码不能为空",
				"number":"电话号码为数字",
				"isPhone":"请输入正确的电话号码",
				"rangelength":"电话号码长度为11位"
				
			},
			"email":{
				"required":"邮箱不能为空",
				"email":"请输入正确的邮箱"
			},
			"address":{
				"required":"地址不能为空",
			},
			"password":{
				"required":"密码不能为空",
				"minlength":"密码长度至少为6位"
			}
		}
	});

	
});

function ok(){
	alert("保存成功！");
}
</script>
</head>
<body>
	<div class="col-sm-10">
                    <ol class="breadcrumb">
                        <li class="active">菜单
                        </li>
                        <li class="active">个人中心
                        </li>
                    </ol>
	
	<div class="container">
	
	<div>
	<form action="UpdateShopOwnerServlet" method="post" id="myform">
		<ul class="list-group">
  			<li class="list-group-item">
  			<label for="name">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${id}">
            </li>
			<li class="list-group-item">
  			<label for="name">名字</label>
            <input type="text" class="form-control" id="name" name="name" value="${name}">
            </li>
            <li class="list-group-item">
  			<label for="name">昵称</label>
            <input type="text" class="form-control" id="nickname" name="nickname" value="${nickname}">
            </li>
            <li class="list-group-item">
            <label for="name">性别</label>
  			<select class="form-control" name="sex">
      		<option>男</option>
      		<option>女</option>
      		</select>
        	</li>
            <li class="list-group-item">
  			<label for="name">电话</label>
            <input type="text" class="form-control" id="phonenum" name="phonenum" value="${phonenum}">
            </li>
            <li class="list-group-item">
  			<label for="name">邮箱</label>
            <input type="text" class="form-control" id="email" name="email" value="${email}">
            </li>
            <li class="list-group-item">
  			<label for="name">地址</label>
            <input type="text" class="form-control" id="address" name="address" value="${address}">
            </li>
            <li class="list-group-item">
  			<label for="name">密码</label>
            <input type="password" class="form-control" id="password" name="password" value="${password}">
            </li>
            <li class="list-group-item">
  			<button type="submit" class="btn btn-primary" onclick="ok()">保存</button>
            </li>
		</ul>
		</form>
	</div>
	</div>
	</div>
</body>
</html>