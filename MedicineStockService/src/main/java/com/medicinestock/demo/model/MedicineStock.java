package com.medicinestock.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medicine_stock")
public class MedicineStock {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int medicineId;
		private String medicineName;
		private String chemicalComposition;
		private String targetAilment;
		private LocalDate dateOfExpiry;
		private int numberOfTabletsInStock;
		private String godownName;
		
		
	
}
