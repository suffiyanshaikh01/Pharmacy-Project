package com.pharmacyMedicineSupply.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.service.PharmacyMedicineSupplyServiceImpl;
import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PharmacyMedicineSupplyControllerTest {
	//injecting the pharmacycontroller and mocking its rest of the services
	@InjectMocks
	PharmacySupplyController pharmacyController;

	@Mock
	List<MedicineDemand> medDemandList;
	@Mock
	PharmacyMedicineSupply pharmacyMedicineSupply;
	List<PharmacyMedicineSupply> pharmacyMedicineSupplyList;
	@Mock
	MedicineStockVO medicineStock;
	@Mock
	PharmacyMedicineSupplyServiceImpl pharmacyService;

	@Test
	public void contextLoads() {
		assertNotNull(pharmacyController);
	}
	//positive test case to test pharmacysupply list
	@Test
	public void testGetPharmacySupplyPositiveCase() {
		log.info("testGetPharmacySupplyPositiveCase START");
		MedicineDemand medDemandPositive = new MedicineDemand(1, "Dolo-650", 300, "Approved");
		ResponseEntity<List<PharmacyMedicineSupply>> pharmacySupply = pharmacyController
				.getPharmacySupply(medDemandPositive);
		assertEquals(HttpStatus.OK, pharmacySupply.getStatusCode());
		assertNotNull(pharmacySupply.getBody());
		log.info("testGetPharmacySupplyPositiveCase END");
	}
	//negative test case to test pharmacysupply list
	@Test
	public void testGetPharmacySupplyNeagtiveCase() {
		log.info("testGetPharmacySupplyNeagtiveCase START");
		MedicineDemand medDemandNegative = new MedicineDemand(1, "XYZ", 300, "");
		ResponseEntity<List<PharmacyMedicineSupply>> pharmacySupply = pharmacyController
				.getPharmacySupply(medDemandNegative);
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, pharmacySupply.getStatusCode());
		log.info("testGetPharmacySupplyNeagtiveCase END");
	}
	//positive test case to test allpharmacysupply list
	@Test
	public void testGetAllPharmacySupplyPositiveCase() {
		log.info("testGetAllPharmacySupplyPositiveCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> allPharmacySupply = pharmacyController.getAllPharmacySupply();
		assertEquals(HttpStatus.OK, allPharmacySupply.getStatusCode());
		assertNotNull(allPharmacySupply.getBody());
		log.info("testGetAllPharmacySupplyPositiveCase END");
	}
	//negative test case to test allpharmacysupply list
	@Test
	public void testGetAllPharmacySupplyNegativeCase() {
		log.info("testGetAllPharmacySupplyNegativeCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> allPharmacySupply = pharmacyController.getAllPharmacySupply();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, allPharmacySupply.getStatusCode());
		log.info("testGetAllPharmacySupplyNegativeCase END");
	}
	//postive test case to check the demand status 
	@Test
	public void testGetDemandPositiveCase() {
		log.info("testGetDemandPositiveCase START");
		ResponseEntity<List<MedicineDemand>> demand = pharmacyController.getDemand();
		assertEquals(HttpStatus.OK, demand.getStatusCode());
		assertNotNull(demand.getBody());
		log.info("testGetDemandPositiveCase END");
	}
	//negative test case to test demand status 
	@Test
	public void testGetDemandNegativeCase() {
		log.info("testGetDemandNegativeCase START");
		ResponseEntity<List<MedicineDemand>> demand = pharmacyController.getDemand();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, demand.getStatusCode());
		log.info("testGetDemandNegativeCase END");
	}
}
