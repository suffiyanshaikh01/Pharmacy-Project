package com.pharmacyMedicineSupply.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pharmacies {
	@Id
	@GeneratedValue
	private int pharmacyId;
	private String pharmacyName;
}
