package com.authorizationService.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class UserTest {
	@InjectMocks
	User user;
	
	@Test
	public void testUserId() {
		log.info("Testing userId START");
		user.setUserId(1);
		assertEquals(1, user.getUserId());
		log.info("Testing userId START");
	}
	@Test
	public void testUserName() {
		log.info("testUserName START");
		user.setUsername("Sufiyan");
		assertEquals("Sufiyan", user.getUsername());
		log.info("testUserName START");
	}
	@Test
	public void testPassword() {
		log.info("testPassword START");
		user.setPassword("1234");
		assertEquals("1234", user.getPassword());
		log.info("testPassword START");
	}
	@Test
	public void testRole() {
		log.info("testRole START");
		user.setRole("admin");;
		assertEquals("admin", user.getRole());
		log.info("testRole START");
	}

}
