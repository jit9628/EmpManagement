package com.emp.project.api.response;

import java.util.List;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ApiResponse {
	

	  private String msg;
	  private String status;
	  private boolean success;
	  private List<?> body;
	  private int statusCode;
	
	  public ApiResponse(String msg, String status, boolean success, int statusCode) {
		super();
		this.msg = msg;
		this.status = status;
		this.success = success;
		this.statusCode = statusCode;
		
	}

	public ApiResponse(String msg, String status, boolean success,  int statusCode,List<?> body) {
		super();
		this.msg = msg;
		this.status = status;
		this.success = success;
		this.statusCode = statusCode;
		this.body = body;
	}
  
}


