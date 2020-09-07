package com.nickjojo.ecomapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickjojo.ecomapp.entity.User;
import com.nickjojo.ecomapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}
	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
