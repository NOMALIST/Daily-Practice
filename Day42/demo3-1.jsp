<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 값 조회</title>
</head>
<body>

	<h1>요청 파라미터 값 조회</h1>
	
	<h3>요청 파라미터값 조회하기</h3>
	<%
		String value = request.getParameter("id");
	%>
	<p>요청파라미터명: id</p> 
	<p>요청파라미터값: <%=value %></p>


	<p><a href="demo3.jsp">demo3으로 돌아가기</a></p>
</body>
</html>