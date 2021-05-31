package com.pharmacyMedicineSupply.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class MedicineDemand {
	@Id
	@GeneratedValue
	private int medicineDemandId;
	private String medicineName;
	private int demandCount;
	private String status;
}
