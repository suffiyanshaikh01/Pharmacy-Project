package com.medicalRepSchedule.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class MedicalRepresentativeScheduleApplication {

	// MEDICAL REPRESENTATIVE SCHEDULE MICROSERVICE
	public static void main(String[] args) {
		log.info("MEDICAL REPRESENTATIVE SCHEDULE MICROSERVICE STARTED");
		SpringApplication.run(MedicalRepresentativeScheduleApplication.class, args);
	}

}
