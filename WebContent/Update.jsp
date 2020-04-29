<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<style>
input[type=text] {
	width: 150px;
	height: 28px;
	color: #333;
	font-size: 14px;
	background: #fff;
	border: 1px solid #cbcbcb;
	border-radius: 5px;
}

select {
	width: 150px;
	height: 28px;
	border-radius: 5px;
}

input[type=submit] {
	width: 150px;
	height: 30px;
	background-color: #ff7f6c;
	border: none;
	border-radius: 5px;
	color: white;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #e47264;
}

h2 {
	text-align: center;
}

form {
	width: 350px;
	margin: auto;
}

table {
	width: 250px
}
span{
display: block;
width: 70px;
}
</style>
<body>
	<form action="UpdateSubmit" method="post" target="_top">
		<table cellpadding="5">
			<tr>
				<td colspan="2">
					<h2>修改信息</h2>
				</td>
			</tr>
			<tr>
				<td><span>编号:</span></td>
				<td style="width: 50px"><input type="text" name="sid"
					value="${sessionScope.UpdateStu.sid}" readonly="readonly"
					style="width: 280px"></td>
			</tr>
			<tr>
				<td><span>性别:</span></td>
				<td><c:if test="${sessionScope.UpdateStu.ssex=='男'}">
						<input type="radio" name="ssex" id="man" value="男"
							checked="checked">男
					<input type="radio" name="ssex" id="woman" value="女">女</td>
				</c:if>
				<c:if test="${sessionScope.UpdateStu.ssex=='女'}">
					<input type="radio" name="ssex" id="man" value="男">男
					<input type="radio" name="ssex" id="woman" value="女"
						checked="checked">女
				</c:if>
				</td>
			</tr>
			<tr>
				<td><span>手机号:</span></td>
				<td><input type="text" name="sphone"
					value="${sessionScope.UpdateStu.sphone}"></td>
			</tr>
			<tr>
				<td><span>专业:</span></td>
				<td><select name="smajor">
						<option value="软本">软本</option>
						<option value="动漫">动漫</option>
						<option value="电竞">电竞</option>
						<option value="网本">网本</option>
						<option value="环艺">环艺</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center" valign="middle"><input
					type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>