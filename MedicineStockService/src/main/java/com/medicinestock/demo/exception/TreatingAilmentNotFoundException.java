package com.medicinestock.demo.exception;

public class TreatingAilmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
//	USED TO THROW USER DEFINED EXCEPTION WHEN THE TREATING AILMENT IS NOT FOUND
	public TreatingAilmentNotFoundException(String message) {
		super(message);
	}

}
