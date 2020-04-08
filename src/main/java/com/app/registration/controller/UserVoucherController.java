package com.app.registration.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.PostRequest;
import com.app.registration.model.UserVoucher;
import com.app.registration.service.UserVoucherService;
import com.app.registration.service.VoucherService;

@RestController
public class UserVoucherController {
	@Autowired
	UserVoucherService userVoucherService;

	@Autowired
	VoucherService voucherService;
	
	private static Logger log = Logger.getLogger(UserVoucherController.class);
	
	@RequestMapping(value = "/userVoucher", method = RequestMethod.POST)
	public List<UserVoucher> userVoucher(@RequestBody PostRequest request){
		try {
			return userVoucherService.findUserVoucherByLoginName(request.getUsername());
		}catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
}
