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
import com.evaluationtestdemo.iServices.IloginService;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * @author MadhuriC
 *  LoginController for User can Login and
 *   extending AppConstant for declare Message related response
 */
@RestController
@RequestMapping(path = "/user")
public class LoginController extends AppConstant {

	/*** Creating bean of LoginService */
	@Autowired
	private IloginService iloginService;

	/***
	 * Using this function User can Login and take input LoginRequestModel type
	 * 
	 * @param loginRequest
	 * @return ResponseEntity
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestModel loginRequest) {
		if (iloginService.validateUserEmail(loginRequest.getEmail())) {
			if (iloginService.validateUserPassword(loginRequest.getPassword(), loginRequest.getEmail())) {
				User user = iloginService.findByEmail(loginRequest.getEmail());
				if (user.getChangePasswordStatus()) {
					return new ResponseEntity<Object>(
							new ResponseModel(true, USER_LOGIN_SUCCESS, loginRequest.getEmail(), 0), HttpStatus.OK);
				} else {

					return new ResponseEntity<Object>(
							new ResponseModel(true, USER_FIRST_TIME, loginRequest.getEmail(), 0), HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<Object>(new ResponseModel(false, PASSWORD_DOES_NOT_EXIST, loginRequest, 0),
						// HttpStatus.OK);
						HttpStatus.OK);
			}

		} else {
			return new ResponseEntity<Object>(new ResponseModel(false, EMAIL_DOES_NOT_EXIST, loginRequest, 0),
					HttpStatus.OK);
		}

	}
}
