package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webportal.vomodel.MedicineDemandVO;
import com.webportal.vomodel.PharmacyMedicineSupplyVO;



@FeignClient("PHARMACYSUPPLY-SERVICE")
public interface PharmacySupplyClient {
	
	//GETTING ALL ORDERS
	@GetMapping("/PharmacySupply/getAllOrders")
	public ResponseEntity<List<PharmacyMedicineSupplyVO>> getAllPharmacySupply();
	
	//PLACING ORDER
	@PostMapping("/PharmacySupply")
	public ResponseEntity<List<PharmacyMedicineSupplyVO>> getPharmacySupply(@RequestBody MedicineDemandVO medDemand);
	
	//GETTING DEMAND HISTORY
	@GetMapping("/PharmacySupply/getDemand")
	public ResponseEntity<List<MedicineDemandVO>> getDemand();

}
