<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 방식으로 요청파라미터 보내기</title>
</head>
<body>

	<h1>POST 방식으로 요청파라미터값 보내기</h1>
	<h3>회원가입 정보를 demo4-1.jsp로 제출하기</h3>
	<!-- form태그 : 이름,아이디,비밀번호,성별,보유기술,근무경력,제출 -->
	<form method="post" action="demo4-1.jsp">
		이름<br/>
		<input type="text" name="username"/><br/>
		아이디<br/>
		<input type="text" name="userid"/><br/>
		비밀번호<br/>
		<input type="password" name="userpassword"/><br/>
		성별<br/>
		<input type="radio" name="gender" value="여성" checked>여성<br/>
		<input type="radio" name="gender" value="남성">남성<br/>
		보유기술<br/>
		<input type="checkbox" name="skill" value="java">자바
		<input type="checkbox" name="skill" value="db">데이터베이스
		<input type="checkbox" name="skill" value="netword">네트워크
		<input type="checkbox" name="skill" value="big-data">빅데이터
		<input type="checkbox" name="skill" value="data-science">데이터과학<br/>
		근무경력<br/>
		<select name="year">
			<option value="">--선택하세요--</option>
			<option value="1">1년</option>
			<option value="3">3년</option>
			<option value="7">7년</option>
			<option value="10">10년</option>
		</select>
		<button type="submit">제출</button>
	</form>
	
	<p><a href="main.jsp">메인으로 돌아가기</a></p>

</body>
</html>