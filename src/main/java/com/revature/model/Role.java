package com.revature.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "ROLE")
public class Role {
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="ROLE_CODE")
	private String code;

	@Column(name="ROLE_NAME")
	private String name;

	@Column(name="LEVEL")
	private Integer level;

	@Column(name="ACTIVE")
	private boolean active;

	@Column(name="CREATED_DATE")
	private LocalDate createdDate;

	@Column(name="MODIFIED_DATE")
	private LocalDate modifiedDate;

}
