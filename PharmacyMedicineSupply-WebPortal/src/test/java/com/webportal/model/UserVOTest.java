package com.webportal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.webportal.vomodel.UserVO;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class UserVOTest {
	@InjectMocks
	UserVO user;
	@Test
	public void testSetUsernamePositiveCase() {
		log.info("testSetUsernamePositiveCase START");
		user.setUsername("Akshay");
		assertEquals("Akshay", user.getUsername());
		log.info("testSetUsernamePositiveCase END");
	}
	@Test
	public void testSetPasswordPositiveCase() {
		log.info("testSetPasswordPositiveCase START");
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
		log.info("testSetPasswordPositiveCase END");
	}

}
