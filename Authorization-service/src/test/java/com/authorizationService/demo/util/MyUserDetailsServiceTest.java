package com.authorizationService.demo.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.authorizationService.demo.jwt.MyUserDetailsService;
import com.authorizationService.demo.model.User;
import com.authorizationService.demo.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class MyUserDetailsServiceTest {
	@InjectMocks
	MyUserDetailsService userService;
	@Mock
	UserRepository repo;
	
	@Test
	void testLoadUserByUserNameTest() {
		log.info("testLoadUserByUserNameTest START");
		User u = new User(1, "Sufiyan", "1234", "admin");
		when(repo.findByUname("Sufiyan"))
		.thenReturn(u);
		UserDetails userObj = userService.loadUserByUsername("Sufiyan");
		assertNotNull(userObj);
		log.info("testLoadUserByUserNameTest START");

	}
	@Test
	public void testException1() {
		Assertions.assertThrows(UsernameNotFoundException.class, ()->{
			User u = null;
			when(repo.findByUname("XYZ"))
			.thenReturn(u);
			userService.loadUserByUsername("XYZ");
		});
	}

}
