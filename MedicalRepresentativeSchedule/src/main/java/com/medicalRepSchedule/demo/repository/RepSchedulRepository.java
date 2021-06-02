package com.medicalRepSchedule.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalRepSchedule.demo.model.RepSchedule;

//REPOSITORU FOR REPSCHEDULE ENTITY
@Repository
public interface RepSchedulRepository extends JpaRepository<RepSchedule, Integer> {

}
