package com.webportal.feignTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.webportal.feign.AuthorizationClient;
import com.webportal.feign.MedicalRepresentativeScheduleClient;
import com.webportal.feign.MedicineStockClient;
import com.webportal.feign.PharmacySupplyClient;
import com.webportal.vomodel.MedicineDemandVO;
import com.webportal.vomodel.MedicineStockVO;
import com.webportal.vomodel.PharmacyMedicineSupplyVO;
import com.webportal.vomodel.RepScheduleVO;
import com.webportal.vomodel.UserVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class FeignTest {
	@Mock
	private MedicineStockVO medicineStock;
	@Mock
	private MedicineStockClient medicineClient;
	@Mock
	private List<MedicineStockVO> medicineStockList;
	@Mock
	PharmacySupplyClient pharmacyClient;
	@Mock
	PharmacyMedicineSupplyVO pharmacyMedicineSupply;
	@Mock
	List<PharmacyMedicineSupplyVO> pharmacyMedicineSupplyList;
	@Mock
	MedicineDemandVO medDemandPositive, medDemandNegative;
	@Mock
	List<MedicineDemandVO> medDemandList;
	@Mock
	MedicalRepresentativeScheduleClient medicalRepClient;
	@Mock
	RepScheduleVO repSchedule;
	@Mock
	List<RepScheduleVO> repScheduleList;
	@Mock
	AuthorizationClient authClient;
	@Mock
	UserVO user;



	// MedicineStock Feign test-cases

	@Test
	public void testGetAllMedicineStockPositiveCase() {
		log.info("testGetAllMedicineStockPositiveCase START");
		when(medicineClient.getAllMedicineStock())
				.thenReturn(new ResponseEntity<List<MedicineStockVO>>(medicineStockList, HttpStatus.OK));
		ResponseEntity<List<MedicineStockVO>> allMedicineStock = medicineClient.getAllMedicineStock();
		assertNotNull(allMedicineStock.getBody());
		assertEquals(HttpStatus.OK, allMedicineStock.getStatusCode());
		log.info("testGetAllMedicineStockPositiveCase END");
	}

	@Test
	public void testGetAllMedicineStockNegativeCase() {
		log.info("testGetAllMedicineStockNegativeCase START");
		when(medicineClient.getAllMedicineStock()).thenReturn(
				new ResponseEntity<List<MedicineStockVO>>(medicineStockList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<MedicineStockVO>> allMedicineStock = medicineClient.getAllMedicineStock();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, allMedicineStock.getStatusCode());
		log.info("testGetAllMedicineStockNegativeCase END");
	}

	// PharmacyMedicineSupply Feign test-cases

	@Test
	public void testGetAllPharmacySupplyPositiveCase() {
		log.info("testGetAllPharmacySupplyPositiveCase START");
		when(pharmacyClient.getAllPharmacySupply()).thenReturn(
				new ResponseEntity<List<PharmacyMedicineSupplyVO>>(pharmacyMedicineSupplyList, HttpStatus.OK));
		ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = pharmacyClient.getAllPharmacySupply();
		assertNotNull(allPharmacySupply.getBody());
		assertEquals(HttpStatus.OK, allPharmacySupply.getStatusCode());
		log.info("testGetAllPharmacySupplyPositiveCase END");
	}

	@Test
	public void testGetAllPharmacySupplyNegativeCase() {
		log.info("testGetAllPharmacySupplyNegativeCase START");
		when(pharmacyClient.getAllPharmacySupply()).thenReturn(new ResponseEntity<List<PharmacyMedicineSupplyVO>>(
				pharmacyMedicineSupplyList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = pharmacyClient.getAllPharmacySupply();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, allPharmacySupply.getStatusCode());
		log.info("testGetAllPharmacySupplyNegativeCase END");
	}

	@Test
	public void testGetDemandPositiveCase() {
		log.info("testGetDemandPositiveCase START");
		when(pharmacyClient.getDemand())
				.thenReturn(new ResponseEntity<List<MedicineDemandVO>>(medDemandList, HttpStatus.OK));
		ResponseEntity<List<MedicineDemandVO>> demand = pharmacyClient.getDemand();
		assertNotNull(demand.getBody());
		assertEquals(HttpStatus.OK, demand.getStatusCode());
		log.info("testGetDemandPositiveCase END");
	}

	@Test
	public void testGetDemandNegativeCase() {
		log.info("testGetDemandNegativeCase START");
		when(pharmacyClient.getDemand()).thenReturn(
				new ResponseEntity<List<MedicineDemandVO>>(medDemandList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<MedicineDemandVO>> demand = pharmacyClient.getDemand();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, demand.getStatusCode());
		log.info("testGetDemandNegativeCase END");
	}

	@Test
	public void testGetPharmacySupplyPositiveCase() {
		log.info("testGetPharmacySupplyPositiveCase START");
		when(pharmacyClient.getPharmacySupply(medDemandPositive)).thenReturn(
				new ResponseEntity<List<PharmacyMedicineSupplyVO>>(pharmacyMedicineSupplyList, HttpStatus.OK));
		ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = pharmacyClient
				.getPharmacySupply(medDemandPositive);
		assertNotNull(allPharmacySupply.getBody());
		assertEquals(HttpStatus.OK, allPharmacySupply.getStatusCode());
		log.info("testGetPharmacySupplyPositiveCase END");
	}

	@Test
	public void testGetPharmacySupplyNegativeCase() {
		log.info("testGetPharmacySupplyNegativeCase START");
		List<PharmacyMedicineSupplyVO> nullList = null;
		when(pharmacyClient.getPharmacySupply(medDemandNegative)).thenReturn(
				new ResponseEntity<List<PharmacyMedicineSupplyVO>>(nullList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = pharmacyClient
				.getPharmacySupply(medDemandNegative);
		assertNull(allPharmacySupply.getBody());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, allPharmacySupply.getStatusCode());
		log.info("testGetPharmacySupplyNegativeCase END");
	}

	// MedicalRepSchedule Feign test-cases
	@Test
	public void testGetAllRepSchedulePositiveCase() {
		log.info("testGetAllRepSchedulePositiveCase START");
		when(medicalRepClient.getAllRepSchedule())
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(repScheduleList, HttpStatus.OK));
		ResponseEntity<List<RepScheduleVO>> allRepSchedule = medicalRepClient.getAllRepSchedule();
		assertNotNull(allRepSchedule.getBody());
		assertEquals(HttpStatus.OK, allRepSchedule.getStatusCode());
		log.info("testGetAllRepSchedulePositiveCase END");
	}

	@Test
	public void testGetAllRepScheduleNegativeCase() {
		log.info("testGetAllRepScheduleNegativeCase START");
		List<RepScheduleVO> nullList = null;
		when(medicalRepClient.getAllRepSchedule())
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(nullList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<RepScheduleVO>> allRepSchedule = medicalRepClient.getAllRepSchedule();
		assertNull(allRepSchedule.getBody());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, allRepSchedule.getStatusCode());
		log.info("testGetAllRepScheduleNegativeCase END");
	}

	@Test
	public void testGetRepSchedulePositiveCase() {
		log.info("testGetRepSchedulePositiveCase START");
		when(medicalRepClient.getRepSchedule("2021-06-26"))
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(repScheduleList, HttpStatus.OK));
		ResponseEntity<List<RepScheduleVO>> repScheduleList = medicalRepClient.getRepSchedule("2021-06-26");
		assertNotNull(repScheduleList.getBody());
		assertEquals(HttpStatus.OK, repScheduleList.getStatusCode());
		log.info("testGetRepSchedulePositiveCase END");
	}

	@Test
	public void testGetRepScheduleNegativeCase() {
		log.info("testGetRepScheduleNegativeCase START");
		List<RepScheduleVO> nullList = null;
		when(medicalRepClient.getRepSchedule("1999-06-26"))
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(nullList, HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<List<RepScheduleVO>> repScheduleList = medicalRepClient.getRepSchedule("1999-06-26");
		assertNull(repScheduleList.getBody());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, repScheduleList.getStatusCode());
		log.info("testGetRepScheduleNegativeCase END");
	}
	
	//Authetication Feign test-case
	@Test
	public void testCreateAuthenticationTokenPositiveCase() {
		log.info("testCreateAuthenticationTokenPositiveCase START");
		user.setUsername("admin");
		user.setPassword("root");
		when(authClient.createAuthenticationToken(user))
		.thenReturn("TOKEN");
		String authenticationToken = authClient.createAuthenticationToken(user);
		assertNotNull(authenticationToken);
		log.info("testCreateAuthenticationTokenPositiveCase END");
	}
	
	@Test
	public void testCreateAuthenticationTokenNegativeCase() {
		log.info("testCreateAuthenticationTokenNegativeCase START");
		user.setUsername("ABC");
		user.setPassword("ABC");
		when(authClient.createAuthenticationToken(user))
		.thenReturn(null);
		String authenticationToken = authClient.createAuthenticationToken(user);
		assertNull(authenticationToken);
		log.info("testCreateAuthenticationTokenNegativeCase END");
	}
	
	@Test
	public void testValidateTokenPostivieCase() {
		log.info("testValidateTokenPostivieCase START");
		when(authClient.validateToken("TOKEN"))
		.thenReturn(true);
		Boolean validateToken = authClient.validateToken("TOKEN");
		assertTrue(validateToken);
		log.info("testValidateTokenPostivieCase END");
	}
	
	@Test
	public void testValidateTokenNegativeCase() {
		log.info("testValidateTokenNegativeCase START");
		when(authClient.validateToken(null))
		.thenReturn(false);
		Boolean validateToken = authClient.validateToken(null);
		assertFalse(validateToken);
		log.info("testValidateTokenNegativeCase END");
	}
	

}

















