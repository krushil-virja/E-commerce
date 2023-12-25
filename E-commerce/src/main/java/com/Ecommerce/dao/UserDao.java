package com.Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.entities.User;

@Service
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User addUser(User u) {
		
		User user = userRepository.save(u);
		return user;
		
	}
	
	
	
	}
	


