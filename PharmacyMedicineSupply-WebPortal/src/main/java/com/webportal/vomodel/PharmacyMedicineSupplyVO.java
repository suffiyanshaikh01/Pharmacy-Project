package com.webportal.vomodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PharmacyMedicineSupplyVO {
	private String pharmacyName;
	private String medicineName;
	private int supplyCount;

}
