package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.EmployeeHierarchyDAO;

@Service
public class EmployeeHierarchyService {
	
	@Autowired
	private EmployeeHierarchyDAO employeehierarchydao;
	
	public void save(int eid,int mid)
	{
		employeehierarchydao.addHierarchyDetails(eid, mid);
	}
	
	
	
	

}
