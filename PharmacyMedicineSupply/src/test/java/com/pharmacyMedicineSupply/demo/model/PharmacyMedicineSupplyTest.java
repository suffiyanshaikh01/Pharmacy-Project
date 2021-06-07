package com.pharmacyMedicineSupply.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
//test class to test model class(PharmacyMedicineSupply)
@SpringBootTest
@Slf4j
public class PharmacyMedicineSupplyTest {
	@InjectMocks
	PharmacyMedicineSupply pharmacymedicinesupply;

	@Test
	public void testConstructor() {
		PharmacyMedicineSupply supply=new PharmacyMedicineSupply(1,"Crocin","Med-Life",200);
		
	}
	//test method to test pharmacymedicinesupply id using getters and setters
	@Test
	public void testpharmacymedicinesupplyid() {
		log.info("test case to test pharmacymedicinesupplyid START");
		pharmacymedicinesupply.setPharmacyMedicineSupplyId(1);
		assertEquals(1, pharmacymedicinesupply.getPharmacyMedicineSupplyId());
		log.info("test cases to test pharmacymedicinesupplyid ENDS");
	}
	//test method to test pharmacyname using getters and setters
	@Test
	public void testPharmacyName() {
		log.info("test case to test pharmacyname START");
		pharmacymedicinesupply.setPharmacyName("Kobra");
		assertEquals("Kobra", pharmacymedicinesupply.getPharmacyName());
		log.info("test case to test pharmacyname ENDS");
	}
	//test method to test medicinename using getters and setters
	@Test
	public void testMedicineName() {
		log.info("test case to test medicinename START");
		pharmacymedicinesupply.setMedicineName("Crocin");
		assertEquals("Crocin", pharmacymedicinesupply.getMedicineName());
		log.info("test case to test medicinename ENDS");
	}
	//test method to test supply count using getters and setters
	@Test
	public void testSupplyCount() {
		log.info("test case to test supplycount START");
		pharmacymedicinesupply.setSupplyCount(100);
		assertEquals(100, pharmacymedicinesupply.getSupplyCount());
		log.info("test case to test supplycount ENDS");
	}
}