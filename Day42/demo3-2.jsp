<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터값 조회하기</title>
</head>
<body>
	<h1>요청 파라미터 값 조회</h1>
	
	<h3>요청 파라미터값 조회하기</h3>
	<%
		String category = request.getParameter("category");
		String no = request.getParameter("no");
	%>
	<p>카테고리: <%=category %></p> 
	<p>상품번호: <%=no %></p>


	<p><a href="demo3.jsp">demo3으로 돌아가기</a></p>
</body>
</html>