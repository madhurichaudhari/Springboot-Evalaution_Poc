package com.evaluationtestdemo.services;
import javax.transaction.Transactional;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;
import com.evaluationtestdemo.utils.EmailUtil;



/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public interface UserRegisterationService {
	/**
	 * @param emailUtil 
	 * @param javaMailSender 
	 * @param user
	 * @param email
	 * @return User
	 */
	public User addUser(EmailUtil emailUtil, JavaMailSender javaMailSender,User user, EmailRequestModel email);
	/**
	 * @param mobile
	 * @param email
	 * @param userType 
	 * @return User
	 */
	public User checkUserEmailAndPhone(String mobile, String email, String userType);
}
