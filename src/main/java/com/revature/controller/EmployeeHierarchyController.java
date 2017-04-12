package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.revature.service.EmployeeHierarchyService;

@CrossOrigin
@RestController
@RequestMapping("/employeeHierarchy")
public class EmployeeHierarchyController {
	
	@Autowired
	EmployeeHierarchyService employeehierarchy;
	
	@PostMapping
	public void save(@RequestParam int eid,@RequestParam int mid) {
		employeehierarchy.save(eid,mid);
	}

}
