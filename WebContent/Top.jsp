<%@page import="com.zrj.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration-line: none;
}

body {
	background-image: url('../img/background.jpg');
	background-size: cover;
	"
}

#top {
	width: 100%;
	height: 90px;
	background-color: rgba(57, 64, 173, 0.9);
}

#top>span {
	color: white;
	font-size: 35px;
	font-family: 黑体;
	height: 90px;
	line-height: 90px;
	margin-left: 20px;
	float: left;
}

#right {
	float: right;
	margin-right: 100px
}

#img {
	height: 60px;
	width: 60px;
	margin: 15px 0 15px 0;
	border-radius: 50%;
	float: left;
	margin-right: 20px;
}

#img>img {
	width: 60px;
	height: 60px;
	border-radius: 50%;
}

#thing {
	height: 60px;
	margin: 15px 0 15px 0;
	float: left;
}

#name {
	color: white;
	font-size: 22px
}

#exit {
	color: #DF0000;
	clear: both;
}
</style>
<script>
	function HeadImage() {
		document.getElementById("file").click();
	}
	//页面加载为 img添加事件,用于图片预览
	$(function() {
		$(":input[type='file']").change(function() {
			var readFile = new FileReader();
			var mfile = $(":input[type='file']")[0].files[0]; //注意这里必须时$("#myfile")[0]，document.getElementById('file')等价与$("#myfile")[0]
			var f = $(":input[type='file']").val();
			//判断长传文件的后缀名 是否是一张符合格式的图片
			if (!/\.(jpg|jpeg|png|JPG|PNG)$/.test(f)) {
				alert("图片类型必须是jpeg,jpg,png中的一种")
				return false;
			}
			readFile.readAsDataURL(mfile);
			readFile.onload = function() {
				var img = $(".img");
				//img.attr("width","48px");
				//img.attr("height","48px");
				//img.attr("border-radius","24px");
				img.attr("src", this.result);
			}
		});
	});
</script>
<body>
	<div id="top">
		<span>学生信息管理系统</span>
		<div id="right">
			<div id="img">
				<img src="${sessionScope.user.uimg}">
			</div>
			<div id="thing">
				<p id="name">${sessionScope.user.uname}</p>
				<a href="Login.html" id="exit" target="_top">注销</a>
			</div>
		</div>
	</div>
</body>
</html>