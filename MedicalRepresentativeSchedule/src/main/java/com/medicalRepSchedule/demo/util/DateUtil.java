package com.medicalRepSchedule.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtil {

	public static LocalDate getDate(String scheduleStartDate) {
		// THIS CLASS CONVERTS STRING DATE TO THE LOCALDATE
		LocalDate localDate = null;

		log.info("STARTED CONVERTING STRING DATE TO LOCALDATE");
		try {

			log.info("Start");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			localDate = LocalDate.parse(scheduleStartDate, formatter);
			log.debug("LOCALDATE  : {}", localDate);

		} catch (Exception e) {
			log.error("DATE FORMAT EXCEPTION");
		}

		log.info("CONVERTED SUCCESSFULLY");

		return localDate;
	}

}
