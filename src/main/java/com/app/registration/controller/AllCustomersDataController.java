package com.app.registration.controller;

import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.AllCustomersData;
import com.app.registration.model.Customers;
import com.app.registration.model.CekPinResponse;
import com.app.registration.model.TempRegis;
import com.app.registration.model.CheckPanResponse;
import com.app.registration.model.PostRequest;
import com.app.registration.service.AllCustomersDataService;
import com.app.registration.service.CustomersService;
import com.app.registration.service.MailService;
import com.app.registration.service.TempRegisService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AllCustomersDataController {
	
	private static Logger log = Logger.getLogger(AllCustomersDataController.class);
	
	@Autowired
	AllCustomersDataService customerService;
	
	@Autowired
	TempRegisService tempRegisServices;
	
	@Autowired
	CustomersService cusService;
	
	@Autowired
	MailService mailService;
	
	@GetMapping(value ="/allCustomer", headers = "Accept=application/json")
	public List<AllCustomersData> list(){
		List<AllCustomersData> list = null;
		try {
			list = customerService.getAllCustomersData();
		}
		catch(Exception e){
			log.error("Cek jun : "+e.getMessage(), e);
		}
		return list;
	}
	
	@RequestMapping(value = "/checkPan", method = RequestMethod.POST)
	public CheckPanResponse cekToken(@RequestBody PostRequest pan) {
		CheckPanResponse response = new CheckPanResponse();
		Date now = new Date();
		Calendar expired = Calendar.getInstance();
		expired.add(Calendar.MINUTE, 5);
		Date fiveMinutesFromNow = expired.getTime();
		    
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		
		String code = Integer.toString(n);
			
		ObjectMapper mapper = new ObjectMapper();
		
		AllCustomersData data = customerService.getCustomerByPan(pan.getPan());
		
		if(data != null) {
			try {
				String json = mapper.writeValueAsString(data);
				byte jsonByte[] = json.getBytes();
				Blob blob = new SerialBlob(jsonByte);
				TempRegis tempRegis = new TempRegis();
				tempRegis.setCifCode(data.getCifCode());
				tempRegis.setCreatedDate(now);
				tempRegis.setDataRegistration(blob);
				tempRegis.setExpiredDate(fiveMinutesFromNow);
				tempRegis.setToken(code);
			  
				tempRegisServices.saveTempRegis(tempRegis);
				mailService.sendMail(data, code);
				response.setCekPan(true);
				response.setCifCode(data.getCifCode());
			} catch (Exception e) {
				System.err.println("error : " + e.getCause());
			}
		}else {
			response.setCekPan(false);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/checkPin", method = RequestMethod.POST)
	public CekPinResponse cekPin(@RequestBody PostRequest pin) {
		CekPinResponse response = new CekPinResponse();
		AllCustomersData data = customerService.getCustomerByCif(pin.getCif_code());
		Customers data1 = cusService.getCustomerByCifCode(pin.getCif_code());
		
		if(data.getPan().equals(pin.getPan())) {
			if(data.getPin().equals(pin.getPin())) {
				response.setCekPin(true);
				if(data1 == null) {
					response.setType("Registration");
				}else {
					response.setType("ResetPassword");
				}
			}
		}else {
			response.setCekPin(false);
		}
		
		return response;
	}
	
}
