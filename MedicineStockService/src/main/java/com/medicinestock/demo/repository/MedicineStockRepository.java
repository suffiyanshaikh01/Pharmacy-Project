package com.medicinestock.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicinestock.demo.model.MedicineStock;

@Repository

//	THIS IS THE REPOSITORY FOR MEDICINE STOCK, IT INTERACTS WITH THE DATABASE TO PROVIDE THE DATA
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Integer> {
	@Transactional
	@Modifying
	@Query("Update MedicineStock m set m.numberOfTabletsInStock = ?2 where m.medicineId = ?1")
	public int updateStock(int id, int count);
	@Query("from MedicineStock m where m.targetAilment = ?1")
	public List<MedicineStock> getMedicineByAilment(String ailment);
	
	public MedicineStock getMedicineStockByMedicineName(String medicine);
		
}
