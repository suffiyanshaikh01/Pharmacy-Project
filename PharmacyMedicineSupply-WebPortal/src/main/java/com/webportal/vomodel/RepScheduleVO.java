package com.webportal.vomodel;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
	import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RepScheduleVO {
	//REPSCHEDULE VO
	private String repName;
	private String docName;
	private String teatingAilment;
	private String medicineName;
	private String slot;
	private LocalDate date;
	private String docContactNumber;
}
