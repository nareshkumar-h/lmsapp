package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> list(ModelMap modelMap, HttpSession session) throws Exception {

			List<Employee> list = employeeService.list();
			return list;

}
	
	

}
