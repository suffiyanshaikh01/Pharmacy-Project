package com.medicalRepSchedule.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicalRepSchedule.demo.exception.InvalidDateException;
import com.medicalRepSchedule.demo.feinClient.MedicalStockClient;
import com.medicalRepSchedule.demo.model.Doctor;
import com.medicalRepSchedule.demo.model.MedicalRep;
import com.medicalRepSchedule.demo.model.RepSchedule;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class MedicalRepScheduleControllerTest {

	@Autowired
	MedicalRepScheduleController medicineController;
	@Mock
	RepSchedule repSchedule;
	@Mock
	List<RepSchedule> repScheduleList;
	@Mock
	MedicalStockClient medicalClient;
	@Mock
	Doctor doctor;
	private String[] medicineNames = new String[]{"Crocin,Dolo-65"};
	@Mock
	MedicalRep medicalrep;
	private LocalDate date = LocalDate.of(2021, 06, 26);
	
	
	@Test
	public void contextLoads() {
		assertNotNull(medicineController);
	}
	
	@Before
	public void setup() {
		log.info("START");
		repSchedule.setRepScheduleId(1);
		repSchedule.setRepName("Akshay");
		repSchedule.setDocName("D1");
		repSchedule.setTeatingAilment("General");
		repSchedule.setMedicineName("Crocin,Dolo-650");
		repSchedule.setSlot("1 to 2 pm");
		repSchedule.setDate(date);
		repSchedule.setDocContactNumber("123465789");
		repScheduleList.add(repSchedule);
		doctor.setDocId(1);
		doctor.setDocName("D1");
		doctor.setTreatingAilment("General");
		doctor.setDocContactNumber("123456789");
		log.info("END");
	}

	
	@Test
	public void testGetAllRepSchedulePositiveCase() {
		
		log.info("testGetAllRepSchedulePositiveCase START");
		ResponseEntity<List<RepSchedule>> allRepSchedule = medicineController.getAllRepSchedule();
		assertEquals(HttpStatus.OK,allRepSchedule.getStatusCode());
		assertNotNull(allRepSchedule.getBody());
		log.info("testGetAllRepSchedulePositiveCase END");
		
	}
	@Test
	public void testGetAllRepScheduleNegativeCase() {
		
		log.info("testGetAllRepScheduleNegativeCase START");
		ResponseEntity<List<RepSchedule>> allRepSchedule = medicineController.getAllRepSchedule();
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR,allRepSchedule.getStatusCode());
		log.info("testGetAllRepScheduleNegativeCase END");
		
	}
	
	@Test
	public void testGetRepSchedulePositiveCase() throws InvalidDateException {
		log.info("testGetRepSchedulePositiveCase START");
		when(medicalClient.getMedicineByAilment(doctor.getTreatingAilment()))
		.thenReturn(new ResponseEntity<String[]>(medicineNames,HttpStatus.OK));
		ResponseEntity<String[]> medicineByAilment = medicalClient.getMedicineByAilment(doctor.getTreatingAilment());
		assertEquals(HttpStatus.OK, medicineByAilment.getStatusCode());
		assertNotEquals(medicineByAilment.getBody().length, 0);
		log.info("testGetRepSchedulePositiveCase END");
	}
	@Test
	public void testGetRepScheduleNegativeCase() throws InvalidDateException {
		log.info("testGetRepScheduleNegativeCase START");
		when(medicalClient.getMedicineByAilment("XYZ"))
		.thenReturn(new ResponseEntity<String[]>(new String[0],HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<String[]> medicineByAilment = medicalClient.getMedicineByAilment("XYZ");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, medicineByAilment.getStatusCode());
		assertEquals(medicineByAilment.getBody().length, 0);
		log.info("testGetRepScheduleNegativeCase END");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}