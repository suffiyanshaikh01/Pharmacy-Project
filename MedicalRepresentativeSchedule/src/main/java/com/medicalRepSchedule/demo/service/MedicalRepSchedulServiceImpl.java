package com.medicalRepSchedule.demo.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medicalRepSchedule.demo.feinClient.MedicalStockClient;
import com.medicalRepSchedule.demo.model.Doctor;
import com.medicalRepSchedule.demo.model.MedicalRep;
import com.medicalRepSchedule.demo.model.RepSchedule;
import com.medicalRepSchedule.demo.repository.MedicalRepRepository;
import com.medicalRepSchedule.demo.repository.RepSchedulRepository;
import com.medicalRepSchedule.demo.util.CsvParseUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MedicalRepSchedulServiceImpl implements MedicalRepSchedulService {

	@Autowired
	MedicalStockClient medicalClient;
	@Autowired
	MedicalRepRepository repRepo;
	@Autowired
	RepSchedulRepository scheduleRepo;

	@Override
	public List<RepSchedule> getRepSchedule(LocalDate inputDate) {

		// THIS METHOD CREATES SCHEDULE ACCORDING TO THE DATE PROVIDED
		log.info("STARTED CREATING SCHEDULE IN SERVICE");
		List<RepSchedule> repSchedules = new ArrayList<>();

		// CREATING LIST OF DOCTORS FROM CSV FILE
		List<Doctor> doctors = CsvParseUtil.parseDoctors();
		List<MedicalRep> medicalRepresentatives = repRepo.findAll();

		LocalDate localDate = inputDate;

		LocalTime now = LocalTime.now();
		LocalTime one = LocalTime.of(13, 0);

		LocalDate today = LocalDate.now();

		// IF THE DATE IS PAST DATE THEN RETURN EMPTY SCHEDULE
		if (inputDate.isBefore(today)) {

			log.info("USER GAVE PAST DATE AS INPUT");
			return repSchedules;
		}

		// IF THE DATE IS TODAYS DATE THEN CHECK CURRENT TIME IF IT IS PAST ONE THEN
		// CONSIDER NEXT DAY
		if (inputDate.equals(today)) {

			if (now.isAfter(one)) {
				localDate = localDate.plusDays(1);
			}
		}
		// FOR EVERY DOCTOR MAP A REPRESENTATIVE
		for (int i = 0; i < doctors.size(); i++) {
			// IF THE DAY IS SUNDAY THEN SKIP CURRENT DAY
			if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				localDate = localDate.plusDays(1);
			}
	
			Doctor doctor = doctors.get(i);
			
			//MAP ONE OF THE REPRESENTATIVE WITH DOCTOR
			//HERE NUMBER OF REPRESENTATIVE IS 3 SO %3
			MedicalRep medicalRepresentative = medicalRepresentatives.get(i % 3);

			RepSchedule repSchedule = new RepSchedule();
			repSchedule.setRepScheduleId(i + 1);
			repSchedule.setRepName(medicalRepresentative.getRepName());
			repSchedule.setDocName(doctor.getDocName());
			repSchedule.setDocContactNumber(doctor.getDocContactNumber());
			repSchedule.setDate(localDate);
			repSchedule.setSlot("1 PM to 2 PM");
			repSchedule.setTeatingAilment(doctor.getTreatingAilment());
			
			
			//GET LIST OF MEDICINE TO RECOMMEND DOCTOR FROM MEDICINESTOCKSERVICE BY SPECIFIC AILMENT
			ResponseEntity<String[]> medicineByAilment = medicalClient
					.getMedicineByAilment(doctor.getTreatingAilment());
			String[] medicinesByTreatingAilment = medicineByAilment.getBody();
			String medicine = "";
			log.info("FETCHED MEDICINE FROM STOCK");
			
			//FOR LOOP FOR INSERTING COMMA IN THE STRING
			for (int j = 0; j < medicinesByTreatingAilment.length; j++) {
				medicine += medicinesByTreatingAilment[j] + ",";
			}
			medicine = medicine.substring(0, medicine.length() - 1);
			repSchedule.setMedicineName(medicine);
			repSchedules.add(repSchedule);
			log.info("SAVING DATA INTO DATABSE");
			scheduleRepo.save(repSchedule);
			localDate = localDate.plusDays(1);
		}

		log.info("RETURNING FROM CREATE SCHEDULE SERVICE");
		return repSchedules;
	}

	@Override
	public List<RepSchedule> getAllRepSchedule() {
		//RETURNS ALL THE INFORMATION FROM THE REPSCHEDULE TABLE
		return scheduleRepo.findAll();
	}

}
