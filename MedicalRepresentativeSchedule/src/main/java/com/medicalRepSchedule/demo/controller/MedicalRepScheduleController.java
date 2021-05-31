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
		
		@GetMapping("")
		public ResponseEntity<List<RepSchedule>> getAllRepSchedule(){
			return new ResponseEntity<>(medicalService.getAllRepSchedule(),HttpStatus.OK);
		}
		
		
		@GetMapping("/{date}")
		public ResponseEntity<List<RepSchedule>> getRepSchedule(@PathVariable("date") String inputDate) throws InvalidDateException {

			List<RepSchedule> repSchedule = null;

			LocalDate localDate = DateUtil.getDate(inputDate);
			
			if (localDate == null) {
				log.error("Date is Invalid");
				throw new InvalidDateException("Date is Invalid");
			}

			repSchedule = medicalService.getRepSchedule(localDate);

			if (repSchedule.isEmpty()) {
				System.out.println("End");
				System.out.println("Schedule not found");
			}


			return new ResponseEntity<>(repSchedule, HttpStatus.OK);
			
		}
}