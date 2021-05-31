package com.medicalRepSchedule.demo.feinClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MEDICINESTOCK-SERVICE")
//@FeignClient("http://MEDICINESTOCK-SERVICE/MedicineStockInformationMed")
public interface MedicalStockClient {
	
	@GetMapping("/MedicineStockInformation/byTreatingAilment/{treatingAilment}")
	public ResponseEntity<String[]> getMedicineByAilment(@PathVariable("treatingAilment") String ailment);
}