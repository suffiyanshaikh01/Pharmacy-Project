package com.medicalRepSchedule.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

	private int docId;
	private String docName;
	private String docContactNumber;
	private String treatingAilment;
}
