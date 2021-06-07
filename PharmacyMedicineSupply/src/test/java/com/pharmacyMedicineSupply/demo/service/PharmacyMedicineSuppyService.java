package com.pharmacyMedicineSupply.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharmacyMedicineSupply.demo.feinClient.MedicineStockClient;
import com.pharmacyMedicineSupply.demo.model.MedicineDemand;
import com.pharmacyMedicineSupply.demo.model.Pharmacies;
import com.pharmacyMedicineSupply.demo.model.PharmacyMedicineSupply;
import com.pharmacyMedicineSupply.demo.repository.DemandRepo;
import com.pharmacyMedicineSupply.demo.repository.PharmaciesRepo;
import com.pharmacyMedicineSupply.demo.repository.PharmacyMedicineSupplyRepo;
import com.pharmacyMedicineSupply.demo.vo.MedicineStockVO;

import lombok.extern.slf4j.Slf4j;
//test class to test service class
@SpringBootTest
@Slf4j
class PharmacyMedicineSuppyService {

	@InjectMocks
	PharmacyMedicineSupplyServiceImpl pharmacyService;

	@Mock
	MedicineDemand medDemandPositive, medDemandNegative;
	@Mock
	MedicineStockClient medicineStockClient;
	List<MedicineDemand> medDemandList;
	@Mock
	PharmacyMedicineSupply pharmacyMedicineSupply;
	List<PharmacyMedicineSupply> pharmacyMedicineSupplyList;
	@Mock
	DemandRepo demandRepo;
	@Mock
	PharmaciesRepo pharmaciesRepo;
	@Mock
	PharmacyMedicineSupplyRepo supplyRepo;
	@Mock
	MedicineStockClient medicineClient;

	@Test
	public void contextLoads() {
		assertNotNull(pharmacyService);
	}
	//positive test method to pharmacysupplylist
	@Test
	public void testGetPharmacySupplyListPositive() {
		log.info("testGetPharmacySupplyListPositiveCase START");
		MedicineDemand medicineDemand = new MedicineDemand(1, "Crocin", 200, "");
		MedicineStockVO medicineStockVO = new MedicineStockVO(1, "Crocin",
				"disaccharide gentiobiose, dicarboxylic acid crocetin", "General", LocalDate.of(2021, 6, 6), 2000,
				"Med-Life");
		Pharmacies pharmacy1 = new Pharmacies(1, "Med-Life");
		Pharmacies pharmacy2 = new Pharmacies(2, "Med-Life");
		Pharmacies pharmacy3 = new Pharmacies(3, "Med-Life");
		List<Pharmacies> pharmaciesList = new ArrayList<>();
		pharmaciesList.add(pharmacy1);
		pharmaciesList.add(pharmacy2);
		pharmaciesList.add(pharmacy3);
		PharmacyMedicineSupply supply=new PharmacyMedicineSupply(1,"Crocin","Med-Life",200);
		List<PharmacyMedicineSupply> supplyList=new ArrayList<>();
		supplyList.add(supply);
		supplyList.add(supply);
		supplyList.add(supply);
		when(pharmaciesRepo.count()).thenReturn((long) 3);
		when(medicineClient.updateStock(1,1800)).thenReturn(new ResponseEntity<Boolean>(true,HttpStatus.OK));
		when(medicineClient.getMedicineStockByMedicineName("Crocin"))
				.thenReturn(new ResponseEntity<MedicineStockVO>(medicineStockVO, HttpStatus.OK));
		when(demandRepo.save(Mockito.any(MedicineDemand.class))).thenReturn(medicineDemand);
		when(supplyRepo.save(Mockito.any(PharmacyMedicineSupply.class))).thenReturn(supply);
		when(supplyRepo.findAll()).thenReturn(supplyList);
		when(pharmaciesRepo.findAll()).thenReturn(pharmaciesList);
		List<PharmacyMedicineSupply> pharmacySupplyList = pharmacyService.getPharmacySupplyList(medicineDemand);

		assertNotNull(pharmacySupplyList);
		log.info("testGetPharmacySupplyListPositiveCase END");
	}
	//negative test method to test pharmacysupply list
	@Test
	public void testGetPharmacySupplyListNegative1() {
		log.info("testGetPharmacySupplyListPositiveCase START");
		MedicineDemand medicineDemand = new MedicineDemand(1, "Crocin", 200, "");
		MedicineStockVO medicineStockVO = null;
		Pharmacies pharmacy1 = new Pharmacies(1, "Med-Life");
		Pharmacies pharmacy2 = new Pharmacies(2, "Med-Life");
		Pharmacies pharmacy3 = new Pharmacies(3, "Med-Life");
		List<Pharmacies> pharmaciesList = new ArrayList<>();
		pharmaciesList.add(pharmacy1);
		pharmaciesList.add(pharmacy2);
		pharmaciesList.add(pharmacy3);
		PharmacyMedicineSupply supply=new PharmacyMedicineSupply(1,"Crocin","Med-Life",200);
		List<PharmacyMedicineSupply> supplyList=new ArrayList<>();
		supplyList.add(supply);
		supplyList.add(supply);
		supplyList.add(supply);
		when(pharmaciesRepo.count()).thenReturn((long) 3);
		when(medicineClient.updateStock(1,1800)).thenReturn(new ResponseEntity<Boolean>(true,HttpStatus.OK));
		when(medicineClient.getMedicineStockByMedicineName("Crocin"))
				.thenReturn(new ResponseEntity<MedicineStockVO>(medicineStockVO, HttpStatus.OK));
		when(demandRepo.save(Mockito.any(MedicineDemand.class))).thenReturn(medicineDemand);
		when(supplyRepo.save(Mockito.any(PharmacyMedicineSupply.class))).thenReturn(supply);
		when(supplyRepo.findAll()).thenReturn(supplyList);
		when(pharmaciesRepo.findAll()).thenReturn(pharmaciesList);
		List<PharmacyMedicineSupply> pharmacySupplyList = pharmacyService.getPharmacySupplyList(medicineDemand);

		assertNull(pharmacySupplyList);
		log.info("testGetPharmacySupplyListPositiveCase END");
	}
	//second negative test method to test pharmacysupplylist
	@Test
	public void testGetPharmacySupplyListNegative2() {
		log.info("testGetPharmacySupplyListPositiveCase START");
		MedicineDemand medicineDemand = new MedicineDemand(1, "Crocin", 20000, "");
		MedicineStockVO medicineStockVO =  new MedicineStockVO(1, "Crocin",
				"disaccharide gentiobiose, dicarboxylic acid crocetin", "General", LocalDate.of(2021, 6, 6), 2000,
				"Med-Life");
		Pharmacies pharmacy1 = new Pharmacies(1, "Med-Life");
		Pharmacies pharmacy2 = new Pharmacies(2, "Med-Life");
		Pharmacies pharmacy3 = new Pharmacies(3, "Med-Life");
		List<Pharmacies> pharmaciesList = new ArrayList<>();
		pharmaciesList.add(pharmacy1);
		pharmaciesList.add(pharmacy2);
		pharmaciesList.add(pharmacy3);
		PharmacyMedicineSupply supply=new PharmacyMedicineSupply(1,"Crocin","Med-Life",200);
		List<PharmacyMedicineSupply> supplyList=new ArrayList<>();
		supplyList.add(supply);
		supplyList.add(supply);
		supplyList.add(supply);
		when(pharmaciesRepo.count()).thenReturn((long) 3);
		when(medicineClient.updateStock(1,1800)).thenReturn(new ResponseEntity<Boolean>(true,HttpStatus.OK));
		when(medicineClient.getMedicineStockByMedicineName("Crocin"))
				.thenReturn(new ResponseEntity<MedicineStockVO>(medicineStockVO, HttpStatus.OK));
		when(demandRepo.save(Mockito.any(MedicineDemand.class))).thenReturn(medicineDemand);
		when(supplyRepo.save(Mockito.any(PharmacyMedicineSupply.class))).thenReturn(supply);
		when(supplyRepo.findAll()).thenReturn(supplyList);
		when(pharmaciesRepo.findAll()).thenReturn(pharmaciesList);
		List<PharmacyMedicineSupply> pharmacySupplyList = pharmacyService.getPharmacySupplyList(medicineDemand);

		assertNull(pharmacySupplyList);
		log.info("testGetPharmacySupplyListPositiveCase END");
	}
	//positive pharmacy supply method
	@Test
	public void testGetAllPharmacySupplyPositiveCase() {
		log.info("testGetAllPharmacySupplyPositiveCase START");
		List<PharmacyMedicineSupply> allPharmacySupply = pharmacyService.getAllPharmacySupply();
		assertNotNull(allPharmacySupply);
		log.info("testGetAllPharmacySupplyPositiveCase END");
	}
	//positive test method to get demand
	@Test
	public void testGetDemandPositiveCase() {
		log.info("testGetDemandPositiveCase START");
		List<MedicineDemand> demand = pharmacyService.getDemand();
		assertNotNull(demand);
		log.info("testGetDemandPositiveCase END");
	}

}
