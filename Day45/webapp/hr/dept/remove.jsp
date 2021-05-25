<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int deptId = Integer.parseInt(request.getParameter("deptId"));

	DepartmentDao departmentDao = new DepartmentDao();
	departmentDao.deleteDepartment(deptId);
	
	response.sendRedirect("list.jsp");
%>