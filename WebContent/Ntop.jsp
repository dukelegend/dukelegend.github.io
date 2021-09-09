<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <link rel="shortcut icon" href="img/java.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>三人行-网上书店</title>
</head>
<body>
<div id="header">
    <div id="header_inner">
        <ul id="header_ul">
            <li class="header_li">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle mybtn"
                                data-toggle="dropdown">
                            我的信息<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                          <c:if test="${sessionScope.loginUser == null}">
              	 				<li> <a  href ="javascript:void(0);" id="login_butt1">去登录</a></li>
                            	 <li><a>注册会员</a></li>
                             	 <li><a href ="javascript:void(0);" id="butt1">免费注册</a></li>
                           		 <li class="divider"></li>
                           		 <li><a href="staffLogin.jsp">后台管理</a></li>
                		</c:if>
                		<c:if test="${sessionScope.loginUser != null}">
                				 <li><a  href ="javascript:void(0);" id="cin">个人信息</a></li>
                             	<li><a>注册会员</a></li>
                             	 <li><a href="LoginOutServlet">注销</a></li>
                           	 	<li class="divider"></li>
                            	<li><a href="staffLogin.jsp">后台管理</a></li>
                		</c:if>
                        </ul>
                    </div>
            </li>
            <li class="header_li">
               <c:if test="${sessionScope.loginUser == null}">
               <a href ="javascript:void(0);" id="butt">免费注册</a>
                </c:if>
            </li>
            <li class="header_li">
                <c:if test="${sessionScope.loginUser == null}">
              	   <a  href ="javascript:void(0);" id="login_butt">请登录</a>
                </c:if>
            </li>
            <li class="header_li">
                <c:if test="${sessionScope.loginUser != null }">
                    欢迎您<a href ="javascript:void(0);" id="alert_butt">  ${sessionScope.loginUser.nickname}</a>
                </c:if>
            </li>

            <li class="header_li">
                欢迎来到三人行书城 | <a href="NMainServlet">首页</a>
            </li>

        </ul>
    </div>
</div>
<div style="display: none;" id="gb">
           <form class="layui-form layui-form-pane" id="update-form" lay-filter="update-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="nickname" required lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="pwd" placeholder="请输入密码" autocomplete="off" class="layui-input" id="pass1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="passwords" required lay-verify="pwd" placeholder="请再次输入密码" autocomplete="off" class="layui-input" id="pass2">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电话号码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone" required lay-verify="phones" value="${sessionScope.loginUser.phonenum}" autocomplete="off" class="layui-input">
                    </div>
                </div>
              
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" required lay-verify="truename" placeholder="请输入您的姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-inline">
                       <input type="radio" name="sex" value="男" title="男" checked>
 						 <input type="radio" name="sex" value="女" title="女">
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-inline">
                        <input type="email" name="email" required lay-verify="emails" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                         <button class="layui-btn" lay-submit lay-filter="update-form-submit">获取验证码</button>
                     </div>
                    
                </div>
                 <div class="layui-form-item">
                    <label class="layui-form-label">验证码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="nums"  placeholder="请输入验证码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="update-form-submit2">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

        </div>
        <div style="display: none;" id="login">
           <form method="get" class="layui-form layui-form-pane" id="login_form" lay-filter="login_form">
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="account" required lay-verify="required" placeholder="账号/邮箱" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="passw" required lay-verify="pwsd" placeholder="密码" autocomplete="off" class="layui-input" id="passw">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button  type="button" onclick="loginForm()" class="btn btn-primary">登录</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <div style="display: none;" id="cinfor">
           <form class="layui-form layui-form-pane" id="cinfor-form" lay-filter="cinfor-form">
           <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-inline">
                        <input type="text" readonly  unselectable="on" name="account" required lay-verify="acc" value="${sessionScope.loginUser.id}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="nickname1" required lay-verify="required1" value="${sessionScope.loginUser.nickname}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="password1" required lay-verify="pwd1" value="${sessionScope.loginUser.password}" autocomplete="off" class="layui-input" id="pass3">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="passwords1" required lay-verify="pwd1" placeholder="修改时请再次输入密码" autocomplete="off" class="layui-input" id="pass4">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电话号码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone1" required lay-verify="phones1" value="${sessionScope.loginUser.phonenum}" autocomplete="off" class="layui-input">
                    </div>
                </div>
              
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name1" required lay-verify="truename1" value="${sessionScope.loginUser.name}" autocomplete="off" class="layui-input">
                    </div>
                </div>
               <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-inline">
                     <c:if test="${sessionScope.loginUser.sex == '男'}">
		                   <input type="radio" name="sex1" value="男" title="男" checked>
 						  <input type="radio" name="sex1" value="女" title="女">
		              </c:if>
                       <c:if test="${sessionScope.loginUser.sex == '女'}">
		                   <input type="radio" name="sex1" value="男" title="男">
 						  <input type="radio" name="sex1" value="女" title="女" checked>
		              </c:if>
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-inline">
                        <input type="email" name="email1" required lay-verify="emails1" value="${sessionScope.loginUser.email}" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                         <button class="layui-btn" lay-submit lay-filter="cinfor-form-submit3">修改时获取验证码</button>
                     </div>
                    
                </div>
                 <div class="layui-form-item">
                    <label class="layui-form-label">验证码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="nums"  placeholder="请输入验证码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="cinfor-form-submit4">保存</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
</body>
<script type="text/javascript">
//登录信息提交
function loginForm() {
	var form = document.getElementById("login_form");
 	form.action="LoginServlet";
 	form.submit();
   }
layui.use(['layer', 'table','element', 'form', 'layedit'], function() {
    var layer = layui.layer;
    var form = layui.form;
    var table=layui.table;
    var element = layui.element;
    var layedit = layui.layedit;
    var $ = layui.$
    $(function() {
        $("#butt,#butt1").click(function() {
            layer.open({
                type: 1,
                title: "注册页面",
                area: ['550px', '600px'],
                offset: '20px',
                content: $("#gb"),
                success: function() {
                    form.on('submit(formDemo)', function(data) {

                    });
                }
            })
            form.render();
        })
			$("#login_butt,#login_butt1").click(function() {
            layer.open({
                type: 1,
                title: "登录页面",
                area: ['400px', '300px'],
                offset: '20px',
                content: $("#login"),
                success: function() {
                    form.on('submit(formDemo)', function(data) {

                    });
                }
            })
            form.render();
        })
        $("#alert_butt,#cin").click(function() {
            layer.open({
                type: 1,
                title: "个人信息页面",
                area: ['550px', '600px'],
                offset: '20px',
                content: $("#cinfor"),
                success: function() {
                    form.on('submit(formDemo)', function(data) {

                    });
                }
            })
            form.render();
        })
        //验证输入的密码是否相同；
        $("#pass2").blur(function() {
            var pass1 = $("#pass1").val();
            var pass2 = $("#pass2").val();
            if(pass1 != pass2) {
                layer.msg("两次输入的密码不一致", {
                    "icon": 2,
                    "time": 2000
                });
                $("#pass2").val("");
                return false;
            }
            return true;
        });
        //验证输入的密码是否相同；
        $("#pass4").blur(function() {
            var pass3 = $("#pass3").val();
            var pass4 = $("#pass4").val();
            if(pass3 != pass4) {
                layer.msg("两次输入的密码不一致", {
                    "icon": 2,
                    "time": 2000
                });
                $("#pass4").val("");
                return false;
            }
            return true;
        });
    });
  
    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');
    //自定义验证规则
    form.verify({
        emails: [
            /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'
        ],
        phones: [
            /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'
        ],
        truename: [
            /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'
        ],
        emails1: [
            /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'
        ],
        phones1: [
            /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'
        ],
        truename1: [
            /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'
        ],
        content: function(value) {
            layedit.sync(editIndex);
        }
    });
    
  //邮箱验证码申请
	  form.on('submit(update-form-submit)', function() {
		  $.ajax({
			  cache:true,
			  url:'/BookStore/GetMial',
			  type: "POST",
			  data:$('#update-form').serialize(),// 你的formid
			  async: false,
              success:function(){
            	  layer.msg('验证码发送成功！', {icon: 1});
            	
              },
              error: function() {
            	  layer.msg('验证码发送失败！', {icon: 2});
            	  
                }
		  });
		  return false; //阻止表单提交
	  });
	  
//注册信息提交
 form.on('submit(update-form-submit2)', function() {
	  $.ajax({
		  cache:true,
		  url:'/BookStore/RegisterServlet',
		  type: "POST",
		  data:$('#update-form').serialize(),// 你的formid
		  async: false,
          success:function(){
        	  //layer.msg('注册信息提交成功！', {icon: 1});
        	
          },
          error: function() {
        	 // layer.msg('注册信息提交失败！', {icon: 2});
        	  
         }
	  });
	  return false; //阻止表单提交
  });
//邮箱验证码申请
 form.on('submit(cinfor-form-submit3)', function() {
	  $.ajax({
		  cache:true,
		  url:'/BookStore/GetMial',
		  type: "POST",
		  data:$('#cinfor-form').serialize(),// 你的formid
		  async: false,
         success:function(){
       	  layer.msg('验证码发送成功！', {icon: 1});
       	
         },
         error: function() {
       	  layer.msg('验证码发送失败！', {icon: 2});
       	  
           }
	  });
	  return false; //阻止表单提交
 });
//修改信息提交
 form.on('submit(cinfor-form-submit4)', function() {
	  $.ajax({
		  cache:true,
		  url:'/BookStore/UpdateCinforServlet',
		  type: "POST",
		  data:$('#cinfor-form').serialize(),// 你的formid
		  async: false,
          success:function(){
        	  //layer.msg('修改信息提交成功！', {icon: 1});
        	
          },
          error: function() {
        	 // layer.msg('修改信息提交失败！', {icon: 2});
        	  
         }
	  });
	  return false; //阻止表单提交
  });
    
});
</script>
</html>
