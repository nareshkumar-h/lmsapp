package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LeaveStatus;
import com.revature.service.LeaveStatusService;

@CrossOrigin
@RestController
@RequestMapping("/leavestatus")
public class LeaveStatusController {
	@Autowired
	private LeaveStatusService leaveStatusService;

	@GetMapping("/{id}")
	public LeaveStatus findById(@PathVariable("id") Long id) {
		return leaveStatusService.findById(id);
	}
}
