package com.medicalRepSchedule.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	//THIS MODEL IS USED AS VO CLASS TO STORE DATA OD DOCTORS TEMPORARILY
	private int docId;
	private String docName;
	private String docContactNumber;
	private String treatingAilment;
}
