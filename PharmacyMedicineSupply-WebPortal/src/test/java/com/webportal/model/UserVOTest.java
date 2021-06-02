package com.webportal.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.validator.PublicClassValidator;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import com.webportal.vomodel.MedicineStockVO;
import com.webportal.vomodel.UserVO;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class UserVOTest {
	@InjectMocks
	UserVO user;
	
	@Test
	public void testConstructor() {
		MedicineStockVO stock=new MedicineStockVO(1,"Crocin","X-Y-Z","General",LocalDate.of(2023, 5, 5),500,"Med-Life");
	}
	
	@Test
	public void testSetUsernamePositiveCase() {
		log.info("testSetUsernamePositiveCase START");
		user.setUsername("Akshay");
		assertEquals("Akshay", user.getUsername());
		log.info("testSetUsernamePositiveCase END");
	}
	@Test
	public void testSetPasswordPositiveCase() {
		log.info("testSetPasswordPositiveCase START");
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
		log.info("testSetPasswordPositiveCase END");
	}

}
