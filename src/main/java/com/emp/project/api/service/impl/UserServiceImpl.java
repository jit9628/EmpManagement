package com.emp.project.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.project.api.entity.User;
import com.emp.project.api.repo.UserRepository;
import com.emp.project.api.service.UserServices;
@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	@Override
	public void validateUser(User user) {
		
		@SuppressWarnings("unused")
		User save = this.userRepository.save(user);	
	}

}
