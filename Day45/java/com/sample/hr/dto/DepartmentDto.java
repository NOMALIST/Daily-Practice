package com.sample.hr.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.utils.ConnectionUtil;

public class DepartmentDto {

	private int id;
	private String name;
	private int managerId;
	private String managerName;
	private int locationId;
	private String city;
	private int empCount;
	
	public DepartmentDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	
	
	/**
	 * 부서아이디를 전달받아서 부서기본 정보를 반환한다.
	 * @param deptId 조회할 부서아이디
	 * @return 부서정보가 포함된 DepartmentDto
	 * @throws SQLException
	 */
	

	
}
