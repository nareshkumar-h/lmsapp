package com.revature.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.revature.util.CustomJsonDateDeserializer;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LeaveDetail {
	
	private Long id;
	private Employee employee;
	private LeaveType leaveType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private LocalDate fromDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private LocalDate toDate;
	
	private Float noOfDays;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private LocalDate appliedDate;
	
	private Employee modifiedBy;
	
	private LeaveStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
    private LocalDate modifiedDate;
	
	private String purpose;
	
	

}
