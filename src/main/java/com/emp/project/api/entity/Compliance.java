package com.emp.project.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
public class Compliance {
	@Id
	private int complainid;
	private String details;
	private LocalDate createdate;
	
}
