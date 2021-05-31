package com.medicalRepSchedule.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class RepSchedule {
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
