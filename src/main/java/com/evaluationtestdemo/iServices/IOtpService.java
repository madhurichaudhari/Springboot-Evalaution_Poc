package com.evaluationtestdemo.iServices;

/**
 * @author MadhuriC
 *
 */
public interface IOtpService {

	/**
	 * @param isOtpStatus
	 * @param id
	 * @return
	 */
	public int otpVerified(boolean isOtpStatus,Long id);
	
}

