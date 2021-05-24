<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="com.sample.hr.dto.DepartmentDto"%>
<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리</title>
</head>
<body>
	<h1>부서 상세 정보</h1>
	<p>
		부서의 기본정보를 표시하고, 그 부서에 소속된 사원 목록을 조회한다.
	</p>
	
	<%
		// http://localhost/sample/dept/depatil.jsp?deptId=10
		// 요청 객체에서 요청파라미터 값 조회하기
		int departmentId = Integer.parseInt(request.getParameter("deptId"));	// "10" -> 10
		
		DepartmentDao departmentDao = new DepartmentDao();
		DepartmentDto dto = departmentDao.getDepartmentDto(departmentId);
		
	%>
	
	<h3>부서 기본 정보</h3>
	<dl>
		<dt>부서아이디</dt><dd><%=departmentId %></dd>
		<dt>부서이름</dt><dd><%=dto.getName() %></dd>
		<dt>부서관리자 아이디</dt><dd><%=dto.getManagerId() == 0 ? "없음" : dto.getManagerId() %></dd>
		<dt>부서관리자 이름</dt><dd><%=dto.getManagerName() == null ? "없음" : dto.getManagerName() %></dd>
		<dt>부서소재지 아이디</dt><dd><%=dto.getLocationId() %></dd>
		<dt>부서소재지 도시명</dt><dd><%=dto.getCity() %></dd>
		<dt>부서에 소속된 사원수</dt><dd><%=dto.getEmpCount() %></dd>
	</dl>
	
	<%
		// EMPLOYEES 테이블에 대한 CRUD 기능을 제공하는 EmployeeDao객체 생성	
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.getEmployeesByDepartmentId(departmentId);
	%>
	
	<p>
		<a href="modifyform.jsp?deptId=<%=departmentId%>"><strong>부서정보 수정</strong></a>
		<%
			if(dto.getEmpCount() == 0) {
		%>
		<a href="remove.jsp?deptId=<%=departmentId%>"><strong>부서정보 삭제</strong></a>
		<%
			}
		%>
	</p>
	
	
	
	<h3>소속 사원 정보</h3>
	<table border="1" style="width:80%">
		<thead>
			<tr>
				<th>사원이름</th>
				<th>직종아이디</th>
				<th>입사일</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<%
				if(employees.isEmpty()) {	// 소속된 사원이 없을 경우
			%>
				<tr>
					<td colspan="5">소속된 사원이 존재하지 않습니다.</td>
				</tr>
			<%
				} else {
			
					for(Employee emp : employees) {
			%>
					<tr>
						<td><%=emp.getFirstName() + " " + emp.getLastName()%></td>
						<td><%=emp.getDepartmentId() %></td>
						<td><%=emp.getHireDate() %></td>
						<td><%=emp.getPhoneNumber() %></td>
						<td><%=emp.getEmail() %></td>
					</tr>
			<%
					}
				} 
			%>

		</tbody>
	</table>
	

	
	<p><a href="list.jsp">목록화면으로 되돌아가기</a></p>
</body>
</html>