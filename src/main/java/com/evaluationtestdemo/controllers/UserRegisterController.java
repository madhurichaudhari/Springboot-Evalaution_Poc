package com.evaluationtestdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.responsemodels.SignupResponse;
import com.evaluationtestdemo.services.UserRegisterationService;
import com.evaluationtestdemo.servicesimp.UserModel;
import com.evaluationtestdemo.utils.AppConstant;
import com.evaluationtestdemo.utils.EmailUtil;

/**
 * UserRegistrationController for User Login
 *
 */

@RestController
@RequestMapping(path = "/user")
public class UserRegisterController extends AppConstant {
	
	/*** Creating bean of UserService */
	@Autowired
	UserRegisterationService userService;
	@Autowired
	EmailUtil emailUtil;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	

	/**
	 * @param userModel
	 * @return ResponseEntity
	 */
	@PostMapping("/signup")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserModel userModel) {
		
		try {
			User mUser = userService.checkUserEmailAndPhone(userModel.getMobile(), userModel.getEmail(), userModel.getCreatedBy());
			if (mUser != null) {
				return new ResponseEntity<Object>(new ResponseModel(false, USER_EMAIL_MOBILE_EXIST, null, 50),
						HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				String otp =userService.createRandomOtp();
				userModel.setOtp(otp);
				if (userModel.getCreatedBy().equalsIgnoreCase("admin")) {
					userModel.setOtpVerifiedStatus(true);
					userModel.setChangePasswordStatus(true);
				} else {
					userModel.setOtpVerifiedStatus(false);
					userModel.setChangePasswordStatus(false);
                	}
				User user= userService.addUser(userModel);
				if(user!=null && user.getId()>0) {
					emailUtil.sendEmail(javaMailSender,userModel.getEmail(), VERIFY_OTP_FOR_SIGNUP, "Otp is " + otp);
					return new ResponseEntity<Object>(
							new ResponseModel(true, SUCCESS, new SignupResponse(user.getFirstName(),
									user.getLast_name(), user.getGender(), user.getEmail(), user.getMobile()), 0),
							HttpStatus.CREATED);
				}
				else {
					
					return new ResponseEntity<Object>(
							new ResponseModel(true, FAIL, null, 0),
							HttpStatus.CREATED);
				}
				
			}

		} catch (Exception e) {
			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}}
	}
