package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.webportal.vomodel.MedicineStockVO;


//@FeignClient("MEDICINESTOCK-SERVICE")
@FeignClient(url="http://ij018pod4medicinestockservice-env.eba-jryu3jpu.us-east-2.elasticbeanstalk.com", name = "MEDICINESTOCK-SERVICE")
public interface MedicineStockClient {
	
	//GETTING STOCK DATA
	@GetMapping("/MedicineStockInformation")
	public ResponseEntity<List<MedicineStockVO>> getAllMedicineStock();
}
