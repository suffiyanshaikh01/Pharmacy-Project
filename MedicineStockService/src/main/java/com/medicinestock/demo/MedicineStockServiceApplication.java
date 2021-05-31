package com.medicinestock.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class MedicineStockServiceApplication {

	public static void main(String[] args) {
		log.info("START MEDICINE STOCK APPLICATION");
		SpringApplication.run(MedicineStockServiceApplication.class, args);
		log.info("END MEDICINE STOCK APPLICATION");
	}

}
