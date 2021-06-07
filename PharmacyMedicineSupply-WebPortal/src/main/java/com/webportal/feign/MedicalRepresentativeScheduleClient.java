package com.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webportal.vomodel.RepScheduleVO;


//@FeignClient("MEDICALREPSCHEDULE-SERVICE")
@FeignClient(url = "http://ij018pod4medicinerepresentativeservi-env.eba-y2ecpdta.us-east-2.elasticbeanstalk.com",name = "MEDICALREPSCHEDULE-SERVICE")
public interface MedicalRepresentativeScheduleClient {
	
	//GETTING ALL REPSCHEDULE
	@GetMapping("/RepSchedule")
	public ResponseEntity<List<RepScheduleVO>> getAllRepSchedule();
	
	//CREATING REPRESENTATIVE SCHEDULE
	@GetMapping("/RepSchedule/{date}")
	public ResponseEntity<List<RepScheduleVO>> getRepSchedule(@PathVariable("date") String inputDate);

}
