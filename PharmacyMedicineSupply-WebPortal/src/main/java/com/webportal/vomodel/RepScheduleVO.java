package com.webportal.vomodel;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
public class RepScheduleVO {
	private String repName;
	private String docName;
	private String teatingAilment;
	private String medicineName;
	private String slot;
	private LocalDate date;
	private String docContactNumber;
}
