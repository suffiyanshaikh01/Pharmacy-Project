package com.pharmacyMedicineSupply.demo.feinClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

//using feignclient for medicine stock service
//@FeignClient("MEDICINESTOCK-SERVICE")
@FeignClient(url="http://ij018pod4medicinestockservice-env.eba-jryu3jpu.us-east-2.elasticbeanstalk.com", name = "MEDICINESTOCK-SERVICE")
public interface MedicineStockClient {
	
	//returns the specific stock count of medicine searched
	@GetMapping("/MedicineStockInformation/get-stock-count/{medicine}")
	public ResponseEntity<MedicineStockVO> getMedicineStockByMedicineName(@PathVariable String medicine);
	
	//updating the count of that medicine of that method where id is provided
	@PutMapping("/MedicineStockInformation/updateStock/{id}/{count}")
	public ResponseEntity<Boolean> updateStock(@PathVariable int id, @PathVariable int count);
}
