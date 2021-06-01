package com.medicinestock.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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
		@Override
		public String toString() {
			return "MedicineStock [medicineId=" + medicineId + ", medicineName=" + medicineName
					+ ", chemicalComposition=" + chemicalComposition + ", targetAilment=" + targetAilment
					+ ", dateOfExpiry=" + dateOfExpiry + ", numberOfTabletsInStock=" + numberOfTabletsInStock
					+ ", godownName=" + godownName + "]";
		}
		
	
}
