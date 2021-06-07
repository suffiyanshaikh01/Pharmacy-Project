package com.pharmacyMedicineSupply.demo.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
//test class to test vo class that is medicine stock
@Slf4j
@SpringBootTest
class MedicineStockVOTest {
	//injecting the vo class
	@InjectMocks
	MedicineStockVO medicineStockVO;
	
	@Test
	public void testConstructor() {
		log.info("MedicineStockVo constructor");
		MedicineStockVO medicineStockVO=new MedicineStockVO(1,"Crocin","disaccharide gentiobiose, dicarboxylic acid crocetin","General",LocalDate.of(2021, 6, 6),2000,"Med-Life");
		
	}
	//test method to test medicine id of vo class using getters and setters
	@Test
	public void testSetMedicineId() {
		medicineStockVO.setMedicineId(1);
		assertEquals(1,medicineStockVO.getMedicineId());
	}
	//test method to test medicine name of vo class using getters and setters
	@Test
	public void testSetMedicineName() {
		medicineStockVO.setMedicineName("Crocin");
		assertEquals("Crocin", medicineStockVO.getMedicineName());
	}
	//test method to test chemicalcomposition using getters and setters
	@Test
	public void testSetChemicalComposition() {
		medicineStockVO.setChemicalComposition("disaccharide gentiobiose, dicarboxylic acid crocetin");
		assertEquals("disaccharide gentiobiose, dicarboxylic acid crocetin", medicineStockVO.getChemicalComposition());
		
	}
	//test method to test targetAilment of vo class using getters and setters
	@Test
	public void testSetTargetAilment() {
		medicineStockVO.setTargetAilment("General");
		assertEquals("General", medicineStockVO.getTargetAilment());
	}
	//test method to test date of expiry of vo class using getters and setters
	@Test
	public void testSetDateOfExpiry() {
		LocalDate date=LocalDate.of(2021, 6, 6);
		medicineStockVO.setDateOfExpiry(date);
		assertEquals(date, medicineStockVO.getDateOfExpiry());
	}
	//test method to test numberoftabletsinstock of vo class using getters and setters
	@Test
	public void testSetNumberOfTabletsInStock() {
		medicineStockVO.setNumberOfTabletsInStock(500);
		assertEquals(500, medicineStockVO.getNumberOfTabletsInStock());
	}
	//test mehod to test godown name of vo class using getters and setters
	@Test
	public void testSetGodownName() {
		medicineStockVO.setGodownName("Med-Life");
		assertEquals("Med-Life", medicineStockVO.getGodownName());
	}

}
