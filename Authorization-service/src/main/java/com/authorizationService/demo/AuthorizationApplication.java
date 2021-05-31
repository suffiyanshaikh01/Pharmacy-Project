package com.authorizationService.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

}
