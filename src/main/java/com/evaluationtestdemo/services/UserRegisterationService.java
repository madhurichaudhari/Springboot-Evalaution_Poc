package com.evaluationtestdemo.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;



/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public interface UserRegisterationService {
	/**
	 * @param user
	 * @param email
	 * @return User
	 */
	public User addUser(User user, EmailRequestModel email);
	/**
	 * @param mobile
	 * @param email
	 * @param userType 
	 * @return User
	 */
	public User checkUserEmailAndPhone(String mobile, String email, String userType);
}
