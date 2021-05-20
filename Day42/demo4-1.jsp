<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터값 조회하기</title>
</head>
<body>
	<h1>요청 파라미터값 조회하기</h1>
	
	<h3>POST 방식으로 전달된 파라미터값 조회하기</h3>
	<%
		String name = request.getParameter("username");
		String id = request.getParameter("userid");
		String password = request.getParameter("userpassword");
		String gender = request.getParameter("gender");
		String[] skills = request.getParameterValues("skill");
		String year = request.getParameter("year");
	%>
	
	<dl>
		<dt>이름</dt><dd><%=name %></dd>
		<dt>아이디</dt><dd><%=id %></dd>
		<dt>비밀번호</dt><dd><%=password %></dd>
		<dt>성별</dt><dd><%=gender %></dd>
		<dt>보유기술</dt><dd>
		<%
		for(String skill : skills) {
		%>
		<%=skill %>
		<%
		}
		%>
		</dd>
		<dt>근무년수</dt><dd><%=year %></dd>
	</dl>
	
	<p><a href="demo4.jsp">demo4로 돌아가기</a></p>
</body>
</html>