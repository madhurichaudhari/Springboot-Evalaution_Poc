package com.evaluationtestdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesinter.ChangePasswordServiceInter;
import com.evaluationtestdemo.servicesinter.LoginServiceInter;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * * @author MadhuriC
 *  Created ChangePasswordController through User can change Password.
 *  
 */
@RestController
@RequestMapping(path = "/user")
public class ChangePasswordController {
	@Autowired
	private ChangePasswordServiceInter changePasswordService;
	@Autowired
	private LoginServiceInter loginService;

	/**
	 * Using this function User can change the password and take input
	 * ChangePasswordRequestModel type
	 * 
	 * @param changepassword
	 * @return ResponseEntity<Object>
	 */
	@PostMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordRequestModel changepassword) {
		if (changepassword.getNewpassword().equals(changepassword.getConfirmpassword())) {
			User userdata = loginService.fetchByEmail(changepassword.getEmail());

			if (userdata != null) {
				if (changePasswordService.validateMatchPassword(changepassword.getOldpassword(), userdata.getPassword())) {
					if(changepassword.getOldpassword().equalsIgnoreCase(changepassword.getNewpassword())) {
						return new ResponseEntity<Object>(new ResponseModel(false, AppConstant.PWD_OLD_NEW_NOT_SAME, null, 0),
								HttpStatus.INTERNAL_SERVER_ERROR);
						
					}
					
					int passwordStatus = changePasswordService.updatepassword((userdata.getEmail()),
							changepassword.getConfirmpassword());
					if (passwordStatus == 1) {
						userdata.setChangePasswordStatus(true);
						changePasswordService.updatechangePasswordStatusrById(userdata.getEmail(),
								userdata.getChangePasswordStatus());
						
						return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.SUCCESSFULLY_PWD_CHANGED,
								userdata.getEmail(), passwordStatus), HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>(new ResponseModel(true,
								AppConstant.SUCCESSFULLY_PWD_NOT_CHANGED, userdata.getEmail(), passwordStatus),
								HttpStatus.INTERNAL_SERVER_ERROR);
					}
				} else {
					return new ResponseEntity<Object>(new ResponseModel(false, AppConstant.PWD_MATCHED_FAILED, null, 0),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new ResponseModel(false, AppConstant.USER_NOT_EXIST, null, 0),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Object>(
					new ResponseModel(false, AppConstant.RECONFIRM_PWD_MATCHED_FAILED, null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
