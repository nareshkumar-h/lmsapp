package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LeaveTypeDAO;
import com.revature.model.LeaveType;

@Service
public class LeaveTypeService {

	@Autowired
	private LeaveTypeDAO leaveTypeDAO;

	public LeaveType findById(Long id) {
		return leaveTypeDAO.findById(id);
	}

}