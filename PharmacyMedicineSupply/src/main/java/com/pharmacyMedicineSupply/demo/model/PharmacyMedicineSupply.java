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
//Entity Class
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class PharmacyMedicineSupply {
	//primary key
	//auto generated value
	@Id
	@GeneratedValue
	private int pharmacyMedicineSupplyId;
	private String pharmacyName;
	private String medicineName;
	private int supplyCount;
}
