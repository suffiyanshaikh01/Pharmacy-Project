//package com.authorizationService.demo.util;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.authorizationService.demo.jwt.JwtUtil;
//
//import lombok.extern.slf4j.Slf4j;
//@Slf4j
//@SpringBootTest
//class JwtRequestFilter {
//	@InjectMocks
//	JwtRequestFilter jwtFilter;
//	@Mock
//	JwtUtil util;
//	
//	@Test
//	void testDoFilterInternal() {
//		when(util.getUsernameFromToken("token"))
//		.thenReturn(value)
//	}
//
//}
