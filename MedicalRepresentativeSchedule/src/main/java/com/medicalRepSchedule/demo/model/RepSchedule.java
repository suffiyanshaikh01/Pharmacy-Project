package com.medicalRepSchedule.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepSchedule {
	// THIS ENTITY IS USED TO STORE THE SCHEDULES WHICH WERE CREATED
	@Id
	@GeneratedValue
	private int repScheduleId;
	private String repName;
	private String docName;
	private String teatingAilment;
	private String medicineName;
	private String slot;
	private LocalDate date;
	private String docContactNumber;

}
