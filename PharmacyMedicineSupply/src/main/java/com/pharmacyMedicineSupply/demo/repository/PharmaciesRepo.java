package com.pharmacyMedicineSupply.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacyMedicineSupply.demo.model.Pharmacies;

//pharmaciesrepo interface repo that is using Pharmacies as entity class
public interface PharmaciesRepo extends JpaRepository<Pharmacies, Integer> {
	
}
