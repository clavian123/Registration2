package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.AllCustomersData;

@Repository
public interface AllCustomersDataRepository extends JpaRepository<AllCustomersData, Long>{
	AllCustomersData findByPan(String pan);
	AllCustomersData findByCifCode(String cifCode);
}
