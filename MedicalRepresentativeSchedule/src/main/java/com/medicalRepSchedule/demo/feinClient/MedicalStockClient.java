package com.medicalRepSchedule.demo.feinClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MEDICINESTOCK-SERVICE")
public interface MedicalStockClient {
	//THIS IS FEIGN CLIENT TO ACCESS DATA FROM MEDICINESTOCKSERVICE
	//THIS METHOD PROVIDES NAME OF TABLETS ACCORDING TO THE AILMENT GIVEN
	@GetMapping("/MedicineStockInformation/byTreatingAilment/{treatingAilment}")
	public ResponseEntity<String[]> getMedicineByAilment(@PathVariable("treatingAilment") String ailment);
}
