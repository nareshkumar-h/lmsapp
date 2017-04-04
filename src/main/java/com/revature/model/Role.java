package com.revature.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name="MODIFIED_DATE")
	private LocalDate modifiedDate;

}
