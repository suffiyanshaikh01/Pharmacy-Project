package com.pharmacyMedicineSupply.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.service.PharmacyMedicineSupplyService;

//controller class 
@RestController
@RequestMapping("/PharmacySupply")
public class PharmacySupplyController {
		//Autowiring the pharmacysupplyservice of service method
		@Autowired
		PharmacyMedicineSupplyService pharmacySupplyService;
		//checking the medicine is present in our stock or not through medicine name through post mapping and by using response entity
		@PostMapping("")
		public ResponseEntity<List<PharmacyMedicineSupply>> getPharmacySupply(@RequestBody MedicineDemand medDemand){
			return new ResponseEntity<>(pharmacySupplyService.getPharmacySupplyList(medDemand),HttpStatus.OK);
		} 
		//getting all the orders that are placed through getmaapping and by using response entity
		@GetMapping("/getAllOrders")
		public ResponseEntity<List<PharmacyMedicineSupply>> getAllPharmacySupply()
		{
//			return pharmacySupplyService.getAllPharmacySupply();
			return new ResponseEntity<>(pharmacySupplyService.getAllPharmacySupply(),HttpStatus.OK);
		}
		// returns the specific demanding medicine if it is present in our stock
		@GetMapping("/getDemand")
		public ResponseEntity<List<MedicineDemand>> getDemand(){
			return new ResponseEntity<>(pharmacySupplyService.getDemand(),HttpStatus.OK);
		}
}
