package com.evaluationtestdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.responsemodels.SignupResponse;
import com.evaluationtestdemo.servicesimp.UserServiceImpl;
import com.evaluationtestdemo.utils.AppConstant;
import com.evaluationtestdemo.utils.EmailUtil;
import com.evaluationtestdemo.utils.MiscUtil;

/**
 * UserRegistrationController for User Login
 *
 */

@RestController
@RequestMapping(path = "/user")
public class UserRegistrationController extends AppConstant {
	
	/*** Creating bean of UserService */
	@Autowired
	UserServiceImpl userService;
	/*** Creating bean of MiscUtil */
	@Autowired
	MiscUtil miscUtil;
	/*** Creating bean of PasswordEncoder */
	@Autowired(required = false)
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmailUtil emailUtil;
	
	 @Autowired
	 private JavaMailSender javaMailSender;

	/**
	 * @param user
	 * @return ResponseEntity
	 */
	@PostMapping("/signup")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody User user) {
		User mUser;
		try {
			mUser = userService.checkUserEmailAndPhone(user.getMobile(), user.getEmail(), user.getCreatedBy());
			if (mUser != null) {
				return new ResponseEntity<Object>(new ResponseModel(false, USER_EMAIL_MOBILE_EXIST, null, 50),
						HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				String otp = String.valueOf(miscUtil.generateOtp(5));
				user.setOtp(otp);
				if (user.getCreatedBy().equalsIgnoreCase("admin")) {
					user.setIs_otp_verified("T");
					user.setChangePasswordStatus("T");
				} else {
					user.setIs_otp_verified("F");
					user.setChangePasswordStatus("F");
                	}
				user.setCreatedBy(user.getCreatedBy());
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userService.addUser(emailUtil,javaMailSender,user,
						new EmailRequestModel(user.getEmail(), VERIFY_OTP_FOR_SIGNUP, "Otp is " + otp));
				return new ResponseEntity<Object>(
						new ResponseModel(true, "Successfully Created", new SignupResponse(user.getFirstName(),
								user.getLast_name(), user.getGender(), user.getEmail(), user.getMobile()), 0),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}}
	}
