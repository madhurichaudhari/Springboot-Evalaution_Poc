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
import com.evaluationtestdemo.iServices.IuserRegisterationService;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
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
	IuserRegisterationService iUserRegisterService;
	
	

	/**
	 * Using this function User can register and
	 *  take input UserRequestModel type
	 * @param userModel
	 * @return ResponseEntity
	 */
	@PostMapping("/signUp")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRequestModel userModel) {
		User mUser = iUserRegisterService.checkUserEmailAndPhone(userModel.getMobile(), userModel.getEmail(),
				userModel.getCreatedBy());
		if (mUser != null) {
			return new ResponseEntity<Object>(new ResponseModel(false, USER_EMAIL_MOBILE_EXIST, null, 50),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			boolean isAdmin = userModel.getCreatedBy().equalsIgnoreCase("admin");
			User user = null;
			if (isAdmin) {
				user = iUserRegisterService.addUser(userModel);
			} else if (!isAdmin) {
				user = iUserRegisterService.addUser(userModel);
			}
			return new ResponseEntity<Object>(new ResponseModel(true, SUCCESS,user , 0),
					HttpStatus.CREATED);
		}
	}
}
