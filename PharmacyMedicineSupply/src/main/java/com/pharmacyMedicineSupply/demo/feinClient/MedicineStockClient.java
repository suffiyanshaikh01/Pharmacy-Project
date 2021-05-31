package com.pharmacyMedicineSupply.demo.feinClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

@FeignClient("MEDICINESTOCK-SERVICE")
public interface MedicineStockClient {
	
	@GetMapping("/MedicineStockInformation/get-stock-count/{medicine}")
	public ResponseEntity<MedicineStockVO> getMedicineStockByMedicineName(@PathVariable String medicine);
	
	@PutMapping("/MedicineStockInformation/updateStock/{id}/{count}")
	public ResponseEntity<Boolean> updateStock(@PathVariable int id, @PathVariable int count);
}