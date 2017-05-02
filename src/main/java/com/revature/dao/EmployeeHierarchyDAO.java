package com.revature.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeHierarchyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private void deleteEntry(int eid) {
		String sql = "DELETE FROM EMPLOYEE_HIERARCHY WHERE EMP_ID=?";
		int rows = jdbcTemplate.update(sql, eid);
		System.out.println("No of rows affected:" + rows);
	}

	
	public void addHierarchyDetails(int eid, int mid) {
		
		deleteEntry(eid);
		String sql = "INSERT INTO EMPLOYEE_HIERARCHY ( EMP_ID,MGR_ID)" + "VALUES ( ?, ? )";
		int rows = jdbcTemplate.update(sql, eid, mid);
		System.out.println("No of rows inserted:" + rows);
	}

}
