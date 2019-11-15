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
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesinter.UserRegisterationServiceInter;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * * @author MadhuriC
 *  Created UserRegisterController through User can register.
 * and extending AppConstant for declare Message related response
 *
 */

@RestController
@RequestMapping(path = "/user")
public class UserRegisterController extends AppConstant {

	/*** Creating bean of userRegisterService */
	@Autowired(required = false)
	UserRegisterationServiceInter userRegisterService;
	
	

	/**
	 * Using this function User can register and
	 *  take input UserRequestModel type
	 * @param userRequestModel
	 * @return ResponseEntity
	 */
	@PostMapping("/signUp")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRequestModel userRequestModel) {
		User mUser=null;
		if(userRegisterService.validateUserEmailAndPhone(userRequestModel.getMobile(), userRequestModel.getEmail(),
				userRequestModel.getCreatedBy())==null) {
			boolean isAdmin = userRequestModel.getCreatedBy().equalsIgnoreCase("admin@hcl.com");
			
			if (isAdmin) {
				mUser = userRegisterService.addUser(userRequestModel);
			} else if (!isAdmin) {
				mUser = userRegisterService.addUser(userRequestModel);
			}
			return new ResponseEntity<Object>(new ResponseModel(true, SUCCESS,mUser, 0),
					HttpStatus.CREATED);
		}
		else {
			return userRegisterService.validateUserEmailAndPhone(userRequestModel.getMobile(), userRequestModel.getEmail(),
					userRequestModel.getCreatedBy());
		}
		
		
	}
}
