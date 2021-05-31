package com.pharmacyMedicineSupply.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pharmacyMedicineSupply.demo.feinClient.MedicineStockClient;
import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class PharmacyMedicineSuppyService {

	@Autowired
	PharmacyMedicineSupplyServiceImpl pharmacyService;
//	@InjectMocks
//	PharmacyMedicineSupplyServiceImpl pharmacyServiceInjected;
	
	@Mock
	MedicineDemand medDemandPositive, medDemandNegative;
	@Mock
	MedicineStockClient medicineStockClient;
	@Mock
	List<MedicineDemand> medDemandList;
	@Mock
	PharmacyMedicineSupply pharmacyMedicineSupply;
	@Mock
	List<PharmacyMedicineSupply> pharmacyMedicineSupplyList;
	@Mock
	MedicineStockVO medicineStock;
	private LocalDate date = LocalDate.of(2022, 9, 12);
	
	@Test
	public void contextLoads() {
		assertNotNull(pharmacyService);
	}

	@Before
	public void setup() {
		log.info("START");
		medDemandPositive.setMedicineDemandId(1);
		medDemandPositive.setMedicineName("Crocin");
		medDemandPositive.setDemandCount(1);
		medDemandPositive.setStatus("");
		medDemandNegative.setMedicineDemandId(1);
		medDemandNegative.setMedicineName("XYZ");
		medDemandNegative.setDemandCount(20);
		medDemandNegative.setStatus("");
		medicineStock = new MedicineStockVO();
		medicineStock.setMedicineId(1);
		medicineStock.setMedicineName("Crocin");
		medicineStock.setChemicalComposition("disaccharide gentiobiose, dicarboxylic acid crocetin");
		medicineStock.setTargetAilment("General");
		medicineStock.setGodownName("Healthy Pharmacy");
		medicineStock.setDateOfExpiry(date);
		medicineStock.setNumberOfTabletsInStock(200);
		pharmacyMedicineSupply.setPharmacyMedicineSupplyId(1);
		pharmacyMedicineSupply.setMedicineName("Crocin");
		pharmacyMedicineSupply.setPharmacyName("Newlife Medical");
		pharmacyMedicineSupply.setSupplyCount(1);
		pharmacyMedicineSupplyList.add(pharmacyMedicineSupply);
		log.info("END");
	}
	
	@Test
	public void testGetPharmacySupplyListPositive() {
		log.info("testGetPharmacySupplyListPositiveCase START");
		when(medicineStockClient.getMedicineStockByMedicineName(medDemandPositive.getMedicineName()))
				.thenReturn(new ResponseEntity<MedicineStockVO>(medicineStock,HttpStatus.OK));
		ResponseEntity<MedicineStockVO> medicineStockByMedicineName = medicineStockClient.getMedicineStockByMedicineName(medDemandPositive.getMedicineName());
		MedicineStockVO medicineByName = medicineStockByMedicineName.getBody();
		assertNotNull(medicineByName);
		log.info("testGetPharmacySupplyListPositiveCase END");
	}
	
	@Test
	public void testGetPharmacySupplyListNegativeCase() {
		log.info("testGetPharmacySupplyListNegativeCase START");
		MedicineStockVO nullStock = null;
		when(medicineStockClient.getMedicineStockByMedicineName(medDemandNegative.getMedicineName()))
				.thenReturn(new ResponseEntity<MedicineStockVO>(nullStock,HttpStatus.OK));
		ResponseEntity<MedicineStockVO> medicineStockByMedicineName = medicineStockClient.getMedicineStockByMedicineName(medDemandNegative.getMedicineName());
		MedicineStockVO medicineByName = medicineStockByMedicineName.getBody();
		assertNull(medicineByName);
		log.info("testGetPharmacySupplyListNegativeCase END");
	}
	
	@Test
	public void testGetAllPharmacySupplyPositiveCase() {
		log.info("testGetAllPharmacySupplyPositiveCase START");
		List<PharmacyMedicineSupply> allPharmacySupply = pharmacyService.getAllPharmacySupply();
		assertNotNull(allPharmacySupply);
		log.info("testGetAllPharmacySupplyPositiveCase END");
	}
	
	@Test
	public void testGetDemandPositiveCase() {
		log.info("testGetDemandPositiveCase START");
		List<MedicineDemand> demand = pharmacyService.getDemand();
		assertNotNull(demand);
		log.info("testGetDemandPositiveCase END");
	}
	
	
	
	
	
	
}






















