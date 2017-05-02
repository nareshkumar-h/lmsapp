package com.revature.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/api")
	public List<Employee> list2() {

		List<Employee> list = employeeService.list2();
		return list;

	}
	
	@GetMapping("/managers")
	public List<Employee> listManagers() {

		List<Employee> list = employeeService.getManagers();
		return list;

	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
		

		Employee employee=employeeService.findByEmailIdAndPassword(emailId, password);
		if (employee != null && employee.getPassword().equals(password) && employee.isActive()) {
			employee.setPassword(null);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		} else {			
			return new ResponseEntity<Employee>(employee,HttpStatus.BAD_REQUEST);
		}
}
	
	@PostMapping
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
	@PostMapping ("/password")
	public void updatePassword(@RequestParam("emailId") String emailId, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
		employeeService.changePassword(emailId, oldPassword, newPassword);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
	}

}
