<%@page import="com.sample.util.CommonUtils"%>
<%@page import="com.sample.dao.ReviewDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User sessionSavedUser = (User) session.getAttribute("LOGINED_USER_INFO");

	if(sessionSavedUser == null) {
		String encodedText = URLEncoder.encode("리뷰 삭제","utf-8");
		response.sendRedirect("../user/loginform.jsp?fail=deny&job=" + encodedText);
		return;
	}
	
	int reviewNo = CommonUtils.stringToInt(request.getParameter("reviewNo"));
	int productNo = CommonUtils.stringToInt(request.getParameter("productNo"));
	ReviewDao reviewDao = ReviewDao.getInstance();
	reviewDao.deleteReview(reviewNo);
	
	response.sendRedirect("detail.jsp?no="+productNo);
%>