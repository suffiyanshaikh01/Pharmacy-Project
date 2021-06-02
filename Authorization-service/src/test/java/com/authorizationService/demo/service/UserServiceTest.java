package com.authorizationService.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationService.demo.model.User;
import com.authorizationService.demo.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UserServiceTest {

	@InjectMocks
	UserService userService;
	@Mock
	UserRepository userRepo;
	
	@Test
	public void testGetByUserNamePositiveCase() {
		log.info("testGetByUserNamePositiveCase START");
		User u = new User(1,"Sufiyan","1234","user");
		when( userRepo.findByUname("Sufiyan"))
		.thenReturn(u);
		User user = userService.getByUsername("Sufiyan");
		assertEquals(u, user);
		assertNotNull(user);
		log.info("testGetByUserNamePositiveCase START");

	}
	
	@Test
	public void testGetByUserNameNegativeCase() {
		log.info("testGetByUserNameNegativeCase START");
		User u = null;
		when( userRepo.findByUname("XYZ"))
		.thenReturn(u);
		User user = userService.getByUsername("XYZ");
		assertEquals(u, user);
		assertNull(user);
		log.info("testGetByUserNameNegativeCase START");

	}
	
	@Test
	public void testLoginPositiveCase() {
		log.info("testLoginPositiveCase START");
		User u = new User(1,"Sufiyan","1234","user");
		
		when(userRepo.findUser("Sufiyan", "1234"))
		.thenReturn(u);
		boolean login = userService.login("Sufiyan", "1234");
		assertTrue(login);
		log.info("testLoginPositiveCase END");

	}
	
	@Test
	public void testLoginNegativeCase() {
		log.info("testLoginPositiveCase START");
		when(userRepo.findUser("XYZ", "XYZ"))
		.thenReturn(null);
		boolean login = userService.login("XYZ","XYZ");
		assertFalse(login);
		log.info("testLoginPositiveCase END");

	}
	
	
	
	
	
	
	
	
	
	
}
