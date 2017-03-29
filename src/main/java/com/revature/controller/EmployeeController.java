package com.revature.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;

import com.revature.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> list() {

		List<Employee> list = employeeService.list();
		return list;

	}
	
	
	@PostMapping("/login")
	public Employee login(@RequestParam("code") String code, @RequestParam("password") String password) {
		

		Employee employee=employeeService.findByCodeAndPassword(code, password);
		if (employee != null) {
			return employee;
		} else {
			
			return null;
		}
}
	
	@PostMapping("/RegisterEmployee")
	public void register(@RequestBody Employee employee) throws Exception {

	
			
			

			employeeService.register(employee);

			

	}


	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		return employeeService.findById(id);
	}

	@PutMapping
	public void update(@RequestBody Employee employee) {
		employeeService.update(employee);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
	}

}
