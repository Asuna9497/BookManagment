package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.UserRepository;
import com.hnt.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * This method will find user by id and will return user object
	 * 
	 * @param Id
	 * @return User
	 */
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}

}
