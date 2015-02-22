package com.ikhotynskyi.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ikhotynskyi.dao.UserDAO;
import com.ikhotynskyi.entity.User;
import com.ikhotynskyi.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	public void setUserDAO (UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}
	
	

}
