package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.dao.ContactDao;
import com.Ecommerce.dao.UserDao;
import com.Ecommerce.entities.Contact;
import com.Ecommerce.entities.User;

import jakarta.validation.Valid;

@Controller
public class userController {
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private ContactDao cdao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

//======================================================= Handler for user registration =============================================================================
	@PostMapping("/do_register")
	public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model m ) {
		
		
		// first we check that our user print on console
		System.out.println("User" + user);
		
		if(result.hasErrors()) {
			
			System.out.println(result);
			
			return "register";
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User result1 = udao.addUser(user);
		return "redirect:login";
		
	}
	

//========================================================= Handler for add user inquiry ===========================================================================
	@PostMapping("/addContact")
	public String addContact(@Valid @ModelAttribute Contact contact,BindingResult result) {
		
		System.out.println("Contact" + contact);
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "contact";
		}
		
		Contact c = cdao.addContact(contact);
		return "redirect:contact";
		
		
	}
}
