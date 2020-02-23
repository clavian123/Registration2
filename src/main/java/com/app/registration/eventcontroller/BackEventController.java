package com.app.registration.eventcontroller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.eventmodel.BackRequest;
import com.app.registration.eventmodel.BackResponse;
import com.app.registration.eventmodel.ConvertReward;
import com.app.registration.model.Status;
import com.app.registration.model.UserVoucher;
import com.app.registration.model.Voucher;
import com.app.registration.repository.StatusRepository;
import com.app.registration.repository.VoucherRepository;
import com.app.registration.service.UserVoucherService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class BackEventController {
	private static Logger log = Logger.getLogger(BackEventController.class);
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	VoucherRepository voucherRepository;
	
	@Autowired
	UserVoucherService userVoucherService;
	
	@RequestMapping("/backsample")
	public BackResponse BackSample(@RequestParam(value = "Validation",
	defaultValue = "Validation") String Validation, String SetOfReward) {
		BackResponse backResponse = new BackResponse();
		backResponse.setValidation(Validation);
		backResponse.setSetOfReward(SetOfReward);
		return backResponse;

	}
	
	@RequestMapping(value = "/backsend", method = RequestMethod.POST)
	public BackResponse Test(@RequestBody BackRequest inputBackPayload) throws IOException {
		BackResponse backResponse = new BackResponse();
		backResponse.setValidation(inputBackPayload.getValidation());
		backResponse.setSetOfReward(inputBackPayload.getSetOfReward());
		backResponse.setExtra("Message");
		
		String json = backResponse.getSetOfReward(); //Menampung SetOfReward(Dalam bentuk Json) kedalam String Json
		log.debug(backResponse.getValidation() + " " + backResponse.getSetOfReward());
		
		if(backResponse.getValidation().equals("isValid")) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			Set<ConvertReward> rewards = new HashSet<>();
			Set<Status> status = this.statusRepository.findByActive();
			Set<Voucher> voucher = this.voucherRepository.findByAll();
			
			try {
				rewards = mapper.readValue(json, new TypeReference<Set<ConvertReward>>(){}); //Convert String json ke ConvertReward
				for(ConvertReward cr : rewards) { //Mencari semua isi data dalam tabel ConvertReward. Supaya bisa ambil nilai/ isinya (Contoh c.getStatus());
					log.debug(cr.getStatus());
					for(Status s : status) { //Mencari isi data di table Status yang memiliki name berisi "Active"
						if(cr.getStatus() == s.getIdStatus()) { //Membandingkan idStatus di ConvertReward sama idStatus di status. Jika sama maka voucher tsb aktif
							log.debug("ACTIVE");
							for(Voucher v : voucher) { //Mencari semua isi data dalam tabel Voucher
								if(cr.getRewardCode().equals(v.getVoucherCode())) { //Jika RewardCode pada ContentReward yang dikirim oleh eventmanager sesuai dengan VoucherCode dari voucher, maka akan bersiap di masukkan dalam user_voucher 
									log.debug("Voucher Code:" + v.getVoucherCode());
									log.debug("Type Voucher:" + v.getType());
									//SET DATA KE DATABASE TABLE USER_VOUCHER
									Calendar cal = Calendar.getInstance(); 
									cal.add(Calendar.MONTH, 1);
									Date dt = cal.getTime();
									UserVoucher userVoucher = new UserVoucher();
									userVoucher.setIdVoucher(v.getIdVoucher());
									userVoucher.setLoginName(inputBackPayload.getLoginName());
									userVoucher.setStatus(v.getStatus());
									userVoucher.setCifCode(inputBackPayload.getCifCode());
									userVoucher.setCreatedDate(new Date());
									userVoucher.setExpiryDate(dt);
									userVoucherService.saveUserVoucher(userVoucher);
									//Yang bisa di dapat dari sini: id_voucher, id_status
								}
							}
						}else { //Membandingkan idStatus di ConvertReward sama idStatus di status. Jika tidak sama maka voucher tsb tidak aktif
							log.debug("INACTIVE");
						}
					}
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}else {
			log.debug("LOGIN/HOMEPAGE"); // Jika getValidation tidak sama dengan isValid maka tidak ada event yang tersedia (Langsung menuju ke Login atau homepage)
		}
		
		return backResponse;
	}

}
