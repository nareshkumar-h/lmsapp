package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LeaveType;
import com.revature.service.LeaveTypeService;

@CrossOrigin
@RestController
@RequestMapping("/leavetype")
public class LeaveTypeController {
	@Autowired
	private LeaveTypeService leaveTypeService;

	@GetMapping("/{id}")
	public LeaveType findById(@PathVariable("id") Long id) {
		return leaveTypeService.findById(id);
	}
}
