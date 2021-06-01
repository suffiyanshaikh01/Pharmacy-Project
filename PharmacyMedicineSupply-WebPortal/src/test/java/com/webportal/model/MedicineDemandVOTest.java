package com.webportal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.webportal.vomodel.MedicineDemandVO;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class MedicineDemandVOTest {

	@InjectMocks 
	MedicineDemandVO demandObj;
	@Test
	public void testSetDemandCountPositiveCase() {
		log.info("testSetDemandCountPositiveCase START");
		demandObj.setDemandCount(100);
		assertEquals(100,demandObj.getDemandCount());
		log.info("testSetDemandCountPositiveCase END"); 
	}
	@Test
	public void testSetMedicineNamePositiveCase() {
		log.info("testSetMedicineNamePositiveCase START");
		demandObj.setMedicineName("Crocin");
		assertEquals("Crocin",demandObj.getMedicineName());
		log.info("testSetMedicineNamePositiveCase END");
	}
	@Test
	public void testSetStatusPositiveCase() {
		log.info("testSetStatusPositiveCase START");
		demandObj.setStatus("Accepted");
		assertEquals("Accepted",demandObj.getStatus());
		log.info("testSetStatusPositiveCase END");
	}
	

}
