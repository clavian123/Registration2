package com.app.registration.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.registration.eventmodel.SampleResponse;
import com.app.registration.model.AllCustomersData;
import com.app.registration.model.Customers;
import com.app.registration.model.LoginResponse;
import com.app.registration.model.PostRequest;
import com.app.registration.model.RegistrationResponse;
import com.app.registration.model.ResetPasswordResponse;
import com.app.registration.model.User;
import com.app.registration.service.AllCustomersDataService;
import com.app.registration.service.CustomersService;
import com.app.registration.service.UserService;

@RestController
public class UserController {

	@Autowired
	CustomersService custService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AllCustomersDataService allCustService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public RegistrationResponse registration(@RequestBody PostRequest request) {
		int flag = 0;
		RegistrationResponse response = new RegistrationResponse();
		AllCustomersData data = allCustService.getCustomerByCif(request.getCif_code());
		List<User> listData = userService.getAllUsers();
		Customers cust = new Customers();
		User user = new User();
		for (int i = 0; i < listData.size(); i++) {
			if(listData.get(i).getUsername().equals(request.getUsername())) {
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			cust.setAddress(data.getAddress());
			cust.setBirthDate(data.getBirthDate());
			cust.setBirthPlace(data.getBirthPlace());
			cust.setCifCode(data.getCifCode());
			cust.setCity(data.getCity());
			cust.setCreatedBy(data.getCreatedBy());
			cust.setCreatedDate(data.getCreatedDate());
			cust.setCurrentAddress(data.getCurrentAddress());
			cust.setCurrentCity(data.getCurrentCity());
			cust.setCurrentKecamatan(data.getCurrentKecamatan());
			cust.setCurrentKelurahan(data.getCurrentKelurahan());
			cust.setCurrentPostalCode(data.getCurrentPostalCode());
			cust.setCurrentProvince(data.getProvince());
			cust.setCurrentRtRw(data.getCurrentRtRw());
			cust.setEmail(data.getEmail());
			cust.setGender(data.getGender());
			cust.setIdExpiryDate(data.getIdExpiryDate());
			cust.setIdNumber(data.getIdNumber());
			cust.setIdType(data.getIdType());
			cust.setKecamatan(data.getKecamatan());
			cust.setKelurahan(data.getKelurahan());
			cust.setLastUpdatedBy(data.getLastUpdatedBy());
			cust.setLastUpdatedDate(data.getLastUpdatedDate());
			cust.setMaritalStatus(data.getMaritalStatus());
			cust.setMobileNumber(data.getMobileNumber());
			cust.setMonthlyIncome(data.getMonthlyIncome());
			cust.setMothersMaiden(data.getMothersMaiden());
			cust.setName(data.getName());
			cust.setNationality(data.getNationality());
			cust.setOccupation(data.getOccupation());
			cust.setPan(data.getPan());
			cust.setPin(data.getPin());
			cust.setPostalCode(data.getPostalCode());
			cust.setProvince(data.getProvince());
			cust.setRtRw(data.getRtRw());
			cust.setStatus(data.getStatus());
			cust.setTitle(data.getTitle());
			user.setCreatedDate(new Date());
			user.setPassword(request.getPassword());
			user.setUsername(request.getUsername());
			user.setIdCustomer(custService.saveCustomer(cust).getIdCustomer());
			userService.saveUser(user);

			RestTemplate restTemplate = new RestTemplate();
			  
			final String uri = "http://localhost:8181/send";
			     
			SampleResponse sampleResponse = new SampleResponse();
			sampleResponse.setTransactionTypeCode("registration");
			sampleResponse.setLoginName(user.getUsername());
			sampleResponse.setCifCode(request.getCif_code());
			
			SampleResponse addRest = restTemplate.postForObject(uri, sampleResponse, SampleResponse.class);
			
			response.setExist(false);
		}else {
			response.setExist(true);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ResetPasswordResponse resetPassword(@RequestBody PostRequest request) {
		ResetPasswordResponse response = new ResetPasswordResponse();
		Customers data = custService.getCustomerByCifCode(request.getCif_code());
		User userData = userService.findUserByIdCustomer(data.getIdCustomer());
		userData.setPassword(request.getPassword());
		userService.saveUser(userData);
		response.setResetSuccess(true);
		return response;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody PostRequest request) {
		LoginResponse response = new LoginResponse();
		User userData = userService.findUserByUsername(request.getUsername());
		if (userData != null) {
			response.setUsernameIsValid(true);
			if(userData.getPassword().equals(request.getPassword())) {
				response.setLoginSuccess(true);
			}else {
				response.setLoginSuccess(false);
			}
		}else {
			response.setUsernameIsValid(false);
			response.setLoginSuccess(false);
		}
		return response;
	}
}
