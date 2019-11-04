package com.evaluationtestdemo.requestmodels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/*
 *  PasswordRequest for send request for Password 
 */


/**
 * @author MadhuriC
 *  PasswordRequest for send request for Password 
 *
 */
public class PasswordRequest {

	@Email(message = "{Email should be valid.}")
	@NotBlank(message = "Email is mandatory.")
	private String email;

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
