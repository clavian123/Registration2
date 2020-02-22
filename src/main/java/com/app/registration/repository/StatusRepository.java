package com.app.registration.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.registration.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
	@Query("select o from Status o where o.name like 'Active' ")
	Set<Status> findByActive();
}
