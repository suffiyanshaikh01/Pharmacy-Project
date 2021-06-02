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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pharmacies {
	//primary key
	//auto generated value
	@Id
	@GeneratedValue
	private int pharmacyId;
	private String pharmacyName;
}
