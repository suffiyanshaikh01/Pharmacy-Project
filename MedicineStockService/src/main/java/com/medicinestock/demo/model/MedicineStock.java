package com.medicinestock.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MedicineStock {
		@Id
		@GeneratedValue
		private int medicineId;
		private String medicineName;
		private String chemicalComposition;
		private String targetAilment;
		private LocalDate dateOfExpiry;
		private int numberOfTabletsInStock;
		private String godownName;
	
}
