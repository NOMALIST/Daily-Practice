<%@page import="com.sample.vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.util.CommonUtils"%>

<%@page import="com.sample.dao.BoardDao"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>상품몰 :: 고객게시판</title>
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
	String navItem = "board";

	final int ROW = 5;
	
	BoardDao boardDao = BoardDao.getInstance();
	
	int totalRow = boardDao.getBoardRowsCount();
	int totalPage = (int)Math.ceil((double)totalRow/ROW);
	
	int pageNo = CommonUtils.stringToInt( request.getParameter("page"),1);
	if(pageNo < 1 || pageNo > totalPage) pageNo = 1;
	int beginIndex = (pageNo-1) * ROW + 1;
	int endIndex = pageNo * ROW;
	
	List<Board> boards = boardDao.getBoards(beginIndex, endIndex);
%>
	<header>
		<%@ include file="../common/header.jsp" %>
	</header>
	<main>
		<div class="row mb-3">
			<div class="col-12">
				<h3 class="border p-3 bg-light">
					게시글 목록
				<%
					if(loginedUser != null) {
				%>
					<a href="form.jsp" class="btn btn-primary float-right">게시글 추가</a>
				<%
					}
				%>
				</h3>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<div class="card">
					<div class="card-body pb-0">
						<table class="table">
							<colgroup>
								<col width="10%" />
								<col width="*" />
								<col width="15%" />
								<col width="10%" />
								<col width="12%" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>조회수</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>
						<%
							for(Board board : boards) {
						%>
								<tr>
									<td><%=board.getNo() %></td>
									<td><a href="detail.jsp?no=<%=board.getNo() %>&page=<%=pageNo%>"><%=board.getTitle() %></a></td>
									<td><%=board.getUserId() %></td>
									<td><%=board.getViewCount() %></td>
									<td><%=CommonUtils.dateToString( board.getCreatedDate() )%></td>
								</tr>
						<%
							}
						%>

							</tbody>
						</table>
					</div>
					<div class="card-body">
						<nav>
	  						<ul class="pagination justify-content-center">
	    						<li class="page-item <%=(pageNo==1) ? "disabled" : "" %>"><a class="page-link" href="list.jsp?page=<%=pageNo-1 %>">이전</a></li>
	    					<%
	    						for(int i=1; i<=totalPage; i++) {
	    					%>
	    							<li class="page-item <%= (i == pageNo) ? "active" : "" %>"><a class="page-link" href="list.jsp?page=<%=i %>"><%=i %></a></li>
	    					<%
	    						}
	    					%>
	    						<li class="page-item <%=(pageNo==totalPage) ? "disabled" : "" %>"><a class="page-link" href="list.jsp?page=<%=pageNo+1 %>">다음</a></li>
	  						</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>
</body>
</html>