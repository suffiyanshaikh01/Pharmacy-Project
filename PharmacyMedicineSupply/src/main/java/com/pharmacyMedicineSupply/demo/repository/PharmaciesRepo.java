package com.pharmacyMedicineSupply.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacyMedicineSupply.demo.model.Pharmacies;

public interface PharmaciesRepo extends JpaRepository<Pharmacies, Integer> {
	
}
