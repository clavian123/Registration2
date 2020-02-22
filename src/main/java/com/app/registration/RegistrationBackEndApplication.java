package com.app.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RegistrationBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationBackEndApplication.class, args);
		System.out.println("Tes");
		
		RestTemplate restTemplate = new RestTemplate();
		  
		final String uri = "http://localhost:8181/send";
		     
		com.app.registration.eventmodel.SampleResponse sampleResponse = new com.app.registration.eventmodel.SampleResponse();
		sampleResponse.setTransactionTypeCode("registration");
		
		com.app.registration.eventmodel.SampleResponse addRest = restTemplate.postForObject( uri, sampleResponse, com.app.registration.eventmodel.SampleResponse.class);	     
		System.out.println("added : " + addRest.getTransactionTypeCode());  
	}

}
