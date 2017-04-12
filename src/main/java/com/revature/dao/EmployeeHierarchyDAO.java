package com.revature.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeHierarchyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addHierarchyDetails(int eid,int mid)
	{
		String sql = "INSERT INTO EMPLOYEE_HIERARCHY ( EMP_ID,MGR_ID)"+ "VALUES ( ?, ? )";
		
		int rows = jdbcTemplate.update(sql, eid,mid);

		System.out.println("No of rows inserted:" + rows);
	}

}
