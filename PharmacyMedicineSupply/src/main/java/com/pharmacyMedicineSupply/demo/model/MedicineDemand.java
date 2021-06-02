package com.pharmacyMedicineSupply.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//using lombok to generate getters and setters
//Entity class
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDemand {
	//primary key and aut-generated value
	@Id
	@GeneratedValue
	private int medicineDemandId;
	private String medicineName;
	private int demandCount;
	private String status;
}
