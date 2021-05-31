package com.webportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.webportal.vomodel.UserVO;

@FeignClient("AUTHORIZATION-SERVICE")
public interface AuthorizationClient {
//	@GetMapping("/{userName}/{password}")
//	public boolean login(@PathVariable String userName, @PathVariable String password);
//
//	@GetMapping("/{userName}")
//	public UserVO getByUserName(@PathVariable String userName);

	@PostMapping("/login/getToken")
	public String createAuthenticationToken(@RequestBody UserVO authenticationRequest);
	
	@GetMapping("/login/")
	public Boolean validateToken(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
//	when(authenticationFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", true));
}