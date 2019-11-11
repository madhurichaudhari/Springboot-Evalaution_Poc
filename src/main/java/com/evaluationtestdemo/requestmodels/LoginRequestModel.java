package com.evaluationtestdemo.requestmodels;

import javax.validation.constraints.NotBlank;



/**
 * @author MadhuriC
 *
 * LoginRequestModel for send request for Login 
 */
public class LoginRequestModel {
	@NotBlank(message = "Email is mandatory")
	private String email;
	private String Password;
	private String isOtpverified;
	private String createdBy;
	/**
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	/**
	 * @return isOtpverified
	 */
	public String getIsOtpverified() {
		return isOtpverified;
	}

	/**
	 * @param isOtpverified
	 */
	public void setIsOtpverified(String isOtpverified) {
		this.isOtpverified = isOtpverified;
	}

	/**
	 * @return Password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
