package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.encryption.EncryptionService;
import com.example.demo.encryption.EncryptionService1;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EncryptionService encryptionService;
	
	@Autowired
	EncryptionService1 encryptionService1;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("You are in Service -> : "+user);
	//	String encryptedPassword = encryptionService.encrypt(user.getPassword()); 
		String encryptedPassword = EncryptionService1.encrypt(user.getPassword());
		user.setPassword(encryptedPassword);
		System.out.println("You are in Service -> Encrypted Password : "+user);
		return user;
	}

	@Override
	public User displayUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
