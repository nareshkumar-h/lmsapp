package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LEAVE_TYPES")
public class LeaveType {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "LEAVE_TYPE")
	private String type;

	@Column(name = "ACTIVE")
	private boolean active;
}
