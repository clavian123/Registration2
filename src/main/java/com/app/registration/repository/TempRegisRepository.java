package com.app.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.TempRegis;

@Repository
public interface TempRegisRepository extends JpaRepository<TempRegis, Long> {
	List<TempRegis> findByCifCode(String cifCode);
}
