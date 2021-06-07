package com.pharmacyMedicineSupply.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
//test class to test model classes
@SpringBootTest
@Slf4j
public class MedicineDemandTest {
	@InjectMocks
	MedicineDemand medicinedemand;
	//testcontructor 
	@Test
	public void TestConstructor() {
		MedicineDemand medicinedemand=new MedicineDemand(1,"Dolo-650",300,"Approved");
	}
	// test case to test demandId of the entity class
	@Test
	public void testMedicineDemandID() {
		log.info("Medicinedemandid test case START");
		medicinedemand.setMedicineDemandId(1);
		assertEquals(1, medicinedemand.getMedicineDemandId());
		log.info("Medicinedemandid test case END");
	}
	// test method to test medicinename of the entity class 
	@Test
	public void testMedicineName() {
		log.info("MedicineName test case START");
		medicinedemand.setMedicineName("Crocin");
		assertEquals("Crocin", medicinedemand.getMedicineName());
		log.info("MedicineName test case END");
	}
	// test method to test the medicinecount of the entity class
	@Test
	public void testMedicineCount() {
		log.info("MedicineCount test case START");
		medicinedemand.setDemandCount(100);
		assertEquals(100, medicinedemand.getDemandCount());
		log.info("MedicineCount test case END");
	}
	//test method to test the status of medicine of the entity class
	@Test
	public void testStatus() {
		log.info("MedicineStatus test case START");
		medicinedemand.setStatus("available");
		assertEquals("available", medicinedemand.getStatus());
		log.info("MedicineStatus test case FAILED");
	}
}