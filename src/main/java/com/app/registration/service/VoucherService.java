package com.app.registration.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Voucher;
import com.app.registration.repository.VoucherRepository;

@Service
public class VoucherService {
	
	@Autowired
	VoucherRepository voucherRepository;
	
	public Optional<Voucher> findVoucherById(long idVoucher) {
		return voucherRepository.findById(idVoucher);
	}
	
	public List<Voucher> findAllVoucher(){
		return voucherRepository.findAll();
	}
}
