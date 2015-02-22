package com.ikhotynskyi.service;

import java.util.List;

import com.ikhotynskyi.entity.Role;

public interface RoleService {
	
	void addRole(Role r);
	void updateRole(Role r);
	List<Role> getAllRoles();
	Role getRoleById(int id);
	void removeRole(int id);

}
