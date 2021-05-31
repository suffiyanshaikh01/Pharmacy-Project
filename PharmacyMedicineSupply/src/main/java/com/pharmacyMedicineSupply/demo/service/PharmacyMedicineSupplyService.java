package com.pharmacyMedicineSupply.demo.service;

import java.util.List;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;

public interface PharmacyMedicineSupplyService {

	List<PharmacyMedicineSupply> getPharmacySupplyList(MedicineDemand medDemand);

	List<PharmacyMedicineSupply> getAllPharmacySupply();

	List<MedicineDemand> getDemand();

		
}
