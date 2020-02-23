package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public User findUserByIdCustomer(long idCustomer) {
		return userRepository.findByIdCustomer(idCustomer);
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
