package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.TempRegis;
import com.app.registration.repository.TempRegisRepository;

@Service
public class TempRegisService {

	@Autowired
	private TempRegisRepository tempRegisRepository;
	
	public List<TempRegis> getTempRegisByCif(String cifCode){
		return tempRegisRepository.findByCifCode(cifCode);
	}
	
	public TempRegis saveTempRegis(TempRegis tempRegis) {
		return tempRegisRepository.save(tempRegis);
	}
	
}
