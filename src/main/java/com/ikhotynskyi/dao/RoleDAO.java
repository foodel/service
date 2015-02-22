package com.ikhotynskyi.dao;

import java.util.List;

import com.ikhotynskyi.entity.Role;

public interface RoleDAO {
	
	void addRole(Role r);
	void updateRole(Role r);
	List<Role> getAllRoles();
	Role getRoleById(int id);
	void removeRole(int id);
	
}
