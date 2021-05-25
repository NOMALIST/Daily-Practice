package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.dto.DepartmentDto;
import com.sample.hr.vo.Department;
import com.sample.utils.ConnectionUtil;

/**
 * DEPARTMENTS 테이블에 대한 CRUD 기능을 제공하는 클래스다.
 * @author YOJUIN SEO
 *
 */


public class DepartmentDao {
	
	/**
	 * 수정된 부서정보를 전달받아서 부서정보를 변경한다.
	 * @param dept
	 * @throws SQLException
	 */
	public void updateDepartment(Department dept) throws SQLException {
		String sql = "update departments "
				   + "set "
				   + "department_name = ?, "
				   + "manager_id = ?, "
				   + "location_id = ? "
				   + "where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dept.getName());
		pstmt.setInt(2, dept.getManagerId());
		pstmt.setInt(3, dept.getLocationId());
		pstmt.setInt(4, dept.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
				   
		
	}

	/**
	 * 부서번호를 전달받아서 해당 부서의 정보를 테이블에서 삭제한다
	 * @param deptId 삭제할 부서 아이디
	 * @throws SQLException
	 */
	public void deleteDepartment(int deptId) throws SQLException {
		String sql = "delete from departments "
				   + "where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	
	/**
	 * 전달받은 부서정보를 테이블에 추가한다
	 * @param department 부서정보
	 * @throws SQLException
	 */			
	public void insertDepartment(Department department) throws SQLException {
		String sql = "insert into departments "
				   + "(department_id, department_name, location_id) "
				   + "values "
				   + "(departments_seq.nextval, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, department.getName());
		pstmt.setInt(2, department.getLocationId());
		pstmt.executeUpdate();	//INSERT, UPDATE, DELETE 구문일 경우 실행한다/
		
		pstmt.close();
		con.close();
	}
	
	
	
	
	
	/**
	 * 모든 부서정보를 반환한다.
	 * @return 부서정보 목록
	 * @throws SQLException
	 */
	public List<Department> getAllDepartments() throws SQLException{
		List<Department> departments = new ArrayList<Department>();
		
		String sql = "select department_id, department_name, manager_id, location_id "
				   + "from departments "
				   + "order by department_id asc";
		
		Connection con = ConnectionUtil.getConnection();		// DBMS와 연결을 담당하는 Connection 객체 획득
		PreparedStatement pstmt = con.prepareStatement(sql);	// 지정된 SQL을 DBMS로 전송하는 PreparedStatement
		ResultSet rs = pstmt.executeQuery();					// SQL을 DBMS로 전송하고 실행결과가 포함된 ResultSet 객체 획득
		
		while(rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("manager_id"));
			department.setLocationId(rs.getInt("Location_id"));
			
			departments.add(department);
		}

		rs.close();
		pstmt.close();
		con.close();
		
		return departments;
	}
	
	public DepartmentDto getDepartmentDto(int deptId) throws SQLException{
		String sql = "select D.department_id, D.department_name, D.manager_id, M.first_name, "
				+ "        L.location_id, L.city, "
				+ "        (select count(*) "
				+ "         from employees E where E.department_id = ?) emp_count "
				+ "from departments D, Locations L, Employees M "
				+ "where D.location_id = L.location_id "
				+ "and D.manager_id = M.employee_id(+) "
				+ "and D.department_id = ?";
		
		DepartmentDto dto = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		pstmt.setInt(2, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dto = new DepartmentDto();
			dto.setId(rs.getInt("department_id"));
			dto.setName(rs.getString("department_name"));
			dto.setManagerId(rs.getInt("manager_id"));
			dto.setManagerName(rs.getString("first_name"));
			dto.setLocationId(rs.getInt("location_id"));
			dto.setCity(rs.getString("city"));
			dto.setEmpCount(rs.getInt("emp_count"));
		}
		
		return dto;
	}
	
	public Department getDepartmentById(int deptId) throws SQLException{
		Department department = null;
		
		String sql = "select * "
				   + "from departments "
				   + "where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("manager_id"));
			department.setLocationId(rs.getInt("location_id"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return department;
	}
}
