package com.emp.project.api.response;

import java.util.HashMap;
import java.util.Map;

//import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpstatus,
			Object responseDataObject) {

		Map<String, Object> response = new HashMap<String,Object>();
		response.put("message", message);
		response.put("httpstatus", httpstatus);
		response.put("Data", response);
		return new ResponseEntity<>(response,httpstatus);

	}
}
