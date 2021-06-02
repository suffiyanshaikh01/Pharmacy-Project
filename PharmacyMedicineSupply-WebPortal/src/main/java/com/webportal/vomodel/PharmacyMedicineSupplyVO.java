package com.webportal.vomodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyMedicineSupplyVO {
	//MEDICINE SUPPLY VO
	private String pharmacyName;
	private String medicineName;
	private int supplyCount;

}
