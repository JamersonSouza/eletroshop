package com.jamersondev.eletroshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EletroshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EletroshopApplication.class, args);
	}

}
