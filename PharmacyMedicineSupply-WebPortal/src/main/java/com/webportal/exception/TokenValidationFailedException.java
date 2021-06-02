package com.webportal.exception;

public class TokenValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//INVALID TOKEN EXCEPTION
	public TokenValidationFailedException(String message) {
		super(message);
	}

}
