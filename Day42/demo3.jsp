<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식으로 요청파라미터 보내기</title>
</head>
<body>
	<h1>GET 방식으로 요청파라미터 보내기</h1>
	
	<h3>demo3-1에 요청파라미터 값을 전달하기</h3>
	<ul>
		<li><a href="demo3-1.jsp?id=hong">홍길동</a></li>
		<li><a href="demo3-1.jsp?id=gang">강감찬</a></li>
		<li><a href="demo3-1.jsp?id=lee">이순신</a></li>
		<li><a href="demo3-1.jsp?id=kim">김유신</a></li>
		<li><a href="demo3-1.jsp?id=gwak">곽재우</a></li>
	</ul>
	
	
	<h3>demo3-2.jsp에 여러 개의 요청파라미터값을 전달해보기</h3>
	<ul>
		<li><a href="demo3-2.jsp?category=book&no=1000">이것이 자바다</a></li>
		<li><a href="demo3-2.jsp?category=book&no=1011">혼자공부하는 자바</a></li>
		<li><a href="demo3-2.jsp?category=book&no=1024">자바의 정석</a></li>
		<li><a href="demo3-2.jsp?category=gift&no=2004">열쇠고리</a></li>
		<li><a href="demo3-2.jsp?category=gift&no=2101">핸드폰 커버</a></li>
		<li><a href="demo3-2.jsp?category=movie&no=4300">스타워즈</a></li>
	</ul>
	
	
	<h3>demo3-3.jsp에 입력 폼으로 여러 개의 요청파라미터값을 전달하기</h3>
	<form action="demo3-3.jsp">
		검색옵션<br/>
		<select name="opt">
			<option value="title">제목</option>
			<option value="writer">저자</option>
			<option value="publisher">출판사</option>
			<option value="price">가격</option>
		</select><br/>
		검색어<br/>
		<input type="text" name="keyword" /> <br/>
		정렬순서<br/>
		<input type="radio" name="order" value="date" checked/> 날짜
		<input type="radio" name="order" value="price" /> 가격
		<input type="radio" name="order" value="score" /> 평점
		<input type="radio" name="order" value="review" /> 리뷰 <br/>
		목록개수<br/>
		<select name="rows">
			<option value="10">10줄</option>
			<option value="20">20줄</option>
			<option value="50">50줄</option>
		</select>
		<button type="submit">검색</button>
	</form>
	
	<p><a href="main.jsp">메인으로 돌아가기</a></p>
</body>
</html>