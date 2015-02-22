package com.ikhotynskyi.service;

import java.util.List;

import com.ikhotynskyi.entity.User;

public interface UserService {
	
	void addUser(User u);
    void updateUser(User u);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUser(int id);

}
