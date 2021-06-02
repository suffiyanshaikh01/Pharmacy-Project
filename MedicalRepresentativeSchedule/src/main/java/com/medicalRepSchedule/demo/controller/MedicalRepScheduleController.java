package com.medicalRepSchedule.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalRepSchedule.demo.exception.InvalidDateException;
import com.medicalRepSchedule.demo.model.RepSchedule;
import com.medicalRepSchedule.demo.service.MedicalRepSchedulService;
import com.medicalRepSchedule.demo.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/RepSchedule")
public class MedicalRepScheduleController {

	@Autowired
	MedicalRepSchedulService medicalService;

	// GETTING ALL INFORMATION FROM THE REPSCHEDULE TABLE
	@GetMapping("")
	public ResponseEntity<List<RepSchedule>> getAllRepSchedule() {
		log.info("GETTING SCHEDULE FROM THE DATABASE");
		return new ResponseEntity<>(medicalService.getAllRepSchedule(), HttpStatus.OK);
	}

	// CREATING AND RETURNING SCHEDULE ACCORDING TO THE GIVEN DATE
	@GetMapping("/{date}")
	public ResponseEntity<List<RepSchedule>> getRepSchedule(@PathVariable("date") String inputDate)
			throws InvalidDateException {

		log.info("CREATING SCHEDULE ACCORDING T0 GIVEN DATE : " + inputDate);
		List<RepSchedule> repSchedule = null;

		// CONVERTING STRING DATE TO THE LOCALDATE FORMAT
		LocalDate localDate = DateUtil.getDate(inputDate);

		// IF USER INSERTED NULL DATE THEN EXCEPTION WILL BE THROWN
		if (localDate == null) {
			log.error("GIVEN DATE IS INVALID");
			throw new InvalidDateException("Date is Invalid");
		}
		repSchedule = medicalService.getRepSchedule(localDate);

		return new ResponseEntity<>(repSchedule, HttpStatus.OK);

	}
}
