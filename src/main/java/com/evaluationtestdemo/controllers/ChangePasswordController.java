package com.evaluationtestdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.responsemodels.ResponseModel;
import com.evaluationtestdemo.servicesimp.ChangePasswordServiceImp;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;
import com.evaluationtestdemo.utils.AppConstant;



/**
 * @author MadhuriC
 *
 */
@RestController
@RequestMapping(path = "/user")
public class ChangePasswordController {
	
	/*** Creating bean of PasswordService */
	@Autowired
	ChangePasswordServiceImp passwordService;
	/*** Creating bean of PasswordRepository */
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired(required = false)
	private LoginServiceImp loginService;
	
	/**
	 * @param changepassword
	 * @return
	 */
	@PostMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordRequestModel changepassword) {
		if (changepassword.getNewpassword().equals(changepassword.getConfirmpassword())) {
			User userdata = loginService.findByEmail(changepassword.getEmail());
			if (userdata != null) {
				if (passwordEncoder.matches(changepassword.getOldpassword(), userdata.getPassword())) {
					int resp = passwordService.updatepassword((userdata.getEmail()),
							changepassword.getConfirmpassword());
					userdata.setChangePasswordStatus("T");
				
					passwordService.updatechangePasswordStatusrById(userdata.getEmail(),userdata.getChangePasswordStatus() );
					return new ResponseEntity<Object>(
							new ResponseModel(true, AppConstant.SUCCESSFULLY_PWD_CHANGED, userdata.getEmail(), resp), HttpStatus.OK);
				} 
				else {
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
