package com.example.demo.service;

import com.example.demo.entities.User;

public interface UserService {

	User createUser(User user);
	
	User displayUser(int id);
	
}
