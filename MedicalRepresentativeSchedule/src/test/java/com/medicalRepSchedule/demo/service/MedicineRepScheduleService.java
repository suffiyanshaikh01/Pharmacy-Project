package com.medicalRepSchedule.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicalRepSchedule.demo.feinClient.MedicalStockClient;
import com.medicalRepSchedule.demo.model.MedicalRep;
import com.medicalRepSchedule.demo.model.RepSchedule;
import com.medicalRepSchedule.demo.repository.MedicalRepRepository;
import com.medicalRepSchedule.demo.repository.RepSchedulRepository;
import com.medicalRepSchedule.demo.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class MedicineRepScheduleService {

	@InjectMocks
	MedicalRepSchedulServiceImpl medicalService;
	@Mock
	MedicalStockClient medicalClient;
	@Mock
	RepSchedule repSchedule;

	@Mock
	MedicalRepRepository repRepo;
	@Mock
	RepSchedulRepository scheduleRepo;

	//POSITIVE TESTING THE GETSCHEDULEREP METHOD FOR CHECKING WHETHER IT IS CREATING SCHEDULE OR NOT
	@Test
	public void testGetRepSchedulePositiveCase() {
		log.info("testGetRepSchedulePositiveCase START");
		LocalDate date = DateUtil.getDate("2021-09-09");
		List<MedicalRep> medicalRepresentatives = new ArrayList<>();
		MedicalRep medicalRep1 = new MedicalRep(1, "R1", "8888888888");
		MedicalRep medicalRep2 = new MedicalRep(2, "R2", "8888888888");
		MedicalRep medicalRep3 = new MedicalRep(3, "R3", "8888888888");
		medicalRepresentatives.add(medicalRep1);
		medicalRepresentatives.add(medicalRep2);
		medicalRepresentatives.add(medicalRep3);

		String[] medicineNames = { "Dolo650", "Crocin", "Dolo650", "Crocin" };

		when(repRepo.findAll()).thenReturn(medicalRepresentatives);

		when(medicalClient.getMedicineByAilment("General"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(medicalClient.getMedicineByAilment("Orthopaedics"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(medicalClient.getMedicineByAilment("Gynaecology"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(scheduleRepo.save(Mockito.any(RepSchedule.class))).thenReturn(repSchedule);

		List<RepSchedule> repSchedule2 = medicalService.getRepSchedule(date);

		assertNotNull(repSchedule2);
		log.info("testGetRepSchedulePositiveCase END");
	}

	//NEGATIVE TESTING THE GETSCHEDULEREP METHOD FOR CHECKING WHETHER IT IS CREATING SCHEDULE OR NOT
	@Test
	public void testGetRepScheduleNegativeCase() {
		log.info("testGetRepScheduleNegativeCase START");
		LocalDate date = DateUtil.getDate("2021-03-03");
		List<MedicalRep> medicalRepresentatives = new ArrayList<>();
		MedicalRep medicalRep1 = new MedicalRep(1, "R1", "8888888888");
		MedicalRep medicalRep2 = new MedicalRep(2, "R2", "8888888888");
		MedicalRep medicalRep3 = new MedicalRep(3, "R3", "8888888888");
		medicalRepresentatives.add(medicalRep1);
		medicalRepresentatives.add(medicalRep2);
		medicalRepresentatives.add(medicalRep3);

		String[] medicineNames = { "Dolo650", "Crocin", "Dolo650", "Crocin" };

		when(repRepo.findAll()).thenReturn(medicalRepresentatives);

		when(medicalClient.getMedicineByAilment("General"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(medicalClient.getMedicineByAilment("Orthopaedics"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(medicalClient.getMedicineByAilment("Gynaecology"))
				.thenReturn(new ResponseEntity<String[]>(medicineNames, HttpStatus.OK));
		when(scheduleRepo.save(Mockito.any(RepSchedule.class))).thenReturn(repSchedule);

		List<RepSchedule> repSchedule2 = medicalService.getRepSchedule(date);

		assertNotNull(repSchedule2);
		log.info("testGetRepScheduleNegativeCase END");
	}

	//POSITIVE TESTING THE GETSCHEDULEREP METHOD FOR CHECKING WHETHER IT IS RETURNING SCHEDULE OR NOT
	@Test
	public void testGetAllRepSchedulePositiveCase() {

		log.info("testGetAllRepSchedulePositiveCase START");

		List<RepSchedule> allRepSchedule = medicalService.getAllRepSchedule();
		assertNotNull(allRepSchedule);
		log.info("testGetAllRepSchedulePositiveCase END");

	}
}