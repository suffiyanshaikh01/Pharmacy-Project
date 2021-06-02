package com.webportal.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.ui.ModelMap;

import com.webportal.feign.AuthorizationClient;
import com.webportal.feign.MedicalRepresentativeScheduleClient;
import com.webportal.feign.MedicineStockClient;
import com.webportal.feign.PharmacySupplyClient;
import com.webportal.util.DateUtil;
import com.webportal.vomodel.MedicineDemandVO;
import com.webportal.vomodel.MedicineStockVO;
import com.webportal.vomodel.PharmacyMedicineSupplyVO;
import com.webportal.vomodel.RepScheduleVO;
import com.webportal.vomodel.UserVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class WebPortalControllerTest {

	@InjectMocks
	WebPortalController webPortalController;
	@Mock
	ModelMap model;
	@Mock
	UserVO obj;
	@Mock
	AuthorizationClient authClient;
	@Mock
	PharmacySupplyClient supplyClient;
	@Mock
	MedicineStockClient stockClient;
	@Mock
	MedicalRepresentativeScheduleClient scheduleClient;

	String token = "ValidToken";

	// TESTING WEBPORTAL CONTROLLER
	@Test
	public void testGetLoginPagePositiveCase() {
		log.info("testGetLoginPagePositiveCase START");
		when(model.put("errorMessage", "ERROR")).thenReturn("");
		String loginPage = webPortalController.getLoginPage(model);
		assertEquals("newLogin", loginPage);
		log.info("testGetLoginPagePositiveCase END");
	}

	@Test
	public void testPostGetLoginPagePositiveCase() {
		log.info("testPostGetLoginPagePositiveCase START");
		when(authClient.createAuthenticationToken(Mockito.any(UserVO.class))).thenReturn(token);
		String loginPage = webPortalController.getLoginPage("imakshay", "pass", model);
		assertEquals("redirect:/homepage", loginPage);
		log.info("testPostGetLoginPagePositiveCase END");
	}

	@Test
	public void testPostGetLoginPageNegativeCase() {
		log.info("testPostGetLoginPageNegativeCase START");
		when(authClient.createAuthenticationToken(Mockito.any(UserVO.class))).thenReturn(null);
		String loginPage = webPortalController.getLoginPage("imakshay", "pass", model);
		assertEquals("redirect:/login", loginPage);
		log.info("testPostGetLoginPageNegativeCase END");
	}

	@Test
	public void testCreateSchedulePositiveCase() {
		log.info("testCreateSchedulePositiveCase START");
		webPortalController.token = null;
		when(authClient.validateToken(null)).thenReturn(false);
		String createSchedule = webPortalController.createSchedule();
		assertEquals("redirect:/login", createSchedule);
		log.info("testCreateSchedulePositiveCase END");
	}

	@Test
	public void testCreateScheduleNegativeCase() {
		log.info("testCreateScheduleNegativeCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		String createSchedule = webPortalController.createSchedule();
		assertEquals("giveRepScheduleDate", createSchedule);
		log.info("testCreateScheduleNegativeCase END");
	}

	@Test
	public void testShowMedicineDemandPositiveCase() {
		log.info("testShowMedicineDemandPositiveCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		MedicineDemandVO demand1 = new MedicineDemandVO("Crocin", 200, "Approved");
		MedicineDemandVO demand2 = new MedicineDemandVO("Dolo-650", 200, "Approved");
		MedicineDemandVO demand3 = new MedicineDemandVO("Crocin", 2000, "Rejected");
		List<MedicineDemandVO> demands = new ArrayList<>();
		demands.add(demand1);
		demands.add(demand2);
		demands.add(demand3);
		when(supplyClient.getDemand()).thenReturn(new ResponseEntity<List<MedicineDemandVO>>(demands, HttpStatus.OK));
		String showMedicineDemand = webPortalController.showMedicineDemand(model);
		assertEquals("showMedicineDemand", showMedicineDemand);
		log.info("testShowMedicineDemandPositiveCase END");

	}

	@Test
	public void testShowMedicineDemandNegativeCase1() {
		log.info("testShowMedicineDemandNegativeCase1 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(false);
		MedicineDemandVO demand1 = new MedicineDemandVO("Crocin", 200, "Approved");
		MedicineDemandVO demand2 = new MedicineDemandVO("Dolo-650", 200, "Approved");
		MedicineDemandVO demand3 = new MedicineDemandVO("Crocin", 2000, "Rejected");
		List<MedicineDemandVO> demands = new ArrayList<>();
		demands.add(demand1);
		demands.add(demand2);
		demands.add(demand3);
		when(supplyClient.getDemand()).thenReturn(new ResponseEntity<List<MedicineDemandVO>>(demands, HttpStatus.OK));
		String showMedicineDemand = webPortalController.showMedicineDemand(model);
		assertEquals("redirect:/login", showMedicineDemand);
		log.info("testShowMedicineDemandNegativeCase1 END");

	}

	@Test
	public void testShowMedicineDemandNegativeCase2() {
		log.info("testShowMedicineDemandNegativeCase2 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		List<MedicineDemandVO> demands = new ArrayList<>();
		when(supplyClient.getDemand()).thenReturn(new ResponseEntity<List<MedicineDemandVO>>(demands, HttpStatus.OK));
		String showMedicineDemand = webPortalController.showMedicineDemand(model);
		assertEquals("showMedicineDemand", showMedicineDemand);
		log.info("testShowMedicineDemandNegativeCase2 END");

	}

	@Test
	public void testMedicineStockPositiveCase() {
		log.info("testMedicineStockPositiveCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		MedicineStockVO stock1 = new MedicineStockVO(1, "Crocin", "X-Y-Z", "General", LocalDate.of(2023, 5, 5), 500,
				"Med-Life");
		MedicineStockVO stock2 = new MedicineStockVO(2, "Crocin", "X-Y-Z", "General", LocalDate.of(2025, 5, 5), 2000,
				"Med-Life");
		MedicineStockVO stock3 = new MedicineStockVO(3, "Crocin", "X-Y-Z", "General", LocalDate.of(2021, 5, 5), 900,
				"Med-Life");
		List<MedicineStockVO> stocks = new ArrayList<>();
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		when(stockClient.getAllMedicineStock())
				.thenReturn(new ResponseEntity<List<MedicineStockVO>>(stocks, HttpStatus.OK));
		String medicineStock = webPortalController.medicineStock(model);
		assertEquals("medicineStockList", medicineStock);
		log.info("testMedicineStockPositiveCase END");
	}

	@Test
	public void testMedicineStockNegativeCase1() {
		log.info("testMedicineStockNegativeCase1 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(false);
		MedicineStockVO stock1 = new MedicineStockVO(1, "Crocin", "X-Y-Z", "General", LocalDate.of(2023, 5, 5), 500,
				"Med-Life");
		MedicineStockVO stock2 = new MedicineStockVO(2, "Crocin", "X-Y-Z", "General", LocalDate.of(2025, 5, 5), 2000,
				"Med-Life");
		MedicineStockVO stock3 = new MedicineStockVO(3, "Crocin", "X-Y-Z", "General", LocalDate.of(2021, 5, 5), 900,
				"Med-Life");
		List<MedicineStockVO> stocks = new ArrayList<>();
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		when(stockClient.getAllMedicineStock())
				.thenReturn(new ResponseEntity<List<MedicineStockVO>>(stocks, HttpStatus.OK));
		String medicineStock = webPortalController.medicineStock(model);
		assertEquals("redirect:/login", medicineStock);
		log.info("testMedicineStockNegativeCase1 END");
	}

	@Test
	public void testMedicineStockNegativeCase2() {
		log.info("testMedicineStockNegativeCase2 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		List<MedicineStockVO> stocks = new ArrayList<>();
		when(stockClient.getAllMedicineStock())
				.thenReturn(new ResponseEntity<List<MedicineStockVO>>(stocks, HttpStatus.OK));
		String medicineStock = webPortalController.medicineStock(model);
		assertEquals("medicineStockList", medicineStock);
		log.info("testMedicineStockNegativeCase2 END");
	}

	@Test
	public void testShowMedicineSupplyPositiveCase() {
		log.info("testShowMedicineSupplyPositiveCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		PharmacyMedicineSupplyVO supply = new PharmacyMedicineSupplyVO("Med-Life", "Dolo-650", 500);
		List<PharmacyMedicineSupplyVO> supplies = new ArrayList<>();
		supplies.add(supply);
		supplies.add(supply);
		supplies.add(supply);

		when(supplyClient.getAllPharmacySupply())
				.thenReturn(new ResponseEntity<List<PharmacyMedicineSupplyVO>>(supplies, HttpStatus.OK));
		String showMedicineSupply = webPortalController.showMedicineSupply(model);
		assertEquals("medicineSupplyList", showMedicineSupply);
		log.info("testShowMedicineSupplyPositiveCase END");
	}

	@Test
	public void testShowMedicineSupplyNegaitiveCase1() {
		log.info("testShowMedicineSupplyNegaitiveCase1 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(false);
		PharmacyMedicineSupplyVO supply = new PharmacyMedicineSupplyVO("Med-Life", "Dolo-650", 500);
		List<PharmacyMedicineSupplyVO> supplies = new ArrayList<>();
		supplies.add(supply);
		supplies.add(supply);
		supplies.add(supply);

		when(supplyClient.getAllPharmacySupply())
				.thenReturn(new ResponseEntity<List<PharmacyMedicineSupplyVO>>(supplies, HttpStatus.OK));
		String showMedicineSupply = webPortalController.showMedicineSupply(model);
		assertEquals("redirect:/login", showMedicineSupply);
		log.info("testShowMedicineSupplyNegaitiveCase1 END");
	}

	@Test
	public void testShowMedicineSupplyNegaitiveCase2() {
		log.info("testShowMedicineSupplyNegaitiveCase2 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		List<PharmacyMedicineSupplyVO> supplies = new ArrayList<>();
		when(supplyClient.getAllPharmacySupply())
				.thenReturn(new ResponseEntity<List<PharmacyMedicineSupplyVO>>(supplies, HttpStatus.OK));
		String showMedicineSupply = webPortalController.showMedicineSupply(model);
		assertEquals("medicineSupplyList", showMedicineSupply);
		log.info("testShowMedicineSupplyNegaitiveCase2 END");
	}

	@Test
	public void testSchedulePositiveCase() {
		log.info("testSchedulePositiveCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);

		RepScheduleVO schedule = new RepScheduleVO("R1", "D1", "General", "Dolo-650,Crocin", "1PM to 2PM",
				LocalDate.of(2021, 6, 6), "8888888888");
		List<RepScheduleVO> schedules = new ArrayList<>();
		schedules.add(schedule);
		schedules.add(schedule);
		schedules.add(schedule);
		when(scheduleClient.getAllRepSchedule())
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(schedules, HttpStatus.OK));
		String schedule2 = webPortalController.schedule(model);
		assertEquals("repScheduleList", schedule2);
		log.info("testSchedulePositiveCase END");

	}

	@Test
	public void testScheduleNegativeCase1() {
		log.info("testScheduleNegativeCase1 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(false);

		RepScheduleVO schedule = new RepScheduleVO("R1", "D1", "General", "Dolo-650,Crocin", "1PM to 2PM",
				LocalDate.of(2021, 6, 6), "8888888888");
		List<RepScheduleVO> schedules = new ArrayList<>();
		schedules.add(schedule);
		schedules.add(schedule);
		schedules.add(schedule);
		when(scheduleClient.getAllRepSchedule())
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(schedules, HttpStatus.OK));
		String schedule2 = webPortalController.schedule(model);
		assertEquals("redirect:/login", schedule2);
		log.info("testScheduleNegativeCase1 END");

	}

	@Test
	public void testScheduleNegativeCase2() {
		log.info("testScheduleNegativeCase2 START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);

		List<RepScheduleVO> schedules = new ArrayList<>();

		when(scheduleClient.getAllRepSchedule())
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(schedules, HttpStatus.OK));
		String schedule2 = webPortalController.schedule(model);
		assertEquals("repScheduleList", schedule2);
		log.info("testScheduleNegativeCase2 END");

	}

	@Test
	public void testHomepagePositiveCase() {
		log.info("testHomepagePositiveCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(true);
		String homepage = webPortalController.homepage(model);
		assertEquals("homepage", homepage);
		log.info("testHomepagePositiveCase END");
	}

	@Test
	public void testHomepageNegativeCase() {
		log.info("testHomepageNegativeCase START");
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(token)).thenReturn(false);
		String homepage = webPortalController.homepage(model);
		assertEquals("redirect:/login", homepage);
		log.info("testHomepageNegativeCase END");
	}

	@Test
	public void testGetSchedulePositiveCase() {
		log.info("testGetSchedulePositiveCase START");

		RepScheduleVO schedule = new RepScheduleVO("R1", "D1", "General", "Dolo-650,Crocin", "1PM to 2PM",
				LocalDate.of(2021, 6, 6), "8888888888");
		List<RepScheduleVO> schedules = new ArrayList<>();
		schedules.add(schedule);
		schedules.add(schedule);
		schedules.add(schedule);

		when(scheduleClient.getRepSchedule("2021-06-06"))
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(schedules, HttpStatus.OK));
		String schedule2 = webPortalController.getSchedule("2021-06-06", model);

		assertEquals("redirect:/schedule", schedule2);
		log.info("testGetSchedulePositiveCase END");

	}

	@Test
	public void testGetScheduleNegativeCase() {
		log.info("testGetScheduleNegativeCase START");

		RepScheduleVO schedule = new RepScheduleVO("R1", "D1", "General", "Dolo-650,Crocin", "1PM to 2PM",
				LocalDate.of(2021, 6, 6), "8888888888");
		List<RepScheduleVO> schedules = new ArrayList<>();
		schedules.add(schedule);
		schedules.add(schedule);
		schedules.add(schedule);

		when(scheduleClient.getRepSchedule("2020-06-06"))
				.thenReturn(new ResponseEntity<List<RepScheduleVO>>(schedules, HttpStatus.OK));
		String schedule2 = webPortalController.getSchedule("2020-06-06", model);

		assertEquals("giveRepScheduleDate", schedule2);
		log.info("testGetScheduleNegativeCase END");

	}

	@Test
	public void testMedicineDemanPostPositiveCase() {
		log.info("testMedicineDemanPostPositiveCase START");

		PharmacyMedicineSupplyVO supply = new PharmacyMedicineSupplyVO("Med-Life", "Dolo-650", 500);
		List<PharmacyMedicineSupplyVO> supplies = new ArrayList<>();
		supplies.add(supply);
		supplies.add(supply);
		supplies.add(supply);

		MedicineDemandVO demand = new MedicineDemandVO();
		demand.setMedicineName("Crocin");
		demand.setDemandCount(200);
		when(supplyClient.getPharmacySupply(demand))
				.thenReturn(new ResponseEntity<List<PharmacyMedicineSupplyVO>>(supplies, HttpStatus.OK));
		String medicineDemanPost = webPortalController.medicineDemanPost("Crocin", 200, model);
		assertEquals("redirect:/showMedicineSupply", medicineDemanPost);
		log.info("testMedicineDemanPostPositiveCase END");
	}

	@Test
	public void someFailure1() {
		String someFailure = webPortalController.someFailure();
		assertEquals("error", someFailure);

	}

	@Test
	public void someFailure2() {
		String someFailure = webPortalController.someFailure(model);
		assertEquals("error", someFailure);
	}

	@Test
	public void someFailure3() {
		String someFailure = webPortalController.someFailure(token, model);
		assertEquals("error", someFailure);

	}

	@Test
	public void someFailure4() {
		String someFailure = webPortalController.someFailure(token, 0, model);
		assertEquals("error", someFailure);

	}

	@Test
	public void someFailure5() {
		String someFailure = webPortalController.someFailure(token, token, model);
		assertEquals("error", someFailure);

	}

	@Test
	public void testIsValidPositive() {
		webPortalController.token = "ValidToken";
		when(authClient.validateToken(Mockito.anyString())).thenReturn(true);
		boolean valid = webPortalController.isValid();
		assertTrue(valid);
	}

	@Test
	public void testIsValidNegative() {
		when(authClient.validateToken(Mockito.anyString())).thenReturn(false);
		boolean valid = webPortalController.isValid();
		assertFalse(valid);
	}

	@Test
	public void testLogout() {
		String logout = webPortalController.logout();
		assertEquals("redirect:/login", logout);
	}

}
