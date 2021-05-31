<%@page import="com.sample.vo.Review"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.ReviewDao"%>
<%@page import="com.sample.util.CommonUtils"%>
<%@page import="com.sample.vo.Product"%>
<%@page import="com.sample.dao.ProductDao"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>상품몰</title>
 	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<%
	String navItem = "product";	

	// list.jsp에서 "detail.jsp?no=상품번호&page=페이지번호"의 형식으로 요청할 때 전달된 요청파라미터값 조회하기
	int productNo = CommonUtils.stringToInt(request.getParameter("no"));
	int pageNo = CommonUtils.stringToInt(request.getParameter("page"), 1);
	
	// SAMPLE_PRODUCTS테이블에 대한 CRUD기능이 구현된 ProductDao객체 획득하기
	ProductDao productDao = ProductDao.getInstance();
	// ProductDao객체의 getProductByNo(상품번호)를 실행해서 상품정보를 조회한다.
	Product product = productDao.getProductByNo(productNo);
%>
	<header>
		<%@ include file="../common/header.jsp" %>
	</header>
	<main>
		<div class="row mb-3"> <!-- mb-3은 아래쪽 여백을 3만큼 설정한다. -->
			<div class="col-12">
				<h3 class="border p-3 bg-light">상품 상세정보</h3>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<table class="table table-bordered table-sm">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tr>
						<th class="bg-light">상품번호</th><td><%=product.getNo() %></td>
						<th class="bg-light">등록일</th><td><%=CommonUtils.dateToString(product.getCreatedDate()) %></td>
					</tr>
					<tr>
						<th class="bg-light">제품명</th><td><%=product.getName() %></td>
						<th class="bg-light">카테고리</th><td><%=product.getCategory() %></td>
					</tr>
					<tr>
						<th class="bg-light">할인 가격</th><td><strong class="text-danger"><%=CommonUtils.numberToString(product.getDiscountPrice()) %></strong> 원</td>
						<th class="bg-light">가격</th><td><%=CommonUtils.numberToString(product.getPrice()) %> 원</td>
					</tr>
					<tr>
						<th class="bg-light">재고수량</th><td><%=CommonUtils.numberToString(product.getStock()) %> 개</td>
						<th class="bg-light">품절여부</th><td><strong class="text-primary"><%=product.getSoldOutMessage() %></strong></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- 리뷰 등록폼 시작 -->
		<div class="row mb-2">
			<div class="col-12">
				<form method="post" action="insertreview.jsp" class="border bg-light p-2">
					<input type="hidden" name="productNo" value="<%=productNo %>">
					<input type="hidden" name="page" value="<%=pageNo %>">
					<div class="form-group row">
						<div class="col-11">
							<input type="text" class="form-control" name="title" placeholder="리뷰 제목을 입력하세요"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-11">
							<textarea rows="2" class="form-control" name="content" placeholder="리뷰 내용을 입력하세요"></textarea>
						</div>
						<div class="col-1">
							<button type="submit" class="btn btn-primary">등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- 리뷰 등록폼 끝 -->
		
		<%
			ReviewDao reviewDao = ReviewDao.getInstance();
			List<Review> reviews = reviewDao.getReviewByProductNo(productNo);
		%>
		
		<!-- 리뷰 목록 시작 -->
		<div class="row">
			<div class="col-12">
				<div class="list-group">
					<!-- 리뷰 아이템 반복 시작-->
				<%
					for(Review review : reviews) {
				%>
					<li class="list-group-item">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1"><%=review.getTitle() %></h5>							
						<% 
							if(loginedUser != null) {
								if(loginedUser.getId().equals(review.getUserId())) { 
						%>
									<a href="deletereview.jsp?reviewNo=<%=review.getNo() %>&productNo=<%=product.getNo() %>" class="btn btn-outline-danger btn-sm">삭제</a>
						<%
								}
							}
						%>
						</div>
						<p><%=review.getContent() %></p>
					</li>
				<%
					}
				%>
					<!-- 리뷰 아이템 반복 끝 -->

				</div>
			</div>
		</div>
		<!-- 리뷰목록 끝 -->
	</main>
</div>
</body>
</html>