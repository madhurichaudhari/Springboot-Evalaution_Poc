package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationtestdemo.iServices.IOtpService;
import com.evaluationtestdemo.repositories.OtpVerifyRepository;

/*
 *  PasswordServiceImpl for implementing response for PasswordService 
 */

/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public class OtpServiceImp implements IOtpService {
	
	@Autowired
	OtpVerifyRepository otpVerifyRepository;
	
	@Override
	public int otpVerified(boolean isOtpStatus, Long id) {
		int otpVerified= otpVerifyRepository.updateisOtpVerifiedById(isOtpStatus, id);
		return otpVerified;
	}
}

