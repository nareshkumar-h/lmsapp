package com.revature.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LeaveRole;
import com.revature.service.LeaveRoleService;

@CrossOrigin
@RestController
@RequestMapping("leaveroles")
public class LeaveRoleController {

	@Autowired
	private LeaveRoleService leaveRoleService;

	@GetMapping
	public List<LeaveRole> list() throws Exception {

		return leaveRoleService.list();

	}
	@GetMapping("/{id}")
	public LeaveRole findById(@PathVariable("id") Long id) {
		return leaveRoleService.findByRoleId(id);
	}

}
