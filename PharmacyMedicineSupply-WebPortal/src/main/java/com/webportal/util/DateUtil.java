package com.webportal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtil {
	//CONVERTS STRING TO LOCALDATE
	public static LocalDate convertToDate(String scheduleStartDate) {

		LocalDate localDate = null;
		try {

			log.info("CONVERTING STRING TO LOCALDATE");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			localDate = LocalDate.parse(scheduleStartDate, formatter);

			log.debug("LOCALDATE : {}", localDate);

		} catch (Exception e) {
			log.error("DATE FORMAT EXCEPTION");
		}

		log.info("CONVERTED TO LOCALDATE");

		return localDate;
	}

}
