package com.webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@Slf4j
public class PharmacyMedicineSupplyWebPortalApplication {
	//PharmacyMedicineSupplyWebPortal STARTED
	public static void main(String[] args) {
		log.info("PharmacyMedicineSupplyWebPortal STARTED");
		SpringApplication.run(PharmacyMedicineSupplyWebPortalApplication.class, args);
	}

}
