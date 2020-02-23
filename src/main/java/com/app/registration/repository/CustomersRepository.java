package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
	Customers findByCifCode(String cifCode); 
}
