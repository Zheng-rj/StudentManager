<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <style>
	    *{
	        margin: 0;
	        padding: 0;
	        }
	   #itop{
            width: 99.5%;
            height: 90px;
        }
       #ibottom{
           width: 99.5%;
           height: 600px;
       }
       #bottom{
           height: 600px;
       }
    </style>
    <body>
        <div id="top">
            <iframe src="Top.jsp" id="itop"></iframe>
        </div>
        <div id="bottom">
            <iframe src="Bottom.jsp" id="ibottom"></iframe>
        </div>

    </body>
</html>