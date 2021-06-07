package com.medicinestock.demo.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicinestock.demo.model.MedicineStock;
import com.medicinestock.demo.service.MedicineStockServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MedicineStockControllerTest {

	@InjectMocks
	private MedicineStockController medicineStockController;

	@Mock
	private MedicineStock medicineStock;

	@Mock
	private MedicineStockServiceImpl medicineStockService;

	private LocalDate date = LocalDate.of(2022, 9, 12);

	@Test
	public void contextLoads() {
		assertNotNull(medicineStockController);
	}

//	TESTING THE getMedicineStockInformationPositiveCase
	@Test
	public void testGetMedicineStockInformationPositiveCase() throws Exception {

		log.info("testGetMedicineStockInformation Positive START");
		MedicineStock medStock = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		List<MedicineStock> medicineList = new ArrayList<>();
		medicineList.add(medStock);
		when(medicineStockService.getAllMecidineStock()).thenReturn(medicineList);
		ResponseEntity<?> allMedicineStock = medicineStockController.getAllMedicineStock();
		HttpStatus status = allMedicineStock.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK, status);
		assertNotNull(allMedicineStock.getBody());
		log.info("testGetMedicineStockInformation Positive END");
	}

//	TESTING THE getMedicineStockInformationNegativeCase
	@Test
	public void testGetMedicineStockInformationNegativeCase() throws Exception {
		log.info("testGetMedicineStockInformation Negative START");

		List<MedicineStock> medicineList = null;
		when(medicineStockService.getAllMecidineStock()).thenReturn(medicineList);
		ResponseEntity<?> allMedicineStock = medicineStockController.getAllMedicineStock();
		HttpStatus status = allMedicineStock.getStatusCode();
		assertNull(allMedicineStock.getBody());
		log.info("testGetMedicineStockInformation Negative END");
	}

//	TESTING THE GetMedicineStockByMedicineNamePositiveCase
	@Test
	public void testGetMedicineStockByMedicineNamePositiveCase() throws Exception {
		log.info("testGetMedicineStockByMedicineNamePositiveCase START");

		MedicineStock medStock = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		when(medicineStockService.getMedicineStockByMedicineName("Crocin")).thenReturn(medStock);
		ResponseEntity<MedicineStock> medicineStockByMedicineName = medicineStockController
				.getMedicineStockByMedicineName("Crocin");
		HttpStatus statusCode = medicineStockByMedicineName.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		assertEquals(medStock, medicineStockByMedicineName.getBody());
		log.info("testGetMedicineStockByMedicineNamePositiveCase END");
	}

//	TESTING THE GetMedicineStockByMedicineNameNegativeCase	
	@Test
	public void testGetMedicineStockByMedicineNameNegativeCase() throws Exception {
		log.info("getMedicineStockByMedicineNameNegativeCase START");

		MedicineStock medStock = null;

		when(medicineStockService.getMedicineStockByMedicineName("xyz")).thenReturn(medStock);
		ResponseEntity<MedicineStock> medicineStockByMedicineName = medicineStockController
				.getMedicineStockByMedicineName("xyz");

		HttpStatus statusCode = medicineStockByMedicineName.getStatusCode();
		assertEquals(medStock, medicineStockByMedicineName.getBody());
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
		log.info("getMedicineStockByMedicineNameNegativeCase END");
	}

//	TESTING THE GetMedicineByAilmentPositiveCase		
	@Test
	public void testGetMedicineByAilmentPositiveCase() throws Exception {
		log.info("testGetMedicineByAilmentPositiveCase START");
		MedicineStock medStock1 = new MedicineStock(1, "Crocin", "x,y,z", "General", date, 200, "abc");
		MedicineStock medStock2 = new MedicineStock(1, "Dolo-650", "x,y,z", "General", date, 200, "abc");
		List<MedicineStock> medicineList = new ArrayList<>();
		medicineList.add(medStock1);
		medicineList.add(medStock2);
		when(medicineStockService.getMedicineByAilment("General")).thenReturn(medicineList);

		ResponseEntity<String[]> medicineByAilment = medicineStockController.getMedicineByAilment("General");

		HttpStatus statusCode = medicineByAilment.getStatusCode();

		assertEquals(HttpStatus.OK, statusCode);
		assertNotNull(medicineByAilment.getBody());
		log.info("testGetMedicineByAilmentPositiveCase END");
	}

//	TESTING THE GetMedicineByAilmentNegativeCase	
	@Test
	public void testGetMedicineByAilmentNegativeCase() throws Exception {
		log.info("testGetMedicineByAilmentNegativeCase START");

		List<MedicineStock> medicineList = new ArrayList<>();

		when(medicineStockService.getMedicineByAilment("xyz")).thenReturn(medicineList);

		ResponseEntity<String[]> medicineByAilment = medicineStockController.getMedicineByAilment("xyz");

		HttpStatus statusCode = medicineByAilment.getStatusCode();

		assertEquals(HttpStatus.OK, statusCode);
		assertNull(medicineByAilment.getBody());
		log.info("testGetMedicineByAilmentNegativeCase END");
	}

//	TESTING THE UpdateStockPositiveCase	
	@Test
	public void testUpdateStockPositiveCase() throws Exception {
		log.info("testUpdateStockPositiveCase START");
		
		when(medicineStockService.updateStock(1, 200)).thenReturn(true);
		ResponseEntity<Boolean> updateStock = medicineStockController.updateStock(1, 200);
		assertTrue(updateStock.getBody());
		log.info("testUpdateStockPositiveCase END");
	}

//	TESTING THE UpdateStockNegativeCase
	@Test
	public void testUpdateStockNegativeCase() throws Exception {
		log.info("testUpdateStockNegativeCas START");
		when(medicineStockService.updateStock(-1, 200)).thenReturn(false);
		ResponseEntity<Boolean> updateStock = medicineStockController.updateStock(-1, 200);
		assertFalse(updateStock.getBody());
	
		log.info("testUpdateStockNegativeCas END");
	}

}
