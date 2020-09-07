package com.nickjojo.ecomapp.service;

import java.util.List;

import com.nickjojo.ecomapp.entity.User;

public interface UserService {

	User findByEmail(String email);

	public User findByUsername(String username);
	
	void save(User user);
	
	List<User> findAll();
}
