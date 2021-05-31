package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webportal.vomodel.RepScheduleVO;


@FeignClient("MEDICALREPSCHEDULE-SERVICE")
public interface MedicalRepresentativeScheduleClient {
	
	@GetMapping("/RepSchedule")
	public ResponseEntity<List<RepScheduleVO>> getAllRepSchedule();
	
	@GetMapping("/RepSchedule/{date}")
	public ResponseEntity<List<RepScheduleVO>> getRepSchedule(@PathVariable("date") String inputDate);

}