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

@RestController
@RequestMapping("/PharmacySupply")
public class PharmacySupplyController {
		@Autowired
		PharmacyMedicineSupplyService pharmacySupplyService;
		@PostMapping("")
		public ResponseEntity<List<PharmacyMedicineSupply>> getPharmacySupply(@RequestBody MedicineDemand medDemand){
			return new ResponseEntity<>(pharmacySupplyService.getPharmacySupplyList(medDemand),HttpStatus.OK);
		} 
		
		@GetMapping("/getAllOrders")
		public ResponseEntity<List<PharmacyMedicineSupply>> getAllPharmacySupply()
		{
//			return pharmacySupplyService.getAllPharmacySupply();
			return new ResponseEntity<>(pharmacySupplyService.getAllPharmacySupply(),HttpStatus.OK);
		}
		
		@GetMapping("/getDemand")
		public ResponseEntity<List<MedicineDemand>> getDemand(){
			return new ResponseEntity<>(pharmacySupplyService.getDemand(),HttpStatus.OK);
		}
}
