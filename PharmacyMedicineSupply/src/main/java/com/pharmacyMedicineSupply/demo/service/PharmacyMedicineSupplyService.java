package com.pharmacyMedicineSupply.demo.service;

import java.util.List;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;

//service interface ,these methods are implemented in serviceimpl class
public interface PharmacyMedicineSupplyService {
	//getting the list for medicinesupply depending on the medicinedemand
	List<PharmacyMedicineSupply> getPharmacySupplyList(MedicineDemand medDemand);
	//getting the list of all pharmacySupply
	List<PharmacyMedicineSupply> getAllPharmacySupply();
	//getting the list of all medicines dependingon the demand
	List<MedicineDemand> getDemand();

		
}
