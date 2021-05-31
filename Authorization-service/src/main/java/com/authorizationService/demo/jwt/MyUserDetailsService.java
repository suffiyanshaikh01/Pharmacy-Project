package com.authorizationService.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationService.demo.model.User;
import com.authorizationService.demo.repositories.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = repo.findByUname(username);
		if (u == null)
			throw new UsernameNotFoundException("YOU ARE NOT AN AUTHENTICATED USER. PLEASE TRY TO LOGIN WITH THE VALID CREDENTIALS");
		return new MyUserDetails(u);
	}

}
