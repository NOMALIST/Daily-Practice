<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="com.sample.hr.vo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 새 사원정보 등록하기
	/*
		1. form.jsp가 add.jsp로 제출하는 모든 요청파라미터값을 요청객체에서 가져온다.
			요청파라미터명 - firstName, lastName, email, phoneNumber, jobId, departmentId,
			salary, commissionPct, managerId 입니다.
			* commissionPct는 form.jsp에서 commission_pct로 설정했는데, commissionPct로 변경해주세요
		2. Employee객체를 생성해서 1번에서 조회한 모든 신규 사원정보를 저장한다.
		3. com.sample.hr.dao.EmployeeDao에 신규 사원정보를 저장하는 
			public void insertEmployee(Employee employee) throws SQLException {
	
			}를 정의한다.
			* 사원아이디와 입사일는 각각 employees_seq 시퀀스와 sysdate로 값이 추가되도록 SQL을 작성한다.
		4. emp/add.jsp에서 EmployeeeDao객체를 생성한다.
		5. EmployeeDao객체의 insertEmployee(employee객체)를 실행해서 새 사원정보를 데이터베이스에 추가한다.
		6. 응답객체의 sendRedirect(재요청할 URL)을 실행해서 list.jsp를 재요청하게 하는 응답을 브라우저에게 보낸다.
	*/
%>
<%
	Employee emp = new Employee();

	emp.setFirstName(request.getParameter("firstName"));
	emp.setLastName(request.getParameter("lastName"));
	emp.setPhoneNumber(request.getParameter("phoneNumber"));
	emp.setEmail(request.getParameter("email"));
	emp.setJobId(request.getParameter("jobId"));
	String deptId = request.getParameter("departmentId");
	emp.setDepartmentId(Integer.parseInt(deptId));
	String salary = request.getParameter("salary");
	emp.setSalary(Double.parseDouble(salary));
	String commissionPct = request.getParameter("commissionPct");
	emp.setCommissionPct(Double.parseDouble(commissionPct));
	String managerId = request.getParameter("managerId"); 
	emp.setManagerId(Integer.parseInt(managerId));
	
	EmployeeDao empDao = new EmployeeDao();
	empDao.insertEmployee(emp);
	
	response.sendRedirect("list.jsp");
	
%>
