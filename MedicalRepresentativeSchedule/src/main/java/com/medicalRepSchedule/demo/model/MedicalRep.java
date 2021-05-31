package com.medicalRepSchedule.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MedicalRep {
	@Id
	@GeneratedValue
	private int repId;
	private String repName;
	private String repContactNumber;

}
