package com.authorizationService.demo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationService.demo.jwt.JwtRequest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class JwtRequestTest {
	
	@InjectMocks
	JwtRequest jwtRequest;
	
	@Test
	public void testUserName() {
		log.info("testUserName START");
		jwtRequest.setUsername("Sufiyan");
		assertEquals("Sufiyan", jwtRequest.getUsername());
		log.info("testUserName START");

	}
	
	@Test
	public void testPassword() {
		log.info("testPassword START");
		jwtRequest.setPassword("1234");;
		assertEquals("1234", jwtRequest.getPassword());
		log.info("testPassword START");

	}
	
	@Test
	public void testToString() {
		log.info("testToString START");
		JwtRequest req = new JwtRequest("Sufiyan","1234");
		String toString = jwtRequest.toString();
		log.info("testToString START");
		assertNotNull(toString);
		
	}
	
	@Test
	public void testDefaultConstructor() {
		log.info("testDefaultConstructor START");
		JwtRequest req = new JwtRequest();
		assertNotNull(req);
		log.info("testDefaultConstructor END");
	}
}

















