package com.authorizationService.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizationService.demo.jwt.JwtRequest;
import com.authorizationService.demo.jwt.JwtUtil;
import com.authorizationService.demo.model.User;
import com.authorizationService.demo.repositories.UserRepository;
import com.authorizationService.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/login")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/")
	public Boolean validateToken() {
		return true;
		
	}

	@PostMapping("/getToken")
	public String createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		try {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch(Exception InvalidUserException) {
			log.error(InvalidUserException.toString());
			return null; 
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println(token);
		return token;
	}

	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException disabledException) { 
			throw new Exception("USER_DISABLED", disabledException); 
		} catch (BadCredentialsException badCredentialsException) {   
			throw new Exception("INVALID_CREDENTIALS", badCredentialsException);
		}
	}

}
