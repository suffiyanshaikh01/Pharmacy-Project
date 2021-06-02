package com.pharmacyMedicineSupply.demo.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Value Object class for feignclient(Medicine stock service)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicineStockVO {

			private int medicineId;
			private String medicineName;
			private String chemicalComposition;
			private String targetAilment;
			private LocalDate dateOfExpiry;
			private int numberOfTabletsInStock;
			private String godownName;
		
	
}
