package com.evaluationtestdemo.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;

/**
 * @author MadhuriC
 *
 */
@Component
public class EmailUtil {
	/**
	 * @param javaMailSender 
	 * @param emailRequestModel
	 */
	public void sendEmail(JavaMailSender javaMailSender,EmailRequestModel emailRequestModel) {
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(emailRequestModel.getEmail_to());
	        msg.setSubject(emailRequestModel.getSubject());
	        msg.setText(emailRequestModel.getMessage());
	        javaMailSender.send(msg);
	    }
}
