package com.revature.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LeaveDetailDAO;
import com.revature.model.LeaveDetail;

@Service
public class LeaveDetailService {
	
	@Autowired
	private LeaveDetailDAO leavedetaildao;
	
	
	public void save(LeaveDetail ld) {
		leavedetaildao.applyLeave(ld);
	}

	public void update(LeaveDetail ld) {
		leavedetaildao.update(ld);
	}

	public List<LeaveDetail> list(Long empId) {

		return leavedetaildao.list(empId);
}

}
