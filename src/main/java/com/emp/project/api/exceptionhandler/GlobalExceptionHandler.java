package com.emp.project.api.exceptionhandler;

import java.util.Map;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConfigDataResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ConfigDataResourceNotFoundException ex){
		return new ResponseEntity<>(Map.of("message","this url not found"),HttpStatus.BAD_REQUEST);
		
	}
	
	
}
