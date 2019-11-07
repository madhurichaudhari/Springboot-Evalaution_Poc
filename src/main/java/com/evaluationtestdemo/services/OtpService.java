package com.evaluationtestdemo.services;

/**
 * @author MadhuriC
 *
 */
public interface OtpService {

	/**
	 * @param isOtpStatus
	 * @param id
	 * @return
	 */
	public int otpVerified(boolean isOtpStatus,Long id);
	
}

