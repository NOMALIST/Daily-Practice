package com.sample.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sample.hr.dto.DepartmentDto;
import com.sample.hr.util.MybatisUtils;
import com.sample.hr.vo.Department;

public class DepartmentDaoMybatis {

	private SqlSessionFactory sqlSessionFactory;
	
	private static DepartmentDaoMybatis instance = new DepartmentDaoMybatis();
	private DepartmentDaoMybatis() {
		this.sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
	}
	
	public static DepartmentDaoMybatis getInstance() {
		return instance;
	}
	
	public void insertDepartment(Department department) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.insert("insertDepartment", department);
		session.close();
	}
	
	public void deleteDepartment(int deptId) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.delete("deleteDepartment", deptId);
		session.close();
	}
	
	public void updateDepartment(Department department) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("updateDepartment", department);
		session.close();
	}
	
	public List<Department> getAllDepartment() {
		List<Department> departments;
		
		SqlSession session = sqlSessionFactory.openSession();
		departments = session.selectList("getAllDepartment");
		session.close();
		
		return departments;
	}
	
	public Department getDepartmentByNo(int deptId) {
		Department department;
		
		SqlSession session = sqlSessionFactory.openSession();
		department = session.selectOne("getDepartmentByNo", deptId);
		session.close();
		
		return department;
	}
	
	public DepartmentDto getDepartmentDto(int deptId) {
		DepartmentDto dto;
		
		SqlSession session = sqlSessionFactory.openSession();
		dto = session.selectOne("getDepartmentDto", deptId);
		session.close();
		
		return dto;
	}
}
