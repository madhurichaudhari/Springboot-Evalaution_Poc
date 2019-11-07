package com.evaluationtestdemo.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

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


	public void sendEmail(JavaMailSender javaMailSender, String email, String subject, String messageWithOtp) {

		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject(subject);
        msg.setText(messageWithOtp);
        javaMailSender.send(msg);
	}
}
