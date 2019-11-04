package com.evaluationtestdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.evaluationtestdemo.requestmodels.EmailRequestModel;

@Component
public class EmailUtil {
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	

	 
	 
	public void sendEmail(EmailRequestModel emailRequestModel) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(emailRequestModel.getEmail_to());

	        msg.setSubject(emailRequestModel.getSubject());
	        msg.setText(emailRequestModel.getMessage());

	        javaMailSender.send(msg);

	    }
	
	
	 
	 
}
