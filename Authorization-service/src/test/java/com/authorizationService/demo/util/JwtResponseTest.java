package com.authorizationService.demo.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationService.demo.jwt.JwtResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class JwtResponseTest {
	@InjectMocks
	JwtResponse jwtResponse = new JwtResponse("token");
	@Test
	void testJwtToken() {
		log.info("testJwtToken START");
		String string = jwtResponse.toString();
		assertEquals("token", jwtResponse.getJwttoken());
		assertNotNull(string);
		log.info("testJwtToken END");

	}

}
