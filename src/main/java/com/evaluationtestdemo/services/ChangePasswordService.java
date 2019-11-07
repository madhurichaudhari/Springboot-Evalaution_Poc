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
	 * @param email
	 * @param Password
	 * @param passwordEncoder TODO
	 * @return
	 */
	public int updatepassword( String email, String Password);
	/**
	 * @param email
	 * @param changePasswordstatus
	 * @return 
	 */
	public int updatechangePasswordStatusrById(String email, boolean changePasswordstatus);
	
	/**
	 * @param oldpassword
	 * @param password
	 * @return
	 */
	public boolean getMatchPassword(String oldpassword, String password);

}

