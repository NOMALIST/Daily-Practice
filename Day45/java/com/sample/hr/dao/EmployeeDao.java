package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.dto.EmployeeDto;
import com.sample.hr.vo.Employee;
import com.sample.utils.ConnectionUtil;

public class EmployeeDao {
	
	public void insertEmployee(Employee emp) throws SQLException{
		String sql = "insert into Employees"
				   + "(first_name, last_name, email, phone_number, job_id, department_id, "
				   + "salary, commission_pct, manager_id, employee_id, hire_date) "
				   + "values "
				   + "(?, ?, ?, ?, ?, ?, ?, ?, ?, employees_seq.nextval, sysdate)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, emp.getFirstName());
		pstmt.setString(2, emp.getLastName());
		pstmt.setString(3, emp.getEmail());
		pstmt.setString(4, emp.getPhoneNumber());
		pstmt.setString(5, emp.getJobId());
		pstmt.setInt(6, emp.getDepartmentId());
		pstmt.setDouble(7, emp.getSalary());
		pstmt.setDouble(8, emp.getCommissionPct());
		pstmt.setInt(9, emp.getManagerId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
	
	public List<Employee> getEmployeesByManagerId(int employeeId) throws SQLException{
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql="select employee_id, first_name, last_name, "
				 + "email, phone_number "
				 + "from employees "
				 + "where manager_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			
			employees.add(emp);
		}
		
		return employees;
	}
	
	public EmployeeDto getEmployeeDtoById(int empId) throws SQLException {
		EmployeeDto empDto = new EmployeeDto();
		
		String sql = "select E.employee_id, E.first_name, E.last_name, E.email, E.phone_number, "
				+ "E.job_id, E.hire_date, E.salary, E.commission_pct, D.department_id, D.department_name, "
				+ "D.manager_id, M.first_name || ' ' || E.last_name as manager_name "
				+ "from employees E, departments D, employees M "
				+ "where E.department_id = D.department_id(+) "
				+ "and D.manager_id = M.employee_id(+) "
				+ "and E.employee_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			empDto.setId(rs.getInt("employee_id"));
			empDto.setFirstName(rs.getString("first_name"));
			empDto.setLastName(rs.getString("last_name"));
			empDto.setEmail(rs.getString("email"));
			empDto.setPhoneNumber(rs.getString("phone_number"));
			empDto.setJobId(rs.getString("job_id"));
			empDto.setHireDate(rs.getDate("hire_date"));
			empDto.setSalary(rs.getDouble("salary"));
			empDto.setCommissionPct(rs.getDouble("commission_pct"));
			empDto.setDepartmentId(rs.getInt("department_id"));
			empDto.setDepartmentName(rs.getString("department_name"));
			empDto.setManagerId(rs.getInt("manager_id"));
			empDto.setManagerName(rs.getString("manager_name"));
			
		}
		
		return empDto;
	}

	public List<Employee> getAllEmployees() throws SQLException{
		List<Employee> employees= new ArrayList<Employee>();
		
		String sql = "select * "
				   + "from employees "
				   + "order by employee_id";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		
		return employees;
	}
	public List<Employee> getEmployeesByDepartmentId(int deptId) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "select * "
				   + "from employees "
				   + "where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		
		
		
		return employees;
	}
}
