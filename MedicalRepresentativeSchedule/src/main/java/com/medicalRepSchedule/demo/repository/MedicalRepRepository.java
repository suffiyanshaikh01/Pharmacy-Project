package com.medicalRepSchedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalRepSchedule.demo.model.MedicalRep;

//REPOSITORY FOR MEDICALREP ENTITY
@Repository
public interface MedicalRepRepository extends JpaRepository<MedicalRep, Integer> {

}
