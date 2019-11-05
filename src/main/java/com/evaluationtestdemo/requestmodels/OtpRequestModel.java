package com.evaluationtestdemo.requestmodels;

import javax.validation.constraints.NotBlank;



/**
 * @author MadhuriC
 *
 * LoginRequestModel for send request for Login 
 */
public class OtpRequestModel {
	@NotBlank(message = "Email is mandatory")
	private String email;
	private String Password;
	private String otp;
	private String createdBy;
	private String isOtpVerified;
	
	/**
	 * @return
	 */
	public String getIs_otp_verified() {
		return isOtpVerified;
	}

	/**
	 * @param is_otp_verified
	 */
	public void setIs_otp_verified(String is_otp_verified) {
		this.isOtpVerified = is_otp_verified;
	}
	/**
	 * @return
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
	 * @return
	 */
	public String getOtp() {
		return otp;
	}

	/**
	 * @param otp
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}



	/**
	 * @return
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
	 * @return
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
