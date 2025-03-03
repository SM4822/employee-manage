package com.pack.dao;

import java.util.List;

import com.pack.entity.Employee;

public interface IEmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int employeeId);
	public Employee getEmployeeByEmailId(String emailId);
	
}
