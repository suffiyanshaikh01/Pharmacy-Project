package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.webportal.vomodel.MedicineStockVO;


@FeignClient("MEDICINESTOCK-SERVICE")
public interface MedicineStockClient {
	
	
	@GetMapping("/MedicineStockInformation")
	public ResponseEntity<List<MedicineStockVO>> getAllMedicineStock();
}
