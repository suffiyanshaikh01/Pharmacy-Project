package com.medicinestock.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicineStockServiceApplicationTests {

	@Test
	void contextLoads() {
		//main test class
	}
//	BELOW IS THE CODE TO TEST THE MAIN APPLICATION
	@Test
	public void applicationContextTest() {
	    MedicineStockServiceApplication.main(new String[] {});
	}

}
