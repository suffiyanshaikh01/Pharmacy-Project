package com.medicinestock.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicinestock.demo.model.MedicineStock;
import com.medicinestock.demo.repository.MedicineStockRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MedicineStockServiceTest {
	@InjectMocks
	private MedicineStockServiceImpl medicineStockService;
	@Mock
	MedicineStockRepository medicineRepo;

	@Mock
	private MedicineStock medicineStock;
	
	@Test
	public void testGetAllMecidineStock() {
		log.info("testGetAllMecidineStock START");
		LocalDate date = LocalDate.of(2021, 06, 26);
		MedicineStock medStock = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		List<MedicineStock> medicineList = new ArrayList<>();
		medicineList.add(medStock);
		when(medicineRepo.findAll())
		.thenReturn(medicineList);
		List<MedicineStock> allMecidineStock = medicineStockService.getAllMecidineStock();
		assertNotNull(allMecidineStock);
		log.info("testGetAllMecidineStock END");
	}
	
	
	@Test
	public void testUpdateStockPositiveCase() {
		log.info("testUpdateStockPositiveCase START");
		when(medicineRepo.updateStock(1,3))
		.thenReturn(1);
		assertTrue(medicineStockService.updateStock(1, 3));
		log.info("testUpdateStockPositiveCase END");
	}
	@Test
	public void testUpdateStockNegative() {
		log.info("testUpdateStockNegative START");
		when(medicineRepo.updateStock(1,3))
		.thenReturn(0);
		assertFalse(medicineStockService.updateStock(1, 3));
		log.info("testUpdateStockNegative END");
	}
	
	@Test
	public void testGetMedicineByAilmentPositiveCase() {
		log.info("testGetMedicineByAilmentPositiveCase START");
		LocalDate date = LocalDate.of(2021, 06, 26);
		MedicineStock medStock = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		List<MedicineStock> medicineList = new ArrayList<>();
		medicineList.add(medStock);
		when(medicineRepo.getMedicineByAilment("General"))
		.thenReturn(medicineList);
		List<MedicineStock> medicineByAilment = medicineStockService.getMedicineByAilment("General");
		assertNotNull(medicineByAilment);
		log.info("testGetMedicineByAilmentPositiveCase END");
	}
	
	@Test
	public void testGetMedicineByAilmentNegativeCase() {
		log.info("testGetMedicineByAilmentNegativeCase START");
		List<MedicineStock> medicineList = null;
		when(medicineRepo.getMedicineByAilment("xyz"))
		.thenReturn(medicineList);
		List<MedicineStock> medicineByAilment = medicineStockService.getMedicineByAilment("xyz");
		assertNull(medicineByAilment);
		log.info("testGetMedicineByAilmentNegativeCase END");
	}
	
	
	@Test
	public void testGetMedicineStockByMedicineNamePositiveCase() {
		log.info("testGetMedicineStockByMedicineNamePositiveCase START");
		LocalDate date = LocalDate.of(2021, 06, 26);
		MedicineStock medStock = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		when(medicineRepo.getMedicineStockByMedicineName("Crocin"))
		.thenReturn(medStock);
		MedicineStock medicineStockByMedicineName = medicineStockService.getMedicineStockByMedicineName("Crocin");
		assertNotNull(medicineStockByMedicineName);
		log.info("testGetMedicineStockByMedicineNamePositiveCase END");
	}
	@Test
	public void testGetMedicineStockByMedicineNameNegativeCase() {
		log.info("testGetMedicineStockByMedicineNameNegativeCase START");
		MedicineStock medStock = null;
		when(medicineRepo.getMedicineStockByMedicineName("xyz"))
		.thenReturn(medStock);
		MedicineStock medicineStockByMedicineName = medicineStockService.getMedicineStockByMedicineName("xyz");
		assertNull(medicineStockByMedicineName);
		log.info("testGetMedicineStockByMedicineNameNegativeCase END");
	}
}
