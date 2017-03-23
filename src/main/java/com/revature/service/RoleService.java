package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RoleDAO;
import com.revature.model.Role;

@Service
public class RoleService {
	@Autowired
	private RoleDAO roleDAO;

	public Role findById(Long id) {
		return roleDAO.findById(id);
	}

	public List<Role> list() {
		return roleDAO.list();

	}

	public void insert(Role role) {

		roleDAO.insert(role);
	}

	public void delete(Long roleId) {

		roleDAO.delete(roleId);
	}

	public void update(Role role) {

		roleDAO.update(role);
}
	

}
