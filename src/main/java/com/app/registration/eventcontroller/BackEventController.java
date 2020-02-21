package com.app.registration.eventcontroller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.eventmodel.BackRequest;
import com.app.registration.eventmodel.BackResponse;

@RestController
public class BackEventController {
	@RequestMapping("/backsample")
	public BackResponse BackSample(@RequestParam(value = "Validation",
	defaultValue = "Validation") String Validation, String SetOfReward) {
		BackResponse backResponse = new BackResponse();
		backResponse.setValidation(Validation);
		backResponse.setSetOfReward(SetOfReward);
		return backResponse;

	}
	
	@RequestMapping(value = "/backsend", method = RequestMethod.POST)
	public BackResponse Test(@RequestBody BackRequest inputBackPayload) {
		BackResponse backResponse = new BackResponse();
		backResponse.setValidation(inputBackPayload.getValidation());
		backResponse.setSetOfReward(inputBackPayload.getSetOfReward());
		backResponse.setExtra("Hai");
		
		System.out.println(backResponse.getValidation() + " " + backResponse.getSetOfReward());
		return backResponse;
	}

}
