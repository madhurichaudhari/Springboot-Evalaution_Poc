package com.evaluationtestdemo.services;

import com.evaluationtestdemo.repositories.OtpVerifyRepository;

/**
 * @author MadhuriC
 *
 */
public interface OtpService {

	/**
	 * @param otpVerifyRepository 
	 * @param isOtpStatus
	 * @param id
	 * @return
	 */
	public int otpVerified(OtpVerifyRepository otpVerifyRepository,String isOtpStatus,Long id);
	
}

