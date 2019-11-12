package com.evaluationtestdemo.iServices;

/*
 *  for creating PasswordService for 
 */

/**
 * @author MadhuriC
 * IchangePasswordService for ChangePasswordServiceImp
 * declare function for update password 
 *Take input email,changePasswordstatus,old password,password
 */
public interface IchangePasswordService {

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
	 * @return 0/1 if password will be update
	 */
	public int updatechangePasswordStatusrById(String email, boolean changePasswordstatus);
	
	/**
	 * @param oldpassword
	 * @param password
	 * @return true OR  false if password will be match
	 */
	public boolean getMatchPassword(String oldpassword, String password);

}

