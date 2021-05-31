package com.medicalRepSchedule.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicalRepSchedule.demo.feinClient.MedicalStockClient;
import com.medicalRepSchedule.demo.model.Doctor;
import com.medicalRepSchedule.demo.model.MedicalRep;
import com.medicalRepSchedule.demo.model.RepSchedule;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class MedicineRepScheduleService {

	@Autowired
	MedicalRepSchedulServiceImpl medicalService;
	@Mock
	MedicalStockClient medicalClient;
	@Mock
	RepSchedule repSchedule;
	@Mock
	List<RepSchedule> repScheduleList;
	private LocalDate date = LocalDate.of(2021, 06, 26);
	@Mock
	Doctor doctor;
	@Mock
	MedicalRep rep;
	private String[] medicineNames = new String[]{"Crocin,Dolo-65"};
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
		rep.setRepId(1);
		rep.setRepName("Akshay");
		rep.setRepContactNumber("123456789");
		log.info("END");
	}

	@Test
	public void testGetRepSchedulePositiveCase() {
		log.info("testGetRepSchedulePositiveCase START");
		when(medicalClient.getMedicineByAilment("General"))
		.thenReturn(new ResponseEntity<String[]>(medicineNames,HttpStatus.OK));
		ResponseEntity<String[]> medicineByAilment = medicalClient.getMedicineByAilment("General");
		assertEquals(HttpStatus.OK, medicineByAilment.getStatusCode());
		assertNotEquals(medicineByAilment.getBody().length, 0);
		log.info("testGetRepSchedulePositiveCase END");
	}
	
	@Test
	public void testGetRepScheduleNegativeCase() {
		log.info("testGetRepScheduleNegativeCase START");
		when(medicalClient.getMedicineByAilment("XYZ"))
		.thenReturn(new ResponseEntity<String[]>(new String[0],HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<String[]> medicineByAilment = medicalClient.getMedicineByAilment("XYZ");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, medicineByAilment.getStatusCode());
		assertEquals(medicineByAilment.getBody().length, 0);
		log.info("testGetRepScheduleNegativeCase END");
	}
	@Test
	public void testGetAllRepSchedulePositiveCase() {
		
		log.info("testGetAllRepSchedulePositiveCase START");
		 List<RepSchedule> allRepSchedule = medicalService.getAllRepSchedule();
		assertNotNull(allRepSchedule);
		log.info("testGetAllRepSchedulePositiveCase END");
		
	}
}
