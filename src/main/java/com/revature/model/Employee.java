package com.revature.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Employee {
	
	
	private Long id;

	
	private String code;

	
	private String name;

	
	private String password;

	
	private String gender;

	
	private Role role;

	
	private String emailId;

	
	private Long mobileNo;

	
	private boolean active;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")	
private LocalDate modifiedDate;
	
	

}
