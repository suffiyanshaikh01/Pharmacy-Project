package com.authorizationService.demo.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorizationService.demo.model.User;
import com.authorizationService.demo.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	
	@Transactional
	public User getByUsername(String username)
	{
		return userRepo.findByUname(username);
	}
	
	@Transactional
	public boolean login(String userName, String password) {
		User u = userRepo.findUser(userName, password);
		if (u == null)
			return false;
		else {
			System.out.println(u);
			return true;
		}

	}
}
