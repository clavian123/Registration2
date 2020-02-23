package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.UserVoucher;
import com.app.registration.repository.UserVoucherRepository;

@Service
public class UserVoucherService {

	@Autowired
	private UserVoucherRepository userVoucherRepository;
	
	public UserVoucher saveUserVoucher(UserVoucher userVoucher) {
		return userVoucherRepository.save(userVoucher);
	}
	
	public List<UserVoucher> findUserVoucherByLoginName(String loginName){
		return userVoucherRepository.findByLoginName(loginName);
	}
}
