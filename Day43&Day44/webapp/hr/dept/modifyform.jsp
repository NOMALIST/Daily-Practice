<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.vo.Location"%>
<%@page import="com.sample.hr.dao.LocationDao"%>
<%@page import="com.sample.hr.vo.Department"%>
<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리::부서관리</title>
</head>
<body>

	<h1>부서정보 수정</h1>
	<%
		// 요청객체에서 요청파라미터 값 조회하기
		int deptId = Integer.parseInt(request.getParameter("deptId"));
	
		// 요청파라미터로 전달받은 부서아이디에 해당하는 부서정보 조회하기
		DepartmentDao deptDao = new DepartmentDao();
		Department department = deptDao.getDepartmentById(deptId);
		
		// 요청파라미터로 전달받은 부서아이디에 해당하는 부서에 근무중인 모든 사원 조회하기
		EmployeeDao empDao = new EmployeeDao();
		List<Employee> employees = empDao.getEmployeesByDepartmentId(deptId);
		
		// 모든 소재지 정보 조회하기
		LocationDao locDao = new LocationDao();
		List<Location> locations = locDao.getAllLocations();
	%>
	<h3>부서정보 수정 폼</h3>
	<form action="update.jsp">
		<input type="hidden" name="deptId" value="<%=department.getId() %>"/>
		<label>부서이름</label><br/>
		<input type="text" name="deptName" value="<%=department.getName() %>"/><br/>
		<label>부서관리자</label><br/>
		<select name="managerId">
		<%
			for(Employee employee : employees) {
		%>
			<option value="<%=employee.getId()%>" <%= department.getManagerId() == employee.getId() ? "selected" : "" %>> <%=employee.getFirstName() %></option>
		<%
			}
		%>
		</select><br/>
		<label>부서소재지</label><br/>
		<select name="locationId">
		<%
			for(Location item : locations) {
		%>
			<option value="<%=item.getId() %>" <%=department.getLocationId() == item.getId() ? "selected" : "" %> ><%=item.getCity() %></option>
		<%
			}
		%>

		</select><br/><br/>
		<button type="submit">정보수정</button>
	</form>
	
	<br/>
	<p><a href="detail.jsp?deptId=<%=deptId%>">부서상세화면으로 되돌아가기</a></p>
</body>
</html>