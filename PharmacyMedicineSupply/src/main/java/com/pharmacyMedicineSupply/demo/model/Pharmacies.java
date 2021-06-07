package com.pharmacyMedicineSupply.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "pharmacies_table")
public class Pharmacies {
	//primary key
	//auto generated value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pharmacyId;
	private String pharmacyName;
}
