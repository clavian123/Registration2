package com.app.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.UserVoucher;

@Repository
public interface UserVoucherRepository extends JpaRepository<UserVoucher, Long>{
	List<UserVoucher> findByLoginName(String loginName);
}
