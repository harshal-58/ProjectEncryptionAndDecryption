package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path = "/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("You are in Controller : "+user);
		User savedUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		
	}
	
	
}
