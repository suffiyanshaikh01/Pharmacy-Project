package com.webportal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.webportal.exception.TokenValidationFailedException;
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

@Slf4j
@Controller
public class WebPortalController {

	UserVO obj;

	@Autowired
	AuthorizationClient authClient;

	@Autowired
	MedicalRepresentativeScheduleClient scheduleClient;

	@Autowired
	MedicineStockClient stockClient;

	@Autowired
	PharmacySupplyClient supplyClient;
	String uname;
	String token;
	String loginErrorMessage;

	//FOR LOADING LOGIN PAGE
	@GetMapping("/login")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getLoginPage(ModelMap model) {

		log.info("GETTING LOGIN PAGE");
		model.put("errorMessage", loginErrorMessage);
		return "newLogin";
	}

	//AFTER LOGIN IF CREDENTIALS ARE CORRECT OPEN HOMEPAGE OR REDIRECT TO LOGIN
	@PostMapping("/login")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getLoginPage(@RequestParam String userName, @RequestParam String password, ModelMap model) {

		log.info("VALIDATING USERNAME AND PASSWORD");
		obj = new UserVO();
		obj.setPassword(password);
		obj.setUsername(userName);
		uname = userName;
		model.put("username", uname);
		token = authClient.createAuthenticationToken(obj);
		if (token != null) {
			log.info("VALID USER");
			token = "Bearer " + token;
			loginErrorMessage = "";
			return "redirect:/homepage";
		} else {
			log.error("INVALID CREDENTIALS");
			loginErrorMessage = "Bad Credentials";
			return "redirect:/login";
		}

	}

	//AFTER CHECKING TOKEN REDIRECT TO CREATE SCHEDULE PAGE
	@GetMapping("/createSchedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String createSchedule() {
		try {
			if (isValid()) {
				log.info("RETURNING GIVEREPSCHEDULE PAGE");

				return "giveRepScheduleDate";

			} else {
				log.info("INVALID TOKEN");
				throw new TokenValidationFailedException("Token is not valid");
			}
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	//CREATES SCHEDULE ACCORDING TO THE GIVEN DATE
	@PostMapping("/createSchedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getSchedule(@RequestParam String scheduleStartDate, ModelMap model) {
		log.info("CREATING SCHEDULE");
		LocalDate date = DateUtil.convertToDate(scheduleStartDate);
		if (date.isBefore(LocalDate.now())) {
			log.error("INVALID/PAST DATE");
			model.put("errorMessage", true);
			return "giveRepScheduleDate";
		}
		log.info("SCHEDULE CREATED");
		scheduleClient.getRepSchedule(scheduleStartDate);
		return "redirect:/schedule";
	}

	//THIS RETURNS ALL THE DATA FROM SCHEDULE TABLE
	@GetMapping("/schedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String schedule(ModelMap model) {
		try {
			if (isValid()) {
				log.info("FETCHING SCHEDULE");
				ResponseEntity<List<RepScheduleVO>> allRepSchedule = scheduleClient.getAllRepSchedule();
				List<RepScheduleVO> scheduleList = allRepSchedule.getBody();
				if (scheduleList.isEmpty()) {
					model.put("createScheduleErrorMessage", "No Schedule Found");
				} else
					model.put("scheduleList", scheduleList);

				return "repScheduleList";
			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}

		} catch (TokenValidationFailedException tokenInvalidException) { 
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}

	}

	//THIS RETURNS AVAILABLE STOCKS IN GODOWN
	@GetMapping("/medicineStock")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String medicineStock(ModelMap model) {
		try {
			if (isValid()) {
				log.info("FETCHING MEDICINE STOCK");
				ResponseEntity<List<MedicineStockVO>> allMedicineStock = stockClient.getAllMedicineStock();
				List<MedicineStockVO> medicineStockList = allMedicineStock.getBody();
				model.put("medicineStockList", medicineStockList);

				return "medicineStockList";
			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}

		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	//AFTER CHECKING TOKEN SHOW HOMEPAGE
	@GetMapping("/homepage")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String homepage(ModelMap model) {
		try {
			
			if (isValid()) {
				log.info("VIEWING HOMEPAGE");
				model.put("username", uname);
				return "homepage";
			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}

		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}


	//THIS METHOD PLACES ORDER
	@PostMapping("/medicineDemand")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String medicineDemanPost(@RequestParam String medicineName, @RequestParam int demandCount, ModelMap model) {
		log.info("PLACING ORDER");
		MedicineDemandVO demand = new MedicineDemandVO();
		demand.setMedicineName(medicineName);
		demand.setDemandCount(demandCount);
		supplyClient.getPharmacySupply(demand);
		log.info("ORDER PROCESSED");
		return "redirect:/showMedicineSupply";
	}

	//RETURNS PREVIOUS ORDERS
	@GetMapping("/showMedicineSupply")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String showMedicineSupply(ModelMap model) {
		try {
			if (isValid()) {
				log.info("FETCHING DATA FROM PREVIOUS ORDER");
				ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = supplyClient.getAllPharmacySupply();
				List<PharmacyMedicineSupplyVO> supplyList = allPharmacySupply.getBody();
				if (supplyList.isEmpty()) {
					model.put("supplyListError", "No orders placed yet.....!!!");
				} else
					model.put("supplyList", supplyList);

				return "medicineSupplyList";
			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}

		} catch (

		TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	//RETURNS HISTORY OF ORDERS i.e. ACCEPTED/REJECTED
	@GetMapping("/showMedicineDemand")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String showMedicineDemand(ModelMap model) {
		try {
			if (isValid()) {
				log.info("FETCHING DEMAND HISTORY");
				ResponseEntity<List<MedicineDemandVO>> demandResponseEntity = supplyClient.getDemand();
				List<MedicineDemandVO> demand = demandResponseEntity.getBody();
				if (demand.isEmpty()) {
					model.put("demandListError", "No orders placed yet.....!!!");
				} else
					model.put("demandList", demand);
				return "showMedicineDemand";
			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}

		} catch (

		TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	//LOGOUT 
	@GetMapping("/logout")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String logout() {
		log.info("LOGOUT");
		token = null;
		return "redirect:/login";
	}

	//CHECKS FOR TOKEN VALIDATION
	public boolean isValid()
	{
		if (token != null && authClient.validateToken(token)) {
			log.info("VALID TOKEN");
			return true;
		}
		else {
			log.error("INVALID TOKEN");
			return false;
		}
		
	}
	public String someFailure() {

		return "error";
	}

	public String someFailure(@RequestParam String userName, @RequestParam String password, ModelMap model) {

		return "error";
	}

	public String someFailure(@RequestParam String scheduleStartDate, ModelMap model) {

		return "error";
	}

	public String someFailure(ModelMap model) {

		return "error";
	}

	public String someFailure(@RequestParam String medicineName, @RequestParam int demandCount, ModelMap model) {

		return "error";
	}
}
