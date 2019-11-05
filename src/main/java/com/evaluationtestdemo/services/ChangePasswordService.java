package com.evaluationtestdemo.services;

import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *  for creating PasswordService for 
 */

/**
 * @author MadhuriC
 *
 */
public interface ChangePasswordService {

	/**
	 * @param email
	 * @param Password
	 * @param passwordEncoder TODO
	 * @return
	 */
	public int updatepassword( String email, String Password, PasswordEncoder passwordEncoder);
	/**
	 * @param email
	 * @param changePasswordstatus
	 */
	public int updatechangePasswordStatusrById(String email, String changePasswordstatus);
	
	

}