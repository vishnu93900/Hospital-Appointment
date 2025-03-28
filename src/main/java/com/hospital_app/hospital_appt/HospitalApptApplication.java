package com.hospital_app.hospital_appt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class HospitalApptApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApptApplication.class, args);
		System.out.println("hello");

	}


}
