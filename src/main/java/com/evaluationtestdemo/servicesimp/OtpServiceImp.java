package com.evaluationtestdemo.servicesimp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationtestdemo.repositories.OtpVerifyRepository;
import com.evaluationtestdemo.services.OtpService;

/*
 *  PasswordServiceImpl for implementing response for PasswordService 
 */

/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public class OtpServiceImp implements OtpService {
	
	@Override
	public int otpVerified(OtpVerifyRepository otpVerifyRepository,String isOtpStatus, Long id) {
		int otpVerified= otpVerifyRepository.updateisOtpVerifiedById(isOtpStatus, id);
		return otpVerified;
	}
}

