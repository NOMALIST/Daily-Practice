<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청객체 연습</title>
</head>
<body>
	<h1>요청 객체가 제공하는 메소드를 이용해서 클라이언트 정보 조회하기</h1>
	
	<h3>클라이언트 정보</h3>
	<!--  요청객체가 제공하는 메소드를 이용해서 클라이언트 정보 조회하기 -->
	<%
		String ip = request.getRemoteAddr();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String host = request.getServerName();
		int port = request.getServerPort();
		String context = request.getContextPath();
	%>
	<dl>
		<dt>클라이언트의 ip주소</dt><dd><%=ip %></dd>
		<dt>요청방식</dt><dd><%=method %></dd>
		<dt>요청URI</dt><dd><%=uri %></dd>
		<dt>서버의 호스트명</dt><dd><%=host %></dd>
		<dt>서버가 사용하는 포트번호</dt><dd><%=port %></dd>
		<dt>서버의 컨텍스트 경로</dt><dd><%=context %></dd>
	</dl>
	
	<p><a href="main.jsp">메인으로 돌아가기</a></p>
</body>
</html>