package com.xyz.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping	;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.user.entity.User;
import com.xyz.user.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/health")
	public String healthCheck() {
		return "OK";
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User userRequest){
		
		User user = userRepository.findByUsername(userRequest.getUsername());
		if(user==null)
			return userRepository.save(userRequest);
		else return user;
	}
		
}
