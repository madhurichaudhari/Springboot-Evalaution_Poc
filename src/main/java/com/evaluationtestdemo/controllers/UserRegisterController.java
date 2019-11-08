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
import com.evaluationtestdemo.iServices.IUserRegisterationService;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesimp.UserModel;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * UserRegistrationController for User can  Register and extending AppConstant for declare Message related response
 *
 */

@RestController
@RequestMapping(path = "/user")
public class UserRegisterController extends AppConstant {
	
	/*** Creating bean of userRegisterService */
	@Autowired(required=false)
	IUserRegisterationService userRegisterService;
	/*
	 * @Autowired EmailUtil emailUtil;
	 * 
	 * @Autowired private JavaMailSender javaMailSender;
	 */
	

	/**
	 * @param userModel
	 * @return ResponseEntity
	 */
	@PostMapping("/signup")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserModel userModel) {
				User mUser = userRegisterService.checkUserEmailAndPhone(userModel.getMobile(), userModel.getEmail(), userModel.getCreatedBy());
				if (mUser != null) {
					return new ResponseEntity<Object>(new ResponseModel(false, USER_EMAIL_MOBILE_EXIST, null, 50),
							HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
				boolean isAdmin = userModel.getCreatedBy().equalsIgnoreCase("admin");
					User user;
					if (isAdmin) {
						user= userRegisterService.addUser(userModel);
					} else if(!isAdmin) {
						user= userRegisterService.addUser(userModel);
	                }
						return new ResponseEntity<Object>(
								new ResponseModel(true, FAIL, null, 0),
								HttpStatus.CREATED);
				}
				}
	}
	
