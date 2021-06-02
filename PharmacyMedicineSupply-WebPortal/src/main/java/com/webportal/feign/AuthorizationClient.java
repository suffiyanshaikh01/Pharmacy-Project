package com.webportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.webportal.vomodel.UserVO;

@FeignClient("AUTHORIZATION-SERVICE")
public interface AuthorizationClient {

	//GETTING TOKEN
	@PostMapping("/login/getToken")
	public String createAuthenticationToken(@RequestBody UserVO authenticationRequest);
	
	//VERIFY USERNAME AND PASSWORD
	@GetMapping("/login/")
	public Boolean validateToken(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
