package com.revature.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "ROLE_LEAVES")
public class LeaveRole {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	@Column(name = "CASUAL_LEAVE")
	private Long casual_leave;

	@Column(name = "SICK_LEAVE")
	private Long sick_leave;

	@Column(name = "PAID_LEAVE")
	private Long paid_leave;

	@Column(name = "MATERNITY_LEAVE")
	private Long maternity_leave;

	@Column(name = "PATERNITY_LEAVE")
	private Long paternity_leave;

	@Column(name = "PRIVILEGED_LEAVE")
	private Long privileged_leave;

	@Column(name = "ACTIVE")
	private boolean active;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_DATE")
	private LocalDate modifiedDate;

}