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
	private String otp;
	private String createdBy;
	/**
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getIsOtpverified() {
		return isOtpverified;
	}

	public void setIsOtpverified(String isOtpverified) {
		this.isOtpverified = isOtpverified;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
