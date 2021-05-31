package com.pharmacyMedicineSupply.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;

public interface PharmacyMedicineSupplyRepo extends JpaRepository<PharmacyMedicineSupply, Integer> {

}
