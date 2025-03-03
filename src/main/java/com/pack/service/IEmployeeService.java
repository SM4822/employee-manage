package com.pack.service;

import java.util.List;

import com.pack.entity.Employee;

public interface IEmployeeService {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int employeeId);
	public Employee getEmployeeByEmailId(String emailId);
}
