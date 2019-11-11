package com.evaluationtestdemo.iServices;

import com.evaluationtestdemo.entities.User;


/**
 * @author MadhuriC
 *
 */
public interface ILoginService {
	/**
	 * @param emailAddress
	 * @param password
	 * @param isOtpVerified
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
	 * @return User
	 */
	User findByEmailandPassword(String email, String password,String is_otp_verified);
	
	
	
	
}

