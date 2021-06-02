package com.medicalRepSchedule.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medicalRepSchedule.demo.exception.InvalidDateException;
import com.medicalRepSchedule.demo.feinClient.MedicalStockClient;
import com.medicalRepSchedule.demo.model.MedicalRep;
import com.medicalRepSchedule.demo.model.RepSchedule;
import com.medicalRepSchedule.demo.service.MedicalRepSchedulService;
import com.medicalRepSchedule.demo.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MedicalRepScheduleControllerTest {

	@InjectMocks
	MedicalRepScheduleController medicineController;

	List<RepSchedule> repScheduleList = new ArrayList<>();
	@Mock
	MedicalStockClient medicalClient;
	@Mock
	MedicalRep medicalrep;
	@Mock
	MedicalRepSchedulService medicalService;

	@Test
	public void contextLoads() {
		assertNotNull(medicineController);
	}

	// THIS IS POSITIVE TEST CASE FOR TESTING CONTROLLER METHOD WHICH GIVES ALL THE
	// REPRESENTATIVE SCHEDULES
	@Test
	public void testGetAllRepSchedulePositiveCase() {

		log.info("testGetAllRepSchedulePositiveCase START");
		ResponseEntity<List<RepSchedule>> allRepSchedule = medicineController.getAllRepSchedule();
		assertEquals(HttpStatus.OK, allRepSchedule.getStatusCode());
		assertNotNull(allRepSchedule.getBody());
		log.info("testGetAllRepSchedulePositiveCase END");

	}

	// THIS IS NEGATIVE TEST CASE FOR TESTING CONTROLLER METHOD WHICH GIVES ALL THE
	// REPRESENTATIVE SCHEDULES
	@Test
	public void testGetAllRepScheduleNegativeCase() {

		log.info("testGetAllRepScheduleNegativeCase START");
		ResponseEntity<List<RepSchedule>> allRepSchedule = medicineController.getAllRepSchedule();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, allRepSchedule.getStatusCode());
		log.info("testGetAllRepScheduleNegativeCase END");

	}

	// THIS IS POSITIVE TEST CASE FOR TESTING CONTROLLER METHOD WHICH GIVES ALL THE
	// REPRESENTATIVE SCHEDULES BY GIVEN DATE
	@Test
	public void testGetRepSchedulePositiveCase() throws InvalidDateException {
		log.info("testGetRepSchedulePositiveCase START");
		RepSchedule repSchedule = new RepSchedule(1, "R1", "D1", "General", "Crocin", "1PM to 2PM",
				LocalDate.of(2021, 9, 9), "9999999999");
		repScheduleList.add(repSchedule);
		LocalDate date = DateUtil.getDate("2021-09-09");
		when(medicalService.getRepSchedule(date)).thenReturn(repScheduleList);

		ResponseEntity<List<RepSchedule>> repSchedule2 = medicineController.getRepSchedule("2021-09-09");

		assertNotNull(repSchedule2);

		log.info("testGetRepSchedulePositiveCase END");
	}

	// THIS IS NEGATIVE TEST CASE FOR TESTING CONTROLLER METHOD WHICH GIVES ALL THE
	// REPRESENTATIVE SCHEDULES BY GIVEN DATE
	@Test
	public void testGetRepScheduleNegativeCase() throws InvalidDateException {
		log.info("testGetRepSchedulePositiveCase START");
		LocalDate date = DateUtil.getDate("");
		when(medicalService.getRepSchedule(date)).thenReturn(repScheduleList);
		try {
			medicineController.getRepSchedule("");
		} catch (InvalidDateException invalidDate) {
			assertEquals(InvalidDateException.class, invalidDate.getClass());
			log.info(invalidDate.toString());
		}

		log.info("testGetRepSchedulePositiveCase END");
	}

}
