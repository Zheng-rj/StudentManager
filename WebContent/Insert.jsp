<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<style>
    input[type=text]{
        width: 150px;
        height: 28px;
        color: #333;
        font-size: 14px;
        background: #fff;
        border: 1px solid #cbcbcb;
        border-radius: 5px;
    }
    select{
        width: 150px;
        height: 28px;
        border-radius: 5px;
    }
    input[type=submit]{
        width: 150px;
        height: 30px;
        background-color: #ff7f6c;
        border: none;
        border-radius: 5px;
        color: white;
        cursor: pointer;
    }
    input[type=submit]:hover{
        background-color: #e47264;
    }
    #main{
    	height: 800px;
    	margin: auto;
    }
    form{
    	width: 250px;
    	margin: auto;
    }
    table{
    	width: 250px
    }
    h2{
    	text-align: center;
    }
</style>
<body>
		<form action="Insert">
			<table cellpadding="5">
			<tr>
			<td colspan="2"><h2>新增学生</h2></td>
			</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="sname"></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input type="radio" name="ssex" value="男">男 <input
						type="radio" name="ssex" value="女">女</td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td><input type="text" name="sphone"></td>
				</tr>
				<tr>
					<td>专业:</td>
					<td>
						<select name="smajor">
							<option value="软本">软本</option>
							<option value="动漫">动漫</option>
							<option value="电竞">电竞</option>
							<option value="网本">网本</option>
							<option value="环艺">环艺</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" valign="middle"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
</body>
</html>