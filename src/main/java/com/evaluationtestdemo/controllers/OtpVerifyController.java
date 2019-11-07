package com.evaluationtestdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.OtpRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;
import com.evaluationtestdemo.servicesimp.OtpServiceImp;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * @author MadhuriC
 *
 */
@RestController
@RequestMapping(path = "/user")
public class OtpVerifyController  extends AppConstant{
	
	/*** Creating bean of LoginServiceImpl */
	
	@Autowired
	private OtpServiceImp otpService;
	
	/*** Creating bean of LoginService */
	@Autowired
	private LoginServiceImp loginService;
	
	
	
	/**
	 * @param otpRequestModel 
	 * @return ResponseEntity
	 */
	@PostMapping("/otpVerify")
	public ResponseEntity<Object> verifyOtp(@Valid @RequestBody OtpRequestModel otpRequestModel) {
		try {
			User otpDetails = loginService.findByEmail(otpRequestModel.getEmail());
			if (otpDetails.getOtp().equalsIgnoreCase(otpRequestModel.getOtp())) {
				otpDetails.setOtpVerifiedStatus(true);
		        otpService.otpVerified(true, otpDetails.getId());
				return new ResponseEntity<Object>(new ResponseModel(true, OTP_VERIFIED, otpDetails.getEmail(), 0),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new ResponseModel(false, OTP_WRONG, null, 0), HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
