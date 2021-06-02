package com.webportal.model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import com.webportal.vomodel.RepScheduleVO;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class RepScheduleTest {

	@InjectMocks
	RepScheduleVO repSchedule;

	@Test
	public void testConstructor() {
		RepScheduleVO schedule=new RepScheduleVO("R1","D1","General","Dolo-650,Crocin","1PM to 2PM",LocalDate.of(2021, 6, 6),"8888888888");
	
	}
	@Test
	public void testSetDatePositiveCase() {
		log.info("testSetDatePositiveCase START");
		LocalDate date = LocalDate.of(2021, 06, 26);
		repSchedule.setDate(date);
		assertEquals(date, repSchedule.getDate());
		log.info("testSetDatePositiveCase END");
	}

	@Test
	public void testSetDocContactNumberPositiveCase() {
		log.info("testSetDocContactNumberPositiveCase START");
		repSchedule.setDocContactNumber("9999999999");
		assertEquals("9999999999", repSchedule.getDocContactNumber());
		log.info("testSetDocContactNumberPositiveCase END");
	}

	@Test
	public void testSetDocNamePositiveCase() {
		log.info("testSetDocNamePositiveCase START");
		repSchedule.setDocName("Dr.Akshay");
		assertEquals("Dr.Akshay", repSchedule.getDocName());
		log.info("testSetDocNamePositiveCase END");
	}

	@Test
	public void testSetMedicineNamePositiveCase() {
		log.info("testSetMedicineNamePositiveCase START");
		repSchedule.setMedicineName("Dolo650,Crocin");
		assertEquals("Dolo650,Crocin", repSchedule.getMedicineName());
		log.info("testSetMedicineNamePositiveCase END");
	}

	@Test
	public void testSetRepNamePositiveCase() {
		log.info("testSetRepNamePositiveCase START");
		repSchedule.setRepName("R1");
		assertEquals("R1", repSchedule.getRepName());
		log.info("testSetRepNamePositiveCase END");
	}

	@Test
	public void testSetSlotPositiveCase() {
		log.info("testSetSlotPositiveCase START");
		repSchedule.setSlot("1PM to 2PM");
		assertEquals("1PM to 2PM", repSchedule.getSlot());
		log.info("testSetSlotPositiveCase END");
	}

	@Test
	public void testSetTeatingAilmentCase() {
		log.info("testSetTeatingAilmentCase START");
		repSchedule.setTeatingAilment("General");
		assertEquals("General", repSchedule.getTeatingAilment());
		log.info("testSetTeatingAilmentCase END");
	}

}
