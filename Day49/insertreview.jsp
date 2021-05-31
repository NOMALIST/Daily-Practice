<%@page import="com.sample.dao.ReviewDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sample.vo.User"%>
<%@page import="com.sample.vo.Review"%>
<%@page import="com.sample.util.CommonUtils"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	
	User sessionSavedUser = (User) session.getAttribute("LOGINED_USER_INFO");

	// 로그인 안되어 있으면 오류 발생
	if(sessionSavedUser == null) {
		String encodedText = URLEncoder.encode("리뷰등록","utf-8");
		response.sendRedirect("../user/loginform.jsp?fail=deny&job=" + encodedText);
		return;
	}
	String userId = sessionSavedUser.getId();
	
	int pageNo = CommonUtils.stringToInt( request.getParameter("page"));
	int productNo = CommonUtils.stringToInt( request.getParameter("productNo"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	Review review = new Review();
	review.setTitle(title);
	review.setContent(content);
	review.setProductNo(productNo);
	review.setUserId(userId);
	
	ReviewDao reviewDao = ReviewDao.getInstance();
	reviewDao.insertReview(review);
	
	
	response.sendRedirect("detail.jsp?no=" + productNo);

%>