package com.authorizationService.demo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationService.demo.jwt.MyUserDetails;
import com.authorizationService.demo.model.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class MyUserDetailsTest {
	@InjectMocks
	MyUserDetails userDetails;
//	@Mock
//	User u = ;
	
	@Test
	void testGetUsernameTest() {
		
		log.info("testGetUsernameTest START");
		
		userDetails = new MyUserDetails(new User(1, "Sufiyan", "1234", "admin"));
		String username = userDetails.getUsername();
		assertEquals("Sufiyan", username);
		
		log.info("testGetUsernameTest END");
	}
	
	@Test
	void testGetPasswordTest() {
		
		log.info("testGetPasswordTest START");
		
		userDetails = new MyUserDetails(new User(1, "Sufiyan", "1234", "admin"));
		String pass = userDetails.getPassword();
		assertEquals("1234", pass);
		
		log.info("testGetPasswordTest END");
	}
	
	@Test
	public void testIsAccountNonExpired() {
		assertTrue(userDetails.isAccountNonExpired());
	}
	@Test
	public void testIsAccountNonLocked() {
		assertTrue(userDetails.isAccountNonLocked());
	}
	@Test
	public void testIsCredentialsNonExpired() {
		assertTrue(userDetails.isCredentialsNonExpired());
	}
	@Test
	public void testIsEnabled() {
		assertTrue(userDetails.isEnabled());
	}
	
	@Test
	public void testGetAuthorities() {
		assertNotNull(userDetails.getAuthorities());
	}

}
