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

@Service
public class MedicalRepSchedulServiceImpl implements MedicalRepSchedulService {
	@Autowired
	MedicalStockClient medicalClient;
	@Autowired
	MedicalRepRepository repRepo;
	@Autowired
	RepSchedulRepository scheduleRepo;
	@Override
	public List<RepSchedule> getRepSchedule(LocalDate inputDate) {


		List<RepSchedule> repSchedules = new ArrayList<>();
		List<Doctor> doctors = CsvParseUtil.parseDoctors();
		List<MedicalRep> medicalRepresentatives = repRepo.findAll();
		

		LocalDate localDate = inputDate;

		LocalTime now = LocalTime.now();
		LocalTime one = LocalTime.of(13, 0);

		LocalDate today = LocalDate.now();
		if (inputDate.isBefore(today)) {

			return repSchedules;
		}

		if (inputDate.equals(today)) {

			if (now.isAfter(one)) {
				localDate = localDate.plusDays(1);
			}
		}

		for (int i = 0; i < doctors.size(); i++) {

			if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				localDate = localDate.plusDays(1);
			}

			Doctor doctor = doctors.get(i);
			MedicalRep medicalRepresentative = medicalRepresentatives.get(i % 3);

			RepSchedule repSchedule = new RepSchedule();
			repSchedule.setRepScheduleId(i + 1);
			repSchedule.setRepName(medicalRepresentative.getRepName());
			repSchedule.setDocName(doctor.getDocName());
			repSchedule.setDocContactNumber(doctor.getDocContactNumber());
			repSchedule.setDate(localDate);
			repSchedule.setSlot("1 PM to 2 PM");
			repSchedule.setTeatingAilment(doctor.getTreatingAilment());

//			String[] medicinesByTreatingAilment =medicalClient.getMedicineByAilment(doctor.getTreatingAilment());
			ResponseEntity<String[]> medicineByAilment = medicalClient.getMedicineByAilment(doctor.getTreatingAilment());
			String[] medicinesByTreatingAilment = medicineByAilment.getBody();
			String medicine = "";
			for(int j=0 ; j<medicinesByTreatingAilment.length ; j++) {
				medicine += medicinesByTreatingAilment[j]+",";
			}
			medicine = medicine.substring(0,medicine.length()-1);
			repSchedule.setMedicineName(medicine);
			System.out.println(medicine);
			repSchedules.add(repSchedule);
			scheduleRepo.save(repSchedule);
			localDate = localDate.plusDays(1);
		}

		
		return repSchedules;
	}
	@Override
	public List<RepSchedule> getAllRepSchedule() {
		return scheduleRepo.findAll();
	}

}
