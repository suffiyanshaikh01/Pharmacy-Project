package com.webportal.vomodel;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineStockVO {
	// MEDICINE DEMAND VO
	private int medicineId;
	private String medicineName;
	private String chemicalComposition;
	private String targetAilment;
	private LocalDate dateOfExpiry;
	private int numberOfTabletsInStock;
	private String godownName;

}
