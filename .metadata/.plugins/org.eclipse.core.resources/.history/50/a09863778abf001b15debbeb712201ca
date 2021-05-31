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

@Service
@Slf4j
public class PharmacyMedicineSupplyServiceImpl implements PharmacyMedicineSupplyService {
	
	@Autowired
	MedicineStockClient medicineClient;
	@Autowired
	PharmaciesRepo pharmaciesRepo;
	@Autowired
	PharmacyMedicineSupplyRepo supplyRepo;
	@Autowired
	DemandRepo demandRepo;
	@Override
	public List<PharmacyMedicineSupply> getPharmacySupplyList(MedicineDemand medDemand) {
		int demandCount = medDemand.getDemandCount();
		//MedicineStockVO vo =(MedicineStockVO) medicineClient.getMedicineStockByMedicineName(medDemand.getMedicineName()).getBody();
		System.out.println("DEMAND OBJ = "+medDemand);
	    //MedicineStockVO vo = medicineClient.getMedicineStockByMedicineName(medDemand.getMedicineName());
		ResponseEntity<MedicineStockVO> medicineStockByMedicineName = medicineClient.getMedicineStockByMedicineName(medDemand.getMedicineName());
		MedicineStockVO vo = medicineStockByMedicineName.getBody();
		try {
			if(vo==null) {
				throw new MedicineNotFoundException("No Medicine found by name : "+medDemand.getMedicineName()+" !!!");
			}
		} catch(MedicineNotFoundException medicineNotFound) {
			log.error(medicineNotFound.toString());
		}
		int medId = vo.getMedicineId();
		int medStockCount = vo.getNumberOfTabletsInStock();
		if(demandCount > medStockCount) {
			System.out.println("DEMAND IS MORE THAN THE STOCK CAN SUPPLY");
			medDemand.setStatus("Rejected");
			demandRepo.save(medDemand);
			return null;
			
		} 
		
			else {
				medDemand.setStatus("Approved");
			int pharmaciesCount =(int)pharmaciesRepo.count();
//		 System.out.println(pharmaciesCount);
		 int supplyCount = demandCount/pharmaciesCount;
		 List<PharmacyMedicineSupply> pharmacySupplyList = new ArrayList<>();
		 List<Pharmacies> pharmaciesList = pharmaciesRepo.findAll();
		 PharmacyMedicineSupply p ;
		
		 for(int i=0 ; i < pharmaciesCount ; ++i ) {
			 p = new PharmacyMedicineSupply();
			 p.setMedicineName(medDemand.getMedicineName());
			 p.setSupplyCount(supplyCount);
			 p.setPharmacyName(pharmaciesList.get(i).getPharmacyName());
//			 System.out.println(pharmaciesList.get(i).getPharmacyName());
			 pharmacySupplyList.add(i,p);
//			 supplyRepo.save(p);
		 }
		 
		 int remainder = demandCount - (pharmaciesCount*supplyCount);
		 
		 for(int i=0 ; i<remainder ; i++) {
			 p = new PharmacyMedicineSupply();
			 p.setMedicineName(medDemand.getMedicineName());
			 p.setSupplyCount(supplyCount+1);
			 p.setPharmacyName(pharmaciesList.get(i).getPharmacyName());
			 pharmacySupplyList.set(i, p);
			 
		 }
		 
		 for(PharmacyMedicineSupply e : pharmacySupplyList) {
			 supplyRepo.save(e);
		 }
		 
		 
		 System.out.println(pharmacySupplyList);
		 int finalCount = medStockCount - demandCount;
		 medicineClient.updateStock(medId, finalCount);
		 demandRepo.save(medDemand);
		 return supplyRepo.findAll();
		 
		}
		
		
		
	}
	@Override
	public List<PharmacyMedicineSupply> getAllPharmacySupply() {
		return supplyRepo.findAll();
	}
	@Override
	public List<MedicineDemand> getDemand() {
		return demandRepo.findAll();
	}
	
}
