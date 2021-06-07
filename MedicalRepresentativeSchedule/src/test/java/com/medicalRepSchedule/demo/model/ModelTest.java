package com.medicalRepSchedule.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ModelTest {

	//IN THIS CLASS GETTERS AND SETTERS FOR ALL THE M0DELS ARE TESTED
	// TESTING DOCTOR MODEL
	@InjectMocks
	Doctor doctor;

	@Test
	public void testConstructor() {
		Doctor doctor = new Doctor(1, "D1", "9999999999", "Generel");

	}

	@Test
	public void testSetDocId() {
		log.info("testSetDocId START");
		doctor.setDocId(1);
		assertEquals(1, doctor.getDocId());
		log.info("testSetDocId END");
	}

	@Test
	public void testSetDocName() {
		log.info("testSetDocName START");
		doctor.setDocName("D1");
		assertEquals("D1", doctor.getDocName());
		log.info("testSetDocName END");
	}

	@Test
	public void testSetDocContactNumber() {
		log.info("testSetDocContactNumber START");
		doctor.setDocContactNumber("9999999999");
		assertEquals("9999999999", doctor.getDocContactNumber());
		log.info("testSetDocContactNumber END");
	}

	@Test
	public void testSetTreatingAilment() {
		log.info("testSetTreatingAilment START");
		doctor.setTreatingAilment("General");
		assertEquals("General", doctor.getTreatingAilment());
		log.info("testSetTreatingAilment END");
	}

	// TESTING MEDICAL REP MODEL

	@InjectMocks
	MedicalRep medicalRep;

	@Test
	public void testMedicaRepConstructor() {
		MedicalRep medicalRep = new MedicalRep(1, "R1", "8888888888");

	}

	@Test
	public void testSetRepId() {
		log.info("testSetRepId START");
		medicalRep.setRepId(1);
		assertEquals(1, medicalRep.getRepId());
		log.info("testSetRepId END");
	}

	@Test
	public void testSetRepName() {
		log.info("testSetRepName START");
		medicalRep.setRepName("R1");
		assertEquals("R1", medicalRep.getRepName());
		log.info("testSetRepName END");
	}

	@Test
	public void testSetRepContact() {
		log.info("testSetRepContact START");
		medicalRep.setRepContactNumber("9999999999");
		assertEquals("9999999999", medicalRep.getRepContactNumber());
		log.info("testSetRepContact END");
	}

	// TESTING REPSCHEDULE

	@InjectMocks
	RepSchedule repSchedule;

	@Test
	public void testRepScheduleConstructor() {
		RepSchedule repSchedule = new RepSchedule(1, "R1", "D1", "General", "Crocin", "1PM to 2PM",
				LocalDate.of(2021, 9, 9), "9999999999");

	}

	@Test
	public void testSetRepScheduleId() {
		log.info("testSetRepScheduleId START");
		repSchedule.setRepScheduleId(1);
		assertEquals(1, repSchedule.getRepScheduleId());
		log.info("testSetRepScheduleId END");
	}

	@Test
	public void testSetRepNameForSchedule() {
		log.info("testSetRepNameForSchedule START");
		repSchedule.setRepName("R1");
		assertEquals("R1", repSchedule.getRepName());
		log.info("testSetRepNameForSchedule END");
	}

	@Test
	public void testDocNameForSchedule() {
		log.info("testDocNameForSchedule START");
		repSchedule.setDocName("D1");
		assertEquals("D1", repSchedule.getDocName());
		log.info("testDocNameForSchedule END");
	}

	@Test
	public void testTreatingAilment() {
		log.info("testTreatingAilment START");
		repSchedule.setTeatingAilment("General");
		assertEquals("General", repSchedule.getTeatingAilment());
		log.info("testTreatingAilment END");
	}

	@Test
	public void testSlot() {
		log.info("testSlot START");
		repSchedule.setSlot("1PM to 2PM");
		assertEquals("1PM to 2PM", repSchedule.getSlot());
		log.info("testSlot END");
	}

	@Test
	public void testDocContactNumber() {
		log.info("testDocContactNumber START");
		repSchedule.setDocContactNumber("9999999999");
		assertEquals("9999999999", repSchedule.getDocContactNumber());
		log.info("testDocContactNumber END");
	}

	@Test
	public void testMedicineName() {
		log.info("testMedicineName START");
		repSchedule.setMedicineName("Crocin");
		assertEquals("Crocin", repSchedule.getMedicineName());
		log.info("testMedicineName END");
	}

	@Test
	public void testDate() {
		log.info("testDate START");
		LocalDate date = LocalDate.of(2021, 05, 05);
		repSchedule.setDate(date);
		assertEquals(date, repSchedule.getDate());
		log.info("testDate END");
	}
}
