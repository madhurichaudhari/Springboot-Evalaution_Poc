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
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * @author MadhuriC
 *  UesrController for User can  Login and extending AppConstant for declare Message related response
 *
 */
@RestController
@RequestMapping(path = "/user")
public class LoginController extends AppConstant {

	/*** Creating bean of LoginService */
	@Autowired
	private LoginServiceImp loginService;

	/***
	 * Call login function for User existence * @param loginRequest @return
	 * @param loginRequest 
	 * @return ResponseEntity
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestModel loginRequest) {
			if (loginService.validateUserEmail(loginRequest.getEmail())) {
				if (!loginRequest.getPassword().equalsIgnoreCase("")
						&& loginService.validateUserPassword(loginRequest.getPassword(), loginRequest.getEmail())) {
					if (loginService.validateUserOtpVerified(loginRequest.getEmail(), loginRequest.getPassword())) {
						User user = loginService.findByEmail(loginRequest.getEmail());
						if (user.getChangePasswordStatus()) {
							return new ResponseEntity<Object>(
									new ResponseModel(true, USER_LOGIN_SUCCESS, loginRequest.getEmail(), 0),
									HttpStatus.OK);
						}
                   else {

							return new ResponseEntity<Object>(
									new ResponseModel(true, USER_FIRST_TIME, loginRequest.getEmail(), 0),
									HttpStatus.OK);
						}
					}
					else {
						return new ResponseEntity<Object>(
								new ResponseModel(false, USER_OTP_NOT_VERIFIED, loginRequest, 0),
								// HttpStatus.OK);
								HttpStatus.OK);
						}
				}

				else {
					return new ResponseEntity<Object>(
							new ResponseModel(false, PASSWORD_DOES_NOT_EXIST, loginRequest, 0), HttpStatus.OK);
				}
			}
			else {
				return new ResponseEntity<Object>(new ResponseModel(false, EMAIL_DOES_NOT_EXIST, loginRequest, 0),
						HttpStatus.OK);
			}

		
	}
}
