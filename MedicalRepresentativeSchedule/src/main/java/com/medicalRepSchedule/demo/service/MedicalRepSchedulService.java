package com.medicalRepSchedule.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.medicalRepSchedule.demo.model.RepSchedule;

public interface MedicalRepSchedulService {

	List<RepSchedule> getRepSchedule(LocalDate inputDate);

	List<RepSchedule> getAllRepSchedule();

}
