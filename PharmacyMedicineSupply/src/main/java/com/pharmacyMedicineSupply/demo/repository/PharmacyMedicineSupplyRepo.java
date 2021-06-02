package com.pharmacyMedicineSupply.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;

//PharmacyMedicineSupplyRepo interface repo that is usiong PharmacyMedicinesuppply as entity class
public interface PharmacyMedicineSupplyRepo extends JpaRepository<PharmacyMedicineSupply, Integer> {

}
