package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Customers;
import com.app.registration.repository.CustomersRepository;

@Service
public class CustomersService {
	
	@Autowired
	private CustomersRepository customersRepository;
	
	public List<Customers> getAllCustomers(){
		return customersRepository.findAll();
	}
	
	public Customers getCustomerByCifCode(String cifCode) {
		return customersRepository.findByCifCode(cifCode);
	}
	
	public Customers saveCustomer(Customers customer) {
		return customersRepository.save(customer);
	}
}
