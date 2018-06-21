package com.hospital.doctoroffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoctorOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorOfficeApplication.class, args);
	}
}
