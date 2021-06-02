package com.medicinestock.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicinestock.demo.model.MedicineStock;
import com.medicinestock.demo.repository.MedicineStockRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
// THIS IS THE MEDICINE SERVICE IMPLEMENTATION CLASS WITH IMPLEMENTS ALL THE METHODS
public class MedicineStockServiceImpl implements MedicineStockService {
	@Autowired
	MedicineStockRepository medicineRepo;
	
//	THIS METHOD IS USED TO RETURN ALL THE MEDICINE FROM THE DATABASE
	@Override
	public List<MedicineStock> getAllMecidineStock() {
		log.info("end getAllMedicineStock");
		return medicineRepo.findAll();
	}

	
//	THIS METHOD UPDATES THE MEDICINE OBJECT BY TAKING THE MEDICINE ID AND THE NEW COUNT AS INPUT
	@Override
	public boolean updateStock(int id, int count) {
		int rowsUpdated = medicineRepo.updateStock(id,count);
		if(rowsUpdated==0) {
			log.info("End updateStock");
			return false;
		}
		else {
			log.info("End updateStock");
			return true;
		}
	}
//	THIS METHOD RETURNS THE LIST OF MEDICINE OBJECTS WITH THE GIVEN TREATING AILMENT
	@Override
	public List<MedicineStock> getMedicineByAilment(String ailment) {
		log.info("End getMedicineByAilment");
		return medicineRepo.getMedicineByAilment(ailment);
	}
//	THIS METHOD RETURNS THE MEDICINE OBJECT WITH THE GIVEN MEDICINE NAME
	@Override
	public MedicineStock getMedicineStockByMedicineName(String medicine) {
		log.info("End getMedicineByAilment");
		return medicineRepo.getMedicineStockByMedicineName(medicine);
	}

}
