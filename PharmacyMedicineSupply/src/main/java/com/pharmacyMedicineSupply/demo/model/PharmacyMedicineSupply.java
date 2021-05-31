package com.pharmacyMedicineSupply.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PharmacyMedicineSupply {
		@Id
		@GeneratedValue
		private int pharmacyMedicineSupplyId;
		private String pharmacyName;
		private String medicineName;
		private int supplyCount;
}
