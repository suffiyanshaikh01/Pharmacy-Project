//package com.authorizationService.demo.util;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.function.Function;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//
//import com.authorizationService.demo.jwt.JwtUtil;
//
//import io.jsonwebtoken.Claims;
//
//class JwtUtilTest {
//
//	@InjectMocks
//	JwtUtil jwtUtil;
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testGetUsernameFromToken() {
//		
//		Claims claims = null;
//		when(jwtUtil.getAllClaimsFromToken("token"))
//		.thenReturn(claims);
//		Function<Claims, T> claimsResolver;
//		when(jwtUtil.getClaimFromToken("token", claimsResolver))
//		
//		String usernameFromToken = jwtUtil.getUsernameFromToken("token");
//		assertNotNull(usernameFromToken);
//	}
//
//	
//	
//	
//}
//
//
