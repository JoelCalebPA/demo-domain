package com.domain.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.domain.demo.model.User;
import com.domain.demo.repository.UserRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/api/docs")
	public String getDocs() {
		return "no docs to show";
	}
	
}
