package com.emp.project.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.project.api.dto.EmployeeDto;
import com.emp.project.api.entity.Department;
import com.emp.project.api.entity.Employee;
import com.emp.project.api.entity.User;
import com.emp.project.api.repo.DepartmentRepo;
import com.emp.project.api.repo.EmployeeRepo;
import com.emp.project.api.repo.UserRepository;
import com.emp.project.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	/*
	 * inside service class autowired repository o implementing class object
	 */
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper Mapper;

	
	/*
	 * create or save employee module
	 */
	@Override
	public int create(EmployeeDto empl) {	
//		check employee is availabke or not 
		Employee emp=this.Mapper.map(empl, Employee.class);
		Employee findByemail = this.employeeRepo.findByemail(emp.getEmail());
		if(findByemail!=null) 
			return 0;
		Department findBydeptName = this.departmentRepo.findBydept(empl.getDept());
		System.out.println("Department values" + findBydeptName);
		Employee employee = new Employee(empl.getFirst(), empl.getLast(), empl.getEmail(), empl.getDob(), findBydeptName,empl.getDoj());
		Employee save = this.employeeRepo.save(employee);
		System.out.println(save);
		return 1;
	}
	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepo.findAll();
	}

	@Override
	public boolean updateemployee(EmployeeDto dto, int id) {
		return false;
		
		
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = this.employeeRepo.findById(id).get();
		return employee;
	}

	@Override
	public boolean deleteemployee(int id) {
		// int findByid = this.employeeRepo.findByid();
		Employee employee = this.employeeRepo.findById(id).get();
		if (employee != null) {
			this.employeeRepo.deleteById(id);
			return true;
		}
		return false;
	}

	// count
	public long getEmployeeCount() {

		return this.employeeRepo.count();

	}

//	find mail is exists or not 
	public Employee findByemail(String email) {
		return this.employeeRepo.findByemail(email);
	}

}
