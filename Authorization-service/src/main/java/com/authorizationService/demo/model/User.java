package com.authorizationService.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class User {

	
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String password;
	private String role;
	
	
}
