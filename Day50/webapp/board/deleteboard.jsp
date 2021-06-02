<%@page import="com.sample.vo.Board"%>
<%@page import="com.sample.util.CommonUtils"%>
<%@page import="com.sample.dao.BoardDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User sessionSavedUser = (User) session.getAttribute("LOGINED_USER_INFO");
	
	if(sessionSavedUser == null) {
		String encodedText = URLEncoder.encode("게시글 삭제하기","utf-8");
		response.sendRedirect("../user/loginform.jsp?fail=deny&job=" + encodedText);
		return;
	}
	
	int boardNo = CommonUtils.stringToInt(request.getParameter("no") );
	int pageNo = CommonUtils.stringToInt(request.getParameter("page") );

	BoardDao boardDao = BoardDao.getInstance();
	Board board = boardDao.getBoardByNo(boardNo);
	
	if(!sessionSavedUser.getId().equals(board.getUserId())) {
		response.sendRedirect("list.jsp?page=" + pageNo);
		return;
	}
	
	boardDao.deleteBoardByNo(boardNo);
	
	response.sendRedirect("list.jsp?page=" + pageNo);
%>