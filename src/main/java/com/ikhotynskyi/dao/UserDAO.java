package com.ikhotynskyi.dao;

import java.util.List;

import com.ikhotynskyi.entity.User;

public interface UserDAO {
	
	void addUser(User u);
    void updateUser(User u);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUser(int id);

}
