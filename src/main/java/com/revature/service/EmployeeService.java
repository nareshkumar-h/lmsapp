package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public Employee findByEmailIdAndPassword(String emailId, String password) {

		return employeeDAO.findByEmailIdAndPassword(emailId, password);
	}

	public Employee findById(Long empId) {

		return employeeDAO.findById(empId);
	}

	public List<Employee> findMyProfile(Long id) {

		return employeeDAO.findMyProfile(id);
	}

	public List<Employee> list() {

		return employeeDAO.list();
	}
	
	public List<Employee> list2() {

		return employeeDAO.list2();
	}
	
	public List<Employee> getManagers() {

		return employeeDAO.getManagers();
	}

	public void delete(Long empId) {

		employeeDAO.delete(empId);
	}

	public void update(Employee emp) {

		employeeDAO.update(emp);
	}

	public void register(Employee emp) {

		employeeDAO.registerEmployee(emp);
}
	public boolean changePassword(String emailId,String oldPassword,String newPassword)
	{
		return employeeDAO.changePassword(emailId, oldPassword, newPassword);
				
	}

}
