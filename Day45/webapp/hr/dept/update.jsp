<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@page import="com.sample.hr.vo.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 요청파라미터값 조회하기 <--  수정폼에서 입력하거나 선택한 값    
	int deptId = Integer.parseInt(request.getParameter("deptId"));
	String deptName = request.getParameter("deptName");
	int managerId = Integer.parseInt(request.getParameter("managerId"));
	int locationId = Integer.parseInt(request.getParameter("locationId"));
	
	// 변경된 부서정보를 Deartment객체에 답는다.
	Department dept = new Department();
	dept.setId(deptId);
	dept.setName(deptName);
	dept.setManagerId(managerId);
	dept.setLocationId(locationId);
	
	// DEPARTMENTS 테이블에 대한 CRUD작업을 지원하는 departmentDao 객체 생성하기
	DepartmentDao dao = new DepartmentDao();
	dao.updateDepartment(dept);
	
	// 브라우저에게 재요청할 URL을 응답으로 보내기
	response.sendRedirect("list.jsp");
%>