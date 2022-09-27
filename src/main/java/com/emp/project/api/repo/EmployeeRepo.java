package com.emp.project.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.project.api.entity.Department;
import com.emp.project.api.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	 public Employee findByemail(String email);

}
