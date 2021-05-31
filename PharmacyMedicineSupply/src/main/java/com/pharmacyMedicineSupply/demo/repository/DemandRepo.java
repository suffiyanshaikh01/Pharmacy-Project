package com.pharmacyMedicineSupply.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
@Repository
public interface DemandRepo extends JpaRepository<MedicineDemand, Integer> {

}
