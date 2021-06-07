package com.medicinestock.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicinestock.demo.exception.TreatingAilmentNotFoundException;
import com.medicinestock.demo.model.MedicineStock;
import com.medicinestock.demo.service.MedicineStockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/MedicineStockInformation")
public class MedicineStockController { 
	@Autowired
	MedicineStockService medicineService;
//	This end point is used to provide all the medicines in the stock
	@GetMapping("")
	public ResponseEntity<?> getAllMedicineStock(){
	log.info("Start getAllMedicineStock");
	return new ResponseEntity<>(medicineService.getAllMecidineStock(),HttpStatus.OK);
	
 }
//	This end point is used to update the count of the stock
	@PutMapping("/updateStock/{id}/{count}")
	public ResponseEntity<Boolean> updateStock(@PathVariable int id, @PathVariable int count) {
		log.info("Start updateStock");
		return new ResponseEntity<>(medicineService.updateStock(id,count),HttpStatus.OK);
	}
//	This end point is used to get the medicine by treating ailment
	@GetMapping("/byTreatingAilment/{treatingAilment}")
	public ResponseEntity<String[]> getMedicineByAilment(@PathVariable("treatingAilment") String ailment){
		log.info("Start getMedicineByAilment");
		log.debug("Treating ailment :",ailment);
		String[] medicinesNamesArray = null;
		List<MedicineStock> mlist = medicineService.getMedicineByAilment(ailment); 
		try {
		if(mlist.isEmpty()) {
			throw new TreatingAilmentNotFoundException("Treating Ailment not found !!!!!!!!!!!!");
		}
		} catch(TreatingAilmentNotFoundException treatingAilmentNotFound) {
			log.error(treatingAilmentNotFound.toString());
			return new ResponseEntity<>(medicinesNamesArray,HttpStatus.OK);
		}
		
		log.debug("Medicine List :",mlist);
		List<String> medicineNames = new ArrayList<>();
		for(MedicineStock m : mlist) {
			medicineNames.add(m.getMedicineName());
		}
		log.debug("Medicine Names", medicineNames);
		 medicinesNamesArray = medicineNames.toArray(new String[0]);
		 return new ResponseEntity<>(medicinesNamesArray,HttpStatus.OK);
	}
//	THIS END POINT IS USED TO GET THE MEDICINE BY NAME
	@GetMapping("/get-stock-count/{medicine}")
	public ResponseEntity<MedicineStock> getMedicineStockByMedicineName(@PathVariable String medicine) {
		log.info("Start getMedicineByAilment");
		return new ResponseEntity<>(medicineService.getMedicineStockByMedicineName(medicine), HttpStatus.OK);
	}
	
}












