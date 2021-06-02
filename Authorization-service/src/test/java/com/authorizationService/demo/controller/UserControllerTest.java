package com.authorizationService.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.authorizationService.demo.jwt.JwtRequest;
import com.authorizationService.demo.jwt.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UserControllerTest {

	@InjectMocks
	UserController userController;
	@Mock
	AuthenticationManager authentication;
	@Mock
	UserDetailsService userDetailsService;
	@Mock
	JwtUtil jwtTokenUtil;
//	@Mock
//	AuthenticationManager authManager;

	@Test
	public void testCreateAuthenticationTokenPositive() throws Exception {
		log.info("testCreateAuthenticationTokenPositive START");
		JwtRequest authenticationRequest = new JwtRequest("Sufiyan", "1234");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("token");
		String token = userController.createAuthenticationToken(authenticationRequest);
		assertEquals("token", token);
		verify(userDetailsService).loadUserByUsername(authenticationRequest.getUsername());
		verify(jwtTokenUtil).generateToken(userDetails);
		log.info("testCreateAuthenticationTokenPositive END");
	}

	@Test
	public void testCreateAuthenticationTokenNegative() throws Exception {
		log.info("testCreateAuthenticationTokenNegative START");
		JwtRequest authenticationRequest = new JwtRequest("XYZ", "XYZ");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn(null);
		String token = userController.createAuthenticationToken(authenticationRequest);
		assertNotEquals("token", token);
		verify(userDetailsService).loadUserByUsername(authenticationRequest.getUsername());
		verify(jwtTokenUtil).generateToken(userDetails);
		log.info("testCreateAuthenticationTokenNegative END");
	}

	@Test
	public void testValidateTokenPostiveCase() {
		log.info("testValidateTokenPostiveCase START");
		Boolean validateToken = userController.validateToken();
		assertEquals(true, validateToken);
		log.info("testValidateTokenPostiveCase END");

	}

//	@Test
//	public void testExceptions1() {
//		AuthenticationManager authManager = mock(AuthenticationManager.class);
//		  
//
//		Assertions.assertThrows(Exception.class, ()->{ 
//			when(authManager.authenticate(new UsernamePasswordAuthenticationToken("XYZ", "XYZ")))
//			.thenThrow(Exception.class);
//			JwtRequest authenticationRequest = new JwtRequest("XYZ","XYZ");
//			userController.createAuthenticationToken(authenticationRequest );
//		
//			});
//	}

}

























