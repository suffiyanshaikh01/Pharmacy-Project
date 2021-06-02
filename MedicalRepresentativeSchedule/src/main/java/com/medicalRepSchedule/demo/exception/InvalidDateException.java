package com.medicalRepSchedule.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;
	//THIS EXCEPTION WILL BE RAISED WHEN THE DATE IS INVALID
	public InvalidDateException(String message) {

		super(message);
		log.info("INSIDE INVALID DATE EXCEPTION");
	}
}