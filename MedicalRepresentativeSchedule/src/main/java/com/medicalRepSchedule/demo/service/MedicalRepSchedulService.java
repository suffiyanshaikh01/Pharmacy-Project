package com.medicalRepSchedule.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.medicalRepSchedule.demo.model.RepSchedule;

//INTERFACE FOR MEDICALREPSERVICE
public interface MedicalRepSchedulService {

	List<RepSchedule> getRepSchedule(LocalDate inputDate);

	List<RepSchedule> getAllRepSchedule();

}
