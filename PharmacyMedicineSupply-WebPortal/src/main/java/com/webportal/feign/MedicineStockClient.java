package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.webportal.vomodel.MedicineStockVO;


@FeignClient("MEDICINESTOCK-SERVICE")
public interface MedicineStockClient {
	
	
	@GetMapping("/MedicineStockInformation")
	public ResponseEntity<List<MedicineStockVO>> getAllMedicineStock();
}
