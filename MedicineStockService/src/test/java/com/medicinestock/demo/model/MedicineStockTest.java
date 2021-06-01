package com.medicinestock.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MedicineStockTest {
		
	@InjectMocks
	MedicineStock stockObj;
	
	
	@Test
	public void testSetChemicalCompositionPositiveCase() {
		log.info("testSetChemicalCompositionPositiveCase START");
		stockObj.setChemicalComposition("x,y,z");
		assertEquals("x,y,z",stockObj.getChemicalComposition());
		log.info("testSetChemicalCompositionPositiveCase END");
	}
	
	@Test
	public void testSetDateOfExpiryPositiveCase() {
		log.info("testSetDateOfExpiryPositiveCase START");
		LocalDate date = LocalDate.of(2021, 06, 26);
		stockObj.setDateOfExpiry(date);
		assertEquals(LocalDate.of(2021, 06, 26),stockObj.getDateOfExpiry());
		log.info("testSetDateOfExpiryPositiveCase END");
	}
	@Test
	public void testSetGodownNamePositiveCase() {
		log.info("testSetGodownNamePositiveCase START");
		stockObj.setGodownName("OmSai");
		assertEquals("OmSai",stockObj.getGodownName());
		log.info("testSetGodownNamePositiveCase END");
	}
	@Test
	public void testSetMedicineIdPositiveCase() {
		log.info("testSetMedicineIdPositiveCase START");
		stockObj.setMedicineId(1);
		assertEquals(1,stockObj.getMedicineId());
		log.info("testSetMedicineIdPositiveCase END");
	}
	@Test
	public void testSetMedicineNamePositiveCase() {
		log.info("testSetMedicineNamePositiveCase START");
		stockObj.setMedicineName("Crocin");
		assertEquals("Crocin",stockObj.getMedicineName());
		log.info("testSetMedicineNamePositiveCase END");
	}
	@Test
	public void testSetNumberOfTabletsInStockPositiveCase() {
		log.info("testSetNumberOfTabletsInStockPositiveCase START");
		stockObj.setNumberOfTabletsInStock(200);
		assertEquals(200,stockObj.getNumberOfTabletsInStock());
		log.info("testSetNumberOfTabletsInStockPositiveCase END");
	}
	@Test
	public void testSetTargetAilmentPositiveCase() {
		log.info("testSetTargetAilmentPositiveCase START");
		stockObj.setTargetAilment("General");
		assertEquals("General",stockObj.getTargetAilment());
		log.info("testSetTargetAilmentPositiveCase END");
	}
	

}
