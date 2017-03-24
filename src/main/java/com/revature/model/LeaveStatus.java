package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LEAVE_STATUS")
public class LeaveStatus {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE")
	private String status;

	@Column(name = "DESCRIPTION")
	private String description;
}
