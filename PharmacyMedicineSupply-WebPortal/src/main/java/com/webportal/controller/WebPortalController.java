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

	@GetMapping("/login")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getLoginPage(ModelMap model) {
		
		model.put("errorMessage",loginErrorMessage);
		return "newLogin";
	}

	@PostMapping("/login")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getLoginPage(@RequestParam String userName, @RequestParam String password, ModelMap model) {

		obj = new UserVO();
		obj.setPassword(password);
		obj.setUsername(userName);
		uname = userName;
		// System.out.println(uname);
		model.put("username", uname);
		token = authClient.createAuthenticationToken(obj);
		if (token != null) {
			token = "Bearer " + token;
			System.out.println("RESULT : " + token);
			System.out.println("Login Done !!!!!!!");
			loginErrorMessage="";
			return "redirect:/homepage";
		} else {
			loginErrorMessage = "Bad Credentials";
			return "redirect:/login";
		}

	}

	@GetMapping("/createSchedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String createSchedule() {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {
					return "giveRepScheduleDate";

				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else {
				throw new TokenValidationFailedException("Token is not valid");
			}
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@PostMapping("/createSchedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String getSchedule(@RequestParam String scheduleStartDate, ModelMap model) {
		LocalDate date = DateUtil.convertToDate(scheduleStartDate);
		if (date.isBefore(LocalDate.now())) {
			model.put("errorMessage", true);

			return "giveRepScheduleDate";

		}
		scheduleClient.getRepSchedule(scheduleStartDate);
		return "redirect:/schedule";
	}

	@GetMapping("/schedule")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String schedule(ModelMap model) {
		try {
			if (token != null) {

				if (authClient.validateToken(token)) {

					ResponseEntity<List<RepScheduleVO>> allRepSchedule = scheduleClient.getAllRepSchedule();
					List<RepScheduleVO> scheduleList = allRepSchedule.getBody();
					if(scheduleList.isEmpty()) {
						model.put("createScheduleErrorMessage","No Schedule Found");
					}
					else
					    model.put("scheduleList", scheduleList);

					return "repScheduleList";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");

		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}

	}

	@GetMapping("/medicineStock")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String medicineStock(ModelMap model) {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {

					ResponseEntity<List<MedicineStockVO>> allMedicineStock = stockClient.getAllMedicineStock();
					List<MedicineStockVO> medicineStockList = allMedicineStock.getBody();
					model.put("medicineStockList", medicineStockList);

					return "medicineStockList";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@GetMapping("/homepage")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String homepage(ModelMap model) {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {
					model.put("username", uname);
					return "homepage";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@GetMapping("/medicineDemand")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String medicineDemand(ModelMap model) {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {

					ResponseEntity<List<MedicineStockVO>> allMedicineStock = stockClient.getAllMedicineStock();
					List<MedicineStockVO> medicineStockList = allMedicineStock.getBody();
					model.put("medicineStockList", medicineStockList);

					return "medicineDemand";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@PostMapping("/medicineDemand")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String medicineDemanPost(@RequestParam String medicineName, @RequestParam int demandCount, ModelMap model) {
		MedicineDemandVO demand = new MedicineDemandVO();
		demand.setMedicineName(medicineName);
		demand.setDemandCount(demandCount);
		System.out.println(demand.getMedicineName() + " " + demand.getDemandCount());
		supplyClient.getPharmacySupply(demand);
		return "redirect:/showMedicineSupply";
	}

	@GetMapping("/showMedicineSupply")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String showMedicineSupply(ModelMap model) {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {
					ResponseEntity<List<PharmacyMedicineSupplyVO>> allPharmacySupply = supplyClient
							.getAllPharmacySupply();
					List<PharmacyMedicineSupplyVO> supplyList = allPharmacySupply.getBody();
					if(supplyList.isEmpty()) {
						model.put("supplyListError", "No orders placed yet.....!!!");
					}
					else
						model.put("supplyList", supplyList);

					return "medicineSupplyList";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@GetMapping("/showMedicineDemand")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String showMedicineDemand(ModelMap model) {
		try {
			if (token != null) {
				if (authClient.validateToken(token)) {

					ResponseEntity<List<MedicineDemandVO>> demandResponseEntity = supplyClient.getDemand();
					List<MedicineDemandVO> demand = demandResponseEntity.getBody();
					if(demand.isEmpty()) {
						model.put("demandListError", "No orders placed yet.....!!!");
					}
					else
						model.put("demandList", demand);
					return "showMedicineDemand";
				} else {
					throw new TokenValidationFailedException("Token is not valid");
				}

			} else
				throw new TokenValidationFailedException("Token is not valid");
		} catch (TokenValidationFailedException tokenInvalidException) {
			log.error(tokenInvalidException.toString());
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	@HystrixCommand(fallbackMethod = "someFailure")
	public String logout() {
		token = null;
		return "logout";
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
