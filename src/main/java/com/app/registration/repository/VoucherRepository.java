package com.app.registration.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.registration.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>{
	@Query("select o from Voucher o")
	Set<Voucher> findByAll();
}
