<%@page import="com.zrj.Entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <style>
    	a{
            color: #10315c;
            text-decoration-line: none;

    	}
        a:hover{
            color: #5c9cd5;
        }
        tr{
            border: 1px gray solid;
        }
        table{
            height: 100px;
            text-align: center;
        }
        td{
        height: 50px;
        }
        #head{
            background-color: #5c9cd5;
        }
        .row1{
            background-color: #ddebf7;
        }
        .row2{
            background-color: #ffffff;
        }
        #pag{
        	text-align: center;
        }
    </style>
</head>
<body>
    <form>
        <table border="2px" width="100%" cellpadding="10" cellspacing="0" rules="rows">
            <tr id="head">
                <td>学号</td>
                <td>学生姓名</td>
                <td>性别</td>
                <td>手机号</td>
                <td>专业</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.stu}"  var="stu">
	            <tr>
		            <td>
						<c:out value="${stu.sid}"></c:out>
		            </td>
		            <td>
						<c:out value="${stu.sname}"></c:out>
		            </td>
		            <td>
						<c:out value="${stu.ssex}"></c:out>
		            </td>
		            <td>
						<c:out value="${stu.sphone}"></c:out>
		            </td>
		            <td>
						<c:out value="${stu.smajor}"></c:out>
		            </td>
		            <td>
		         	   <a href='Update?id=${stu.sid}'>修改</a>&nbsp;&nbsp;<a href='Delete?id=${stu.sid}'>删除</a>&nbsp;&nbsp;<a href='#'>详情</a>
		            </td>
	            </tr>
            </c:forEach>
        </table>
        <p id="pag">
        <span>第${sessionScope.page}页/共${sessionScope.Allpage}页</span>
			<a href="Page?page=F">首页</a>
			<a href="Page?page=-1">上一页</a>
			<a href="Page?page=1">下一页</a>
			<a href="Page?page=L">尾页</a></p>
    </form>
</body>
</html>