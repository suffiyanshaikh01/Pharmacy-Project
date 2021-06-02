package com.medicalRepSchedule.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.medicalRepSchedule.demo.model.Doctor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvParseUtil {
	//THIS CLASS RETURNS LIST OF DOCTORS BY ACCEPTING INPUT FROM CSV FILE
	public static List<Doctor> parseDoctors() {
		log.info("STARTED READING CSV FILE");

		final List<Doctor> doctors = new ArrayList<>();

		ClassLoader classLoader = CsvParseUtil.class.getClassLoader();

		InputStream in = classLoader.getResourceAsStream("Doctor.csv");

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {

			String line = null;
			line = bufferedReader.readLine();

			while (line != null) {
				String[] entry = line.split(",");

				Doctor doctor = new Doctor(Integer.parseInt(entry[0]), entry[1], entry[2], entry[3]);

				doctors.add(doctor);
				line = bufferedReader.readLine();
			}

		} catch (IOException e) {
			log.error("File not found");
		}

		log.debug("DOCTORS : {}", doctors);

		log.info("STORED CSV FILE DATE IN THE LIST AND SENT BACK");

		return doctors;
	}
}