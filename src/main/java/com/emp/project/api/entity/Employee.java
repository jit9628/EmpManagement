package com.emp.project.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// @NotEmpty(message = "this field required")
	private String first;
//	@NotEmpty(message = "this field required")
	private String last;
	// @Email(message="please valid email")
	// @NaturalId
	private String email; 
	private Date dob; // date o birth 
	private Date doj;//date of joining 
	private String contact;
	@OneToOne
	@JoinColumn(name = "deptName")
	private Department dept;
//	@OneToOne
//	@JoinColumn(name = "userName")
//	private User user;
	public Employee(String first, String last, String email, Date date, Department dept, Date join) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
		this.dob = date;
		this.dept = dept;
		this.doj = join;
		
	}

}
