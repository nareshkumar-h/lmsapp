package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LeaveStatusDAO;
import com.revature.model.LeaveStatus;

@Service
public class LeaveStatusService {

	@Autowired
	private LeaveStatusDAO leaveStatusDAO;

	public LeaveStatus findById(Long id) {
		return leaveStatusDAO.findById(id);
	}

}
