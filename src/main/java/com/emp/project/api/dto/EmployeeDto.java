package com.emp.project.api.dto;

import java.sql.Date;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeDto {
	private int id;

	// @NotBlank(message = "this field required")
	private String first;
	// @NotBlank(message = "this field required")
	private String last;
	// @Email(message="please valid email")
	// @NaturalId
	private String email;
//	@JsonFormat(pattern = "mm/dd/yyyy")
	private Date dob;
	// @JsonFormat(pattern = "mm/dd/yyyy")

	private Date doj;

	// string department name
	private String dept;

}
