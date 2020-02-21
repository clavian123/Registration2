package com.app.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.app.registration.eventmodel.SampleResponse;

@SpringBootApplication
public class RegistrationBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationBackEndApplication.class, args);
		System.out.println("Tes");
		
		RestTemplate restTemplate = new RestTemplate();
		  
		final String uri = "http://localhost:8181/send";
		     
		SampleResponse sampleResponse = new SampleResponse();
		sampleResponse.setTransactionTypeCode("registration");
		
		SampleResponse addRest = restTemplate.postForObject( uri, sampleResponse, SampleResponse.class);	     
		System.out.println("added : " + addRest.getTransactionTypeCode());  
	}

}
