package com.evaluationtestdemo.services;

import com.evaluationtestdemo.entities.User;


/**
 * @author MadhuriC
 *
 */
public interface LoginService {
	/**
	 * @param emailAddress
	 * @param password
	 * @param isOtpVerified
	 * @return
	 */
	public boolean validateUserOtpVerified(String emailAddress, String password);
	/**
	 * @param emailAddress
	 * @return
	 */
	public boolean validateUserEmail(String emailAddress);
	/**
	 * @param password
	 * @param email
	 * @return
	 */
	public boolean validateUserPassword(String password,String email);

	/**
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	/**
	 * @param email
	 * @param password
	 * @param is_otp_verified
	 * @return
	 */
	User findByEmailandPassword(String email, String password,String is_otp_verified);
	
	
	
	
}

