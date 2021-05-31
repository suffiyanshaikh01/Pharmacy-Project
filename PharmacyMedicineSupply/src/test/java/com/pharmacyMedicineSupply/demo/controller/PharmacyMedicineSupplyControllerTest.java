package com.pharmacyMedicineSupply.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.service.PharmacyMedicineSupplyServiceImpl;
import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class PharmacyMedicineSupplyControllerTest {

	@InjectMocks
	PharmacySupplyController pharmacyController;
	@Mock
	MedicineDemand medDemandPositive, medDemandNegative;
	@Mock
	List<MedicineDemand> medDemandList;
	@Mock
	PharmacyMedicineSupply pharmacyMedicineSupply;
	@Mock
	List<PharmacyMedicineSupply> pharmacyMedicineSupplyList;
	@Mock
	MedicineStockVO medicineStock;
	@Mock
	PharmacyMedicineSupplyServiceImpl pharmacyService;
	
	@Test
	public void contextLoads() {
		assertNotNull(pharmacyController);
	}

	@Before
	public void setup() {
		log.info("START");
		medDemandPositive.setMedicineDemandId(1);
		medDemandPositive.setMedicineName("Crocin");
		medDemandPositive.setDemandCount(20);
		medDemandPositive.setStatus("");
		medDemandNegative.setMedicineDemandId(1);
		medDemandNegative.setMedicineName("XYZ");
		medDemandNegative.setDemandCount(20);
		medDemandNegative.setStatus("");
		log.info("END");
	}

	@Test
	public void testGetPharmacySupplyPositiveCase() {
		log.info("testGetPharmacySupplyPositiveCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> pharmacySupply = pharmacyController
				.getPharmacySupply(medDemandPositive);
		assertEquals(HttpStatus.OK, pharmacySupply.getStatusCode());
		assertNotNull(pharmacySupply.getBody());
		log.info("testGetPharmacySupplyPositiveCase END");
	}

	@Test
	public void testGetPharmacySupplyNeagtiveCase() {
		log.info("testGetPharmacySupplyNeagtiveCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> pharmacySupply = pharmacyController
				.getPharmacySupply(medDemandNegative);
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, pharmacySupply.getStatusCode());
		log.info("testGetPharmacySupplyNeagtiveCase END");
	}
	
	@Test
	public void testGetAllPharmacySupplyPositiveCase() {
		log.info("testGetAllPharmacySupplyPositiveCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> allPharmacySupply = pharmacyController.getAllPharmacySupply();
		assertEquals(HttpStatus.OK, allPharmacySupply.getStatusCode());
		assertNotNull(allPharmacySupply.getBody());
		log.info("testGetAllPharmacySupplyPositiveCase END");
	}
	
	@Test
	public void testGetAllPharmacySupplyNegativeCase() {
		log.info("testGetAllPharmacySupplyNegativeCase START");
		ResponseEntity<List<PharmacyMedicineSupply>> allPharmacySupply = pharmacyController.getAllPharmacySupply();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, allPharmacySupply.getStatusCode());
		log.info("testGetAllPharmacySupplyNegativeCase END");
	}
	
	@Test
	public void testGetDemandPositiveCase() {
		log.info("testGetDemandPositiveCase START");
		ResponseEntity<List<MedicineDemand>> demand = pharmacyController.getDemand();
		assertEquals(HttpStatus.OK, demand.getStatusCode());
		assertNotNull(demand.getBody());
		log.info("testGetDemandPositiveCase END");
	}
	
	@Test
	public void testGetDemandNegativeCase() {
		log.info("testGetDemandNegativeCase START");
		ResponseEntity<List<MedicineDemand>> demand = pharmacyController.getDemand();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, demand.getStatusCode());
		log.info("testGetDemandNegativeCase END");
	}
}

















