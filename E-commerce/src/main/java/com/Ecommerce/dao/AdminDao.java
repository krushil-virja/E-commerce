package com.Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.entities.User;

@Service
public class AdminDao {
	
	@Autowired
	private UserRepository userRepository;  // cause we have to show all login user at admin side so we need userrepository object for find all user method 
	
	public List<User> allUser(){
		
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

}
