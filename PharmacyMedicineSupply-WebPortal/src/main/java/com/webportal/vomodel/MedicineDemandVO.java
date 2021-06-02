package com.webportal.vomodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDemandVO {
	
	//MEDICINE DEMAND VO
	private String medicineName;
	private int demandCount;
	private String status;
}
