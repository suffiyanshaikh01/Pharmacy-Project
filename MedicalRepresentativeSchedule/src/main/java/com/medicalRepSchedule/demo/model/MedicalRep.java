package com.medicalRepSchedule.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_rep")
public class MedicalRep {
	// THIS ENTITY IS USED FOR STORING REPRESENTATIVE DATA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int repId;
	private String repName;
	private String repContactNumber;

}
