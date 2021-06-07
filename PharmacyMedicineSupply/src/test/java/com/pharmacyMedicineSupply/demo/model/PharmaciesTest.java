package com.pharmacyMedicineSupply.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
//test class to test the model class(Pharmacies)
@SpringBootTest
@Slf4j
public class PharmaciesTest {
	@InjectMocks
	Pharmacies pharmacies;

	@Test
	public void TestConstructor() {
		Pharmacies pharmacy=new Pharmacies(1,"Med-Life");
	}
	//test method to test pharmacyId using getters and setters
	@Test
	public void testPharmacyId() {
		log.info("Test case for pharmacyid START");
		pharmacies.setPharmacyId(1);
		assertEquals(1, pharmacies.getPharmacyId());
		log.info("test case for pharmacyid END");
	}
	//test method to test pharmacynaemusing getters and setters
	@Test
	public void testPharmacyName() {
		log.info("Test case for pharmacyName START");
		pharmacies.setPharmacyName("lifestyle");
		assertEquals("lifestyle", pharmacies.getPharmacyName());
		log.info("Test cases for pharmacyName END");
	}
}