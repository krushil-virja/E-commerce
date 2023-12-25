package com.Ecommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.entities.User;


public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserByName(username);
		
       if(user== null) {
    	   throw new UsernameNotFoundException("could not load user !!");
    	   
    	   
       }
		
       // return customUserDetails cause we pass user in it constructor so we get all user information.
		 CustomUserDetails CustomUserDetails = new CustomUserDetails(user);
		return CustomUserDetails;
			}

}
