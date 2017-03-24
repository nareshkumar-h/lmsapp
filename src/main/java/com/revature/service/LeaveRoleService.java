package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LeaveRoleDAO;
import com.revature.model.LeaveRole;

@Service
public class LeaveRoleService {

	@Autowired
	private LeaveRoleDAO ldDao;

	public List<LeaveRole> list() {

		return ldDao.list();
	}

	public LeaveRole findByRoleId(long id) {

		return ldDao.findById(id);
	}

}
