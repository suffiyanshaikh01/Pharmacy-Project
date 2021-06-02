package com.medicinestock.demo.service;

import java.util.List;

import com.medicinestock.demo.model.MedicineStock;

//	THIS IS MEDICINE SERVICE INTERFACE WITH CONTAINS ALL THE METHODS
public interface MedicineStockService {

	List<MedicineStock> getAllMecidineStock();


	boolean updateStock(int id, int count);

	List<MedicineStock> getMedicineByAilment(String ailment);

	MedicineStock getMedicineStockByMedicineName(String medicine);

}
