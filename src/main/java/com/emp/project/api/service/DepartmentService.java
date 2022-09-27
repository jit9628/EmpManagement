package com.emp.project.api.service;

import java.util.List;

import com.emp.project.api.dto.DepartmentDto;
import com.emp.project.api.entity.Department;

public interface DepartmentService {
	// add department
public int createDepartment(DepartmentDto departmentDto);
// getAll department
public List <Department> getAllDepartmnt();

public boolean updateDepartment( DepartmentDto dto,int id);

}
