package com.emp.project.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.project.api.entity.User;
import com.emp.project.api.response.ApiResponse;
import com.emp.project.api.service.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices services;

	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user) {

		this.services.validateUser(user);
		return new ResponseEntity<>(new ApiResponse("Add user Successfully", "success", true, 20), HttpStatus.OK

		// "message", "Add user Successfully", "status", HttpStatus.OK, "statusCode",
		// 201
		// ),
		);

	}

}
