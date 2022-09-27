package com.emp.project.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.project.api.dto.EmployeeDto;
import com.emp.project.api.entity.Employee;
import com.emp.project.api.response.ApiResponse;
import com.emp.project.api.response.ResponseHandler;
import com.emp.project.api.service.EmployeeService;

@CrossOrigin(originPatterns = "*")
@Controller()
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
//@Autowired
//	private ModelMapper Mapper;
  
/* create employee handler
	
	@GetMapping("/in")
	public String indexes() {
		return "homepage";
	}
	// get the Register Employye form
	
	@GetMapping("/reg")
	public String registerEmp() {
		return "RegisterEmployee";
	}
	@PostMapping("/register")
	public String registerSuccess(@ModelAttribute EmployeeDto dto,Model model) {
		int create = this.employeeService.create(dto);
		if(create==1) {
			model.addAttribute("success", "Employee successfully created :) thank you !");
			return"RegisterEmployee";
		}
		else {
			model.addAttribute("error", "data Already existed  thank you !");
			return"RegisterEmployee";
		}
//		this.employeeService
		
	}
	@GetMapping("/login")
	public String LoginEmp() {
		return "logInEmployee";
	}
	
}	
*/		 
@PostMapping("/Add")
public ResponseEntity<?> createEmp(@Valid @RequestBody EmployeeDto employeeDto) {
	try {
		int create = employeeService.create(employeeDto);
		System.out.println("proccess completed then after execute statement status is"+create);
		if (create > 0) {
			
			return new ResponseEntity<>(new ApiResponse("Add user Successfully", "success", true, 20), HttpStatus.OK);
//
//			return new ResponseEntity<>(
//					Map.of("message", "Add Employee Successfully", "status", HttpStatus.OK, "statusCode", 201),
//					HttpStatus.OK);

		} else {
			return new ResponseEntity<>(Map.of("message", "email is allready existed please provide different email !! ","email",employeeDto.getEmail(), "status",
					HttpStatus.BAD_REQUEST, "statusCode", 400), HttpStatus.BAD_REQUEST);
		}

	} catch (Exception ex) {
		ex.printStackTrace();
	}

	return new ResponseEntity<>(
			Map.of("message", "Add Employee Successfully", "status", HttpStatus.OK, "statusCode", 201),
			HttpStatus.OK);

}

// read employee handler
@GetMapping("/all")
public ResponseEntity<?> getAllData() {
	List<Employee> allEmployee = employeeService.getAllEmployee();
	System.out.println(allEmployee);
	if (allEmployee != null && allEmployee.size() > 0) {
		
		return new ResponseEntity<>(new ApiResponse("Add user Successfully", "success", true ,20,Arrays.asList(allEmployee)), HttpStatus.OK);

		//return ResponseHandler.responseBuilder("All Employee Data", HttpStatus.OK, Arrays.asList(allEmployee));	
//		return new ResponseEntity<>(Map.of("messaage", "find all data", "data", allEmployee, "status",
//				HttpStatus.OK, "statusCode", 200), HttpStatus.OK);
	}

	else {
		return new ResponseEntity<>(Map.of("messaage", "find data not possible some problem occured ", "status",
				HttpStatus.BAD_REQUEST, "statusCode", 500), HttpStatus.BAD_REQUEST);
	}
}
@GetMapping("/singleData/{id}")
public ResponseEntity<?> getData(@Valid @PathVariable("id") int id) {
		Employee emp = employeeService.getEmployeeById(id);
		if (emp != null) {
			//return new ResponseEntity<ApiResonse>Map.of();
			return new ResponseEntity<>(
					Map.of("messaage", "find all data", "data", emp, "status", HttpStatus.OK, "statusCode", 200),
					HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(Map.of("messaage", "find data not possible some problem occured ", "status",
					HttpStatus.BAD_REQUEST, "statusCode", 500), HttpStatus.BAD_REQUEST);
		}
		}
//delete data by id 
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteEmployeeById(@Valid @PathVariable int id) {
	// get id and check id is exists or not if id is exixts than employee deleted
	// otherwise get message
	boolean deleteemployee = this.employeeService.deleteemployee(id);
	if(deleteemployee==true)
	return new ResponseEntity<>(Map.of("delete", "delete employee successfully"), HttpStatus.OK);
	else
		return new ResponseEntity<>(Map.of("delete", "delete employee not successfully"), HttpStatus.BAD_REQUEST);

}
//count total employee
@GetMapping("/total")
public long getCount() {
	return this.employeeService.getEmployeeCount();
}
/*=================== update data=====================*/
@PutMapping("/update/{id}")
public ResponseEntity<?> updateData( @PathVariable int id,@RequestBody EmployeeDto dto) {
	boolean updateemployee = this.employeeService.updateemployee(dto, id);
	if(updateemployee==true)
		
	return new ResponseEntity<>(Map.of("msg","data updated successfull","status","200"),HttpStatus.OK);
	else
		return new ResponseEntity<>(Map.of("msg","data not updated updated error occured "),HttpStatus.BAD_REQUEST);
}
/* exception Handling 
@ExceptionHandler(value = NoSuchElementException.class)
public ResponseEntity<ApiResponse> showException() {
	return new ResponseEntity<ApiResponse>((new ApiResponse("data not found", "NoSuchData", false, 404)),
			HttpStatus.BAD_REQUEST);
}
*/


}// end controller	