package com.pharmacyMedicineSupply.demo.exception;

import lombok.NoArgsConstructor;

//Exception class
public class MedicineNotFoundException extends Exception{
	
	
	

	private static final long serialVersionUID = 1L;
	//Exception method
	public MedicineNotFoundException(String message) {
		super(message);
	}
}
