package com.webportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PharmacyMedicineSupplyWebPortalApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void contextLoadsTest() {
		log.info("STARTED TESTING MEDICINE SUPPLY WEB PORTAL");
		PharmacyMedicineSupplyWebPortalApplication.main(new String[] {});
	}

}
