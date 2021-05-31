package com.authorizationService.demo.jwt;

public class JwtResponse {

	private final String jwttoken;

	public String getJwttoken() {
		return jwttoken;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + "]";
	}

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}


}
