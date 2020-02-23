package com.app.registration.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.DataRegistrationGlobalVar;
import com.app.registration.model.TempRegis;
import com.app.registration.model.PostRequest;
import com.app.registration.service.TempRegisService;

@RestController
public class TempRegisController {
	
	private static Logger log = Logger.getLogger(TempRegisController.class);
	
	public static boolean compareDates(Date date1,Date date2){
        if(date1.after(date2)){
            return false;
        }else if(date1.before(date2)){
           	return true;
        }else if(date1.equals(date2)){
            return true;
        }
        return true;
    }
	
	@Autowired
	TempRegisService tempRegisService;
	
	@RequestMapping(value = "/checkToken", method = RequestMethod.POST)
	public boolean checkToken(@RequestBody PostRequest request) {
		List<TempRegis> list = tempRegisService.getTempRegisByCif(request.getCif_code());
		TempRegis data = list.get(list.size()-1);
		Date now = new Date();
		
		if(data.getToken().equals(request.getToken())) {
			if(compareDates(now, data.getExpiredDate())) {
				DataRegistrationGlobalVar.dataRegis = data.getDataRegistration();
				return true;
			}
		}else {
			return false;
		}	
		
		return false;
	}
}
