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
import com.evaluationtestdemo.servicesinter.LoginServiceInter;
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
	private LoginServiceInter loginServiceInter;

	/***
	 * Using this function User can Login and take input LoginRequestModel type
	 * 
	 * @param loginRequestModel
	 * @return ResponseEntity
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestModel loginRequestModel) {
		if (loginServiceInter.validateUserEmail(loginRequestModel.getEmail())) {
			if (loginServiceInter.validateUserPassword(loginRequestModel.getPassword(), loginRequestModel.getEmail())) {
				User user = loginServiceInter.fetchByEmail(loginRequestModel.getEmail());
				if (user.getChangePasswordStatus()) {
					return new ResponseEntity<Object>(
							new ResponseModel(true, USER_LOGIN_SUCCESS, loginRequestModel.getEmail(), 0), HttpStatus.OK);
				} else {

					return new ResponseEntity<Object>(
							new ResponseModel(true, USER_FIRST_TIME, loginRequestModel.getEmail(), 0), HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new ResponseModel(false, PASSWORD_DOES_NOT_EXIST, loginRequestModel, 0),
						// HttpStatus.OK);
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {
			return new ResponseEntity<Object>(new ResponseModel(false, EMAIL_DOES_NOT_EXIST, loginRequestModel, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
