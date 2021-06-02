<%@page import="com.sample.dao.BoardDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sample.vo.Board"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User sessionSavedUser = (User) session.getAttribute("LOGINED_USER_INFO");

	if(sessionSavedUser == null) {
		String encodedText = URLEncoder.encode("게시판 등록하기","utf-8");
		response.sendRedirect("../user/loginform.jsp?fail=deny&job=" + encodedText);
		return;
	}
	
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	if(title.isBlank() || content.isBlank()) {
		response.sendRedirect("form.jsp?" + "fail=blank" + "&title=" + title + "&content=" + content);
		return;
	}
	
	Board board = new Board();
	
	board.setTitle(title);
	board.setContent(content);
	board.setUserId(sessionSavedUser.getId());
	
	BoardDao boardDao = BoardDao.getInstance();
	boardDao.insertBoard(board);
	
	response.sendRedirect("list.jsp");
	


%>