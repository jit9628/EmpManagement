package com.emp.project.api.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.project.api.dto.DepartmentDto;
import com.emp.project.api.entity.Department;
import com.emp.project.api.service.DepartmentService;
@RestController
@RequestMapping("/department")
public class DepartmentController {
@Autowired
	private DepartmentService departmentService;
@PostMapping("/create")
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto department) {
	
		int createDepartment = this.departmentService.createDepartment(department);
		if(createDepartment>0)
			return new ResponseEntity<>(Map.of("message","department saved to the db","status",true,"statusCode",200),HttpStatus.OK);
		else
			return new ResponseEntity<>(Map.of("message","department not saved to the db","status",false,"statusCode",500),HttpStatus.BAD_REQUEST);

		
	}

// fet all data

@GetMapping("/getDept")
public ResponseEntity<?> getAllDepartment(){
	
	List<Department> allDepartmnt = this.departmentService.getAllDepartmnt();
	return new ResponseEntity<>(Map.of("data",allDepartmnt),HttpStatus.OK);	
}

@PutMapping("/update/{id}")
public ResponseEntity<?> updateDepartment(@PathVariable int id, @RequestBody DepartmentDto dept){
	boolean updateDepartment = this.departmentService.updateDepartment(dept, id);
	 	return new ResponseEntity<>(Map.of("status","updated","status",updateDepartment),HttpStatus.OK);	
	
}

	
}
