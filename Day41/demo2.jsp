<%@page import="com.sample.vo.Sample"%>
<%@page import="com.sample.dao.SampleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP연습2</title>
</head>
<body>
	<h1>JSP 연습2</h1>
	<%
		SampleDao sampleDao = new SampleDao();
		Sample sample = sampleDao.getSample();
	%>
	
	<h3>상품정보</h3>
	<table border="1", style="width:90%">
		<tr>
			<th>상품번호</th><td><%=sample.getNo() %></td>
			<th>상품이름</th><td><%=sample.getName() %></td>
		</tr>
		<tr>
			<th>제 조 사</th><td><%=sample.getCompany() %></td>
			<th>상품가격</th><td><%=sample.getPrice() %></td>
		</tr>
		<tr>
			<th>상품재고</th><td><%=sample.getStock() %></td>
			<th>등록일자</th><td><%=sample.getCreatedDate() %></td>
		</tr>
	</table>
	
</body>
</html>