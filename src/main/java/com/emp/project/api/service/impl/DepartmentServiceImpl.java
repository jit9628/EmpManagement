package com.emp.project.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.project.api.dto.DepartmentDto;
import com.emp.project.api.entity.Department;
import com.emp.project.api.repo.DepartmentRepo;
import com.emp.project.api.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private ModelMapper mapper;

	@Override

	public int createDepartment(DepartmentDto department) {
		Department map = this.mapper.map(department, Department.class);
		Department findBydept = this.departmentRepo.findBydept(map.getDept());
		if(findBydept!=null)
			return 0;
		this.departmentRepo.save(map);
		return 1;
	}

	@Override
	public List<Department> getAllDepartmnt() {
		return this.departmentRepo.findAll();
	}

	@Override
	public boolean updateDepartment(DepartmentDto dto, int id) {
		Department exsisted = this.departmentRepo.findById(id).get();
		if (exsisted.getDeptid() != id)
			return false;
		Department updatedDep = this.mapper.map(dto, Department.class);
		updatedDep.setDeptid(id);
		updatedDep = this.departmentRepo.save(updatedDep);
		if (updatedDep != null)
			return true;
		return false;
	}

}
