package com.medicinestock.demo.service;

import java.util.List;

import com.medicinestock.demo.model.MedicineStock;

public interface MedicineStockService {

	List<MedicineStock> getAllMecidineStock();

	MedicineStock addMedicine(MedicineStock medicine);

	boolean updateStock(int id, int count);

	List<MedicineStock> getMedicineByAilment(String ailment);

	MedicineStock getMedicineStockByMedicineName(String medicine);

}