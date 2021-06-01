package com.webportal.vomodel;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineStockVO {

			private int medicineId;
			private String medicineName;
			private String chemicalComposition;
			private String targetAilment;
			private LocalDate dateOfExpiry;
			private int numberOfTabletsInStock;
			private String godownName;
		
	
}
