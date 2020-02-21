package com.app.registration.eventcontroller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.eventmodel.PostRequest;
import com.app.registration.eventmodel.PostResponse;
import com.app.registration.eventmodel.SampleResponse;



@RestController
public class EventManagerController {

	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "TransactionTypeCode",
	defaultValue = "TransactionTypeCode") String TransactionTypeCode) {
		SampleResponse response = new SampleResponse();
		response.setTransactionTypeCode(TransactionTypeCode);
		return response;

	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setTransactionTypeCode(inputPayload.getTransactionTypeCode());
		response.setExtra("Hai");
		return response;
	}
}
