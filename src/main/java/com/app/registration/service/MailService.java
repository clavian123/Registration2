package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.registration.model.AllCustomersData;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(AllCustomersData dummy, String random) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(dummy.getEmail());
		mail.setSubject("EventManager Verification Code");
		mail.setText("Here is your verification code: " + random);
		
		javaMailSender.send(mail);
	}
}
