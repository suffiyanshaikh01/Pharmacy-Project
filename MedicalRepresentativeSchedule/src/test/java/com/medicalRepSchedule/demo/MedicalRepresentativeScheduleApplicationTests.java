package com.medicalRepSchedule.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MedicalRepresentativeScheduleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void contextLoadtest() {
		// TESTING MAIN METHOD
		log.info("TESTING MAIN METHOD");
		MedicalRepresentativeScheduleApplication.main(new String[] {});
	}

}
