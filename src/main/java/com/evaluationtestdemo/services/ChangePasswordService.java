package com.evaluationtestdemo.services;

/*
 *  for creating PasswordService for 
 */

/**
 * @author MadhuriC
 *
 */
public interface ChangePasswordService {

	/**
	 * @param userid
	 * @param Password
	 * @return
	 */
	public int updatepassword(String email, String Password);
	/**
	 * @param userid
	 * @param changePasswordstatus
	 */
	public void updatechangePasswordStatusrById(String email, String changePasswordstatus);
	
	

}