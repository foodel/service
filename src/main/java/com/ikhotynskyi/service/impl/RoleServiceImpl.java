package com.ikhotynskyi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikhotynskyi.dao.RoleDAO;
import com.ikhotynskyi.entity.Role;
import com.ikhotynskyi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
	this.roleDAO = roleDAO;	
	}
	
	@Override
	@Transactional
	public void addRole(Role r) {
		this.roleDAO.addRole(r);
	}

	@Override
	@Transactional
	public void updateRole(Role r) {
		this.roleDAO.updateRole(r);
	}

	@Override
	@Transactional
	public List<Role> getAllRoles() {
		return this.roleDAO.getAllRoles();
	}

	@Override
	@Transactional
	public Role getRoleById(int id) {
		return this.roleDAO.getRoleById(id);
	}

	@Override
	@Transactional
	public void removeRole(int id) {
		this.roleDAO.removeRole(id);
	}
	
	

}
