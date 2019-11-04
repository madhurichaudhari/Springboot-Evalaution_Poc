package com.evaluationtestdemo.requestmodels;

/**
 * @author MadhuriC
 * 
 *         ChangePasswordRequestModel for change Password
 *
 */
public class ChangePasswordRequestModel {

	private String Userid;
	private String oldpassword;
	private String newpassword;
	private String confirmpassword;
	private String email;
	private String changePasswordStatus;

	public String getChangePasswordStatus() {
		return changePasswordStatus;
	}

	public void setChangePasswordStatus(String changePasswordStatus) {
		this.changePasswordStatus = changePasswordStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserid() {
		return Userid;
	}

	/**
	 * @param userid
	 */
	public void setUserid(String userid) {
		Userid = userid;
	}

	/**
	 * @return
	 */
	public String getOldpassword() {
		return oldpassword;
	}

	/**
	 * @param oldpassword
	 */
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	/**
	 * @return
	 */
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	/**
	 * @return
	 */
	public String getConfirmpassword() {
		return confirmpassword;
	}

	/**
	 * @param confirmpassword
	 */
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}



}
