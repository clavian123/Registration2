package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.AllCustomersData;
import com.app.registration.repository.AllCustomersDataRepository;

@Service
public class AllCustomersDataService {
	
	@Autowired
	private AllCustomersDataRepository allCustomerRepository;
	
	public List<AllCustomersData> getAllCustomersData(){
		return allCustomerRepository.findAll();
	}
	
	public AllCustomersData getCustomerByPan(String pan) {
		return allCustomerRepository.findByPan(pan);
	}
	
	public String getCifCodeByPan(String pan) {
		return allCustomerRepository.findByPan(pan).getCifCode();
	}
	
	public AllCustomersData getCustomerByCif(String cifCode) {
		return allCustomerRepository.findByCifCode(cifCode);
	}
	
}
