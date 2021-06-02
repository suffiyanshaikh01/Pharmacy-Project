package com.pharmacyMedicineSupply.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharmacyMedicineSupply.demo.exception.MedicineNotFoundException;
import com.pharmacyMedicineSupply.demo.feinClient.MedicineStockClient;
import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.Pharmacies;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.repository.DemandRepo;
import com.pharmacyMedicineSupply.demo.repository.PharmaciesRepo;
import com.pharmacyMedicineSupply.demo.repository.PharmacyMedicineSupplyRepo;
import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

import lombok.extern.slf4j.Slf4j;
//service implclass
@Service
@Slf4j
public class PharmacyMedicineSupplyServiceImpl implements PharmacyMedicineSupplyService {
	//Autowiring the medicineclient of feignclient
	@Autowired
	MedicineStockClient medicineClient;
	//Autowirung the repo of jpa repository interface
	@Autowired
	PharmaciesRepo pharmaciesRepo;
	//Autowiring the pharmacymedicine repo of jpa repository
	@Autowired
	PharmacyMedicineSupplyRepo supplyRepo;
	//Autowiring the Demandrepo interface 
	@Autowired
	DemandRepo demandRepo;
	//Overrding the method of service interface which returns the list pharmacy supply
	@Override
	public List<PharmacyMedicineSupply> getPharmacySupplyList(MedicineDemand medDemand) {
		int demandCount = medDemand.getDemandCount();
		log.info("MEDICINE NAME : " + medDemand.getMedicineName());
		ResponseEntity<MedicineStockVO> medicineStockByMedicineName = medicineClient
				.getMedicineStockByMedicineName(medDemand.getMedicineName());
		log.info("RESPONSE ENTITY : " + medicineStockByMedicineName);
		MedicineStockVO vo = medicineStockByMedicineName.getBody();
		try {
			if (vo == null) {
				throw new MedicineNotFoundException(
						"No Medicine found by name : " + medDemand.getMedicineName() + " !!!");
			}
		} catch (MedicineNotFoundException medicineNotFound) {
			
			log.error(medicineNotFound.toString());
			return null;
		}
		int medId = vo.getMedicineId();
		int medStockCount = vo.getNumberOfTabletsInStock();
		if (demandCount > medStockCount) {
			log.info("DEMAND IS MORE THAN THE STOCK CAN SUPPLY");
			medDemand.setStatus("Rejected");
			demandRepo.save(medDemand);
			return null;

		}

		else {
			medDemand.setStatus("Approved");
			int pharmaciesCount = (int) pharmaciesRepo.count();
			int supplyCount = demandCount / pharmaciesCount;
			List<PharmacyMedicineSupply> pharmacySupplyList = new ArrayList<>();
			List<Pharmacies> pharmaciesList = pharmaciesRepo.findAll();
			PharmacyMedicineSupply p;

			for (int i = 0; i < pharmaciesCount; ++i) {
				p = new PharmacyMedicineSupply();
				p.setMedicineName(medDemand.getMedicineName());
				p.setSupplyCount(supplyCount);
				p.setPharmacyName(pharmaciesList.get(i).getPharmacyName());
				pharmacySupplyList.add(i, p);
			}

			int remainder = demandCount - (pharmaciesCount * supplyCount);

			for (int i = 0; i < remainder; i++) {
				p = new PharmacyMedicineSupply();
				p.setMedicineName(medDemand.getMedicineName());
				p.setSupplyCount(supplyCount + 1);
				p.setPharmacyName(pharmaciesList.get(i).getPharmacyName());
				pharmacySupplyList.set(i, p);

			}

			for (PharmacyMedicineSupply e : pharmacySupplyList) {
				supplyRepo.save(e);
			}

			System.out.println(pharmacySupplyList);
			int finalCount = medStockCount - demandCount;
			log.info("----------" + medId + "  " + finalCount);
			medicineClient.updateStock(medId, finalCount);
			demandRepo.save(medDemand);
			return supplyRepo.findAll();

		}

	}
	//Overriding the method of serviice interface which returns the list of all pharmacysupply
	@Override
	public List<PharmacyMedicineSupply> getAllPharmacySupply() {
		return supplyRepo.findAll();
	}
	//Overriding the method of service interface which returns the list of medicinedemand
	@Override
	public List<MedicineDemand> getDemand() {
		return demandRepo.findAll();
	}

}
