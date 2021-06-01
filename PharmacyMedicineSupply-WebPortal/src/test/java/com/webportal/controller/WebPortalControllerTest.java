package com.webportal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;

import com.webportal.feign.AuthorizationClient;
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
	
	String token;
	
	@Test
	public void testGetLoginPagePositiveCase() {
		log.info("testGetLoginPagePositiveCase START");
		when(model.put("errorMessage","ERROR")).thenReturn("");
		String loginPage = webPortalController.getLoginPage(model);
		assertEquals("newLogin", loginPage);
		log.info("testGetLoginPagePositiveCase END");
	}
	
	@Test
	public void testPostGetLoginPagePositiveCase() {
		log.info("testPostGetLoginPagePositiveCase START");
		when(authClient.createAuthenticationToken(obj)).thenReturn(token);
		String loginPage = webPortalController.getLoginPage("imakshay", "pass", model);
		assertNotNull(loginPage);
		log.info("testPostGetLoginPagePositiveCase END");
	}
	
	@Test
	public void testCreateSchedulePostitiveCase() {
		log.info("testCreateSchedulePostitiveCase START");
		when(authClient.validateToken(token)).thenReturn(true);
		String createSchedule = webPortalController.createSchedule();
		assertNotNull(createSchedule); 
		log.info("testCreateSchedulePostitiveCase END");
	}

}
