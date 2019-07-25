package com.aurigaInterviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AurigaInterviewsKkApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(AurigaInterviewsKkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
