package com.uxpsystems.assignement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignement.dao.UserRepository;
import com.uxpsystems.assignement.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUserlist() {
		
		return userRepository.findAll();
	}

	public User insertUser(User user) {
		
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User DeleteUser(Long id) {
		User user =userRepository.findById(id).get();
		userRepository.deleteById(id);
		return user;
	}

	public User getUser(Long id) {
		
		return userRepository.findById(id).get();
	}

	
}
