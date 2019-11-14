package com.evaluationtestdemo.iServices;

import com.evaluationtestdemo.entities.User;


/**
 * @author MadhuriC
 *  Created function for user Login
 * checked email and mobile is exist or not
 *
 */
public interface LoginServiceInter {
	/**
	 * @param emailAddress
	 * @param isOtpVerified
	 * @return
	 */

	public boolean validateUserEmail(String emailAddress);
	/**
	 * @param password
	 * @param email
	 * @return password status
	 */
	public boolean validateUserPassword(String password,String email);

	/**
	 * @param email
	 * @return User
	 */
	public User findByEmail(String email);
	
}

