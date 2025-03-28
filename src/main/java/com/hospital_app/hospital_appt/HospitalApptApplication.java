package com.hospital_app.hospital_appt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Hospital Appointment Service API", version = "v1", description = "API for managing hospital appointments and patients")
)
@EnableAsync
public class HospitalApptApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApptApplication.class, args);
		System.out.println("hello");

	}


}
