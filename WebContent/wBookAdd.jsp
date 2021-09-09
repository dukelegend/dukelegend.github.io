<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/layer.css">
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script src="js/layer.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#bookForm").validate({
                //一失去焦点就校验
                onfocusout: function (element) {
                    $(element).valid();
                },
                errorPlacement: function (error, element) {	//错误信息位置设置方法
                    error.appendTo(element.parent().next());//这里的error是生成的错误对象，element是录入数据的对象,parent父元素，next()下一个
                },
                errorClass: "red",
                rules: {
                	
                    name: {
                        required: true,
                        
                    },
                    isbn:{
                    	required: true,
                        rangelength:[13,13]
                    },
                    price: {
                        required: true,
                        number:true
                    },
                    size:{
                    	required: true,
                    },
                    
                    author: {
                        required: true
                    },
                    publishDate: {
                        required: true,
                        date:true
                    },
                    press: {
                        required: true
                    },
                   
                    pictureFile: {
                        required: true
                    },
                    
                },
                messages: {
                    name: {
                        required: "请输入书名",
                        
                    },
                    isbn:{
                    	required: "请输入书名",
                        rangelength:"输入错误"
                    },
                    price: {
                        required: "请输入价格",
                        number: "必须是数字"
                    },
                    size:{
                    	required: "该项不能为空",
                    },
                    author: {
                        required: "请输入作者"
                    },
                    publishDate: {
                        required: "请填写出版时间",
                        date:"时间格式不正确"
                    },
                    press: {
                        required: "请输入出版社"
                    },
                    
                    pictureFile: {
                        required:""
                    },
                   
                }
            });
        });

        function changImg(e){
            for (var i = 0; i < e.target.files.length; i++) {
                var file = e.target.files.item(i);
                if (!(/^image\/.*$/i.test(file.type))) {
                    continue; //不是图片 就跳出这一次循环
                }
                //实例化FileReader API
                var freader = new FileReader();
                freader.readAsDataURL(file);
                freader.onload = function(e) {
                    $("#myImg").attr("src",e.target.result);
                }
            }
        }
    </script>
</head>
<body>
<ol class="breadcrumb">
       <li class="active">添加图书</li>
       
    </ol>
<div class="container" style="border: 1px solid #CCCCCC;">
    <div id="searchBook" style="height:10px;border-bottom: 1px solid #CCCCCC;margin-bottom: 10px"></div>
    <form class="form-horizontal" role="form" id="bookForm" method="post" action="WBookAddServlet"
          enctype="multipart/form-data">
        
        <div class="form-group">
            <label for="name" class="col-sm-1 control-label">书名：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入书名或标题">
            </div>
            <span></span>
        </div>
        <div class="form-group">
        	<label for="isbn" class="col-sm-1 control-label">ISBN号：</label>
        	<div class="col-sm-5">
        		<input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN">
        	</div>
        	<span></span>
        </div>
        
        <div class="form-group">
            <label for="author" class="col-sm-1 control-label" style="padding-left: 0">作者：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者">
            </div>
            <span></span>
        </div>
        
        <div class="form-group">
            <label for="press" class="col-sm-1 control-label" style="padding-left: 0">出版社：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="press" name="press" placeholder="请输入出版社">
            </div>
            <span></span>
        </div>
        
        <div class="form-group">
        	<label class="col-sm-1 control-label">开本：</label>
        	<div class="col-sm-5">
        		<input type="text" class="form-control" id="size" name="size" placeholder="开本">
        	</div>
        	<span></span>
        </div>
        
        <div class="form-group">
            <label for="press" class="col-sm-1 control-label" style="padding-left: 0">出版日期：</label>
            <div class="col-sm-5">
                <input type="date" class="form-control" id="publishDate" name="publishDate" placeholder="例:2016-01-01" >
            </div>
            <span></span>
        </div>
        
        
        <div class="form-group">
            <label for="price" class="col-sm-1 control-label">原价：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格">
            </div>
            <span></span>
        </div>
       
        <div class="form-group">
            <label for="pictureFile" class="col-sm-1 control-label">图片：</label>
            <div class="col-sm-5">
                <input type="file" id="pictureFile" name="pictureFile" onchange="changImg(event)">
                图片预览:<img alt="暂无图片" id="myImg" src="" height="100px" width="100px">
            </div>
            <span></span>

        </div>
        
        <div class="form-group">
            <div class="col-sm-5">
                <button type="submit" class="btn btn-lg btn-default" style="margin-top: 20px;">
                    <span class='glyphicon glyphicon-plus'></span> 添加图书
                </button>
            </div>
        </div>
    </form>

</div>

<c:if test="${judge==-1 }">

	  <script type="text/javascript">
 	layer.open({
	    title: '错误提示',
	    content: '录入失败！',
	    icon:2,
	    btnAlign: 'c'
	}); 
 	</script>
 	</c:if>
<c:if test="${judge>0 }">
	  <script type="text/javascript">
 	layer.open({
	    
	    content: '录入成功！',
	    icon:2,
	    btnAlign: 'c'
	}); 
 	</script>
 	</c:if>
</body>
</html>