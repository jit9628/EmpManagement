package com.emp.project.api.service;
import java.util.List;

import com.emp.project.api.dto.EmployeeDto;
import com.emp.project.api.entity.Employee;

public interface EmployeeService {
	// create employee
	public int create(EmployeeDto empl);

	// list all employee
	public List<Employee> getAllEmployee();

	// update employee
	public boolean updateemployee(EmployeeDto dtoEmployee , int id);

	// get employee by id

	public Employee getEmployeeById(int id);
	
	// delete employee
	
	public boolean deleteemployee(int id);
	
	// employee count
	public long getEmployeeCount();
	

}
