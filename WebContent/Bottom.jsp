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
    #ileft{
        width: 14.3%;
        height: 590px;
        float: left;
    }
    #iright{
        width: 85%;
        height: 590px;
    }
</style>
	<body>
    <div>
        <div id="left">
            <iframe src="Left.jsp" id="ileft"></iframe>
        </div>
        <div id="right">
            <iframe src="Right.jsp?page=1" id="iright" name="right"></iframe>
        </div>
    </div>
	</body>
</html>