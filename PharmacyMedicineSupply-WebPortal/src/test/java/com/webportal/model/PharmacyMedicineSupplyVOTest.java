package com.webportal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import com.webportal.vomodel.PharmacyMedicineSupplyVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PharmacyMedicineSupplyVOTest {

	@InjectMocks
	PharmacyMedicineSupplyVO supplyObj;
	
	@Test
	public void TestConstructor() {
		PharmacyMedicineSupplyVO supply=new PharmacyMedicineSupplyVO("Med-Life","Dolo-650",500);
	}

	@Test
	public void testSetMedicineNamePositiveCase() {
		log.info("testSetMedicineNamePositiveCase START");
		supplyObj.setMedicineName("Dolo650");
		assertEquals("Dolo650", supplyObj.getMedicineName());
		log.info("testSetMedicineNamePositiveCase END");
	}
	@Test
	public void testSetPharmacyNamePositiveCase() {
		log.info("testSetPharmacyNamePositiveCase START");
		supplyObj.setPharmacyName("Med-life");
		assertEquals("Med-life", supplyObj.getPharmacyName());
		log.info("testSetPharmacyNamePositiveCase END");
	}
	@Test
	public void testSetSupplyCountPositiveCase() {
		log.info("testSetSupplyCountPositiveCase START");
		supplyObj.setSupplyCount(12);
		assertEquals(12, supplyObj.getSupplyCount());
		log.info("testSetSupplyCountPositiveCase END");
	}


}
