package com.evaluationtestdemo.servicesimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.services.ChangePasswordService;

/*
 *  PasswordServiceImpl for implementing response for PasswordService 
 */

/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public class ChangePasswordServiceImp implements ChangePasswordService {

	@Autowired
	ChangePasswordRepository passwordRepository;
	
	  @Autowired(required=false)
	  PasswordEncoder passwordEncoder;
	  
	  @Autowired(required = false)
		private LoginServiceImp loginService;
	 

	@Override
	public int updatepassword(String  email, String password) {
		User userdata = loginService.findByEmail(email);
		return passwordRepository.UpdateUserById(passwordEncoder.encode(password), userdata.getId());
	}
	@Override
	public void updatechangePasswordStatusrById(String email, String changePasswordstatus) {
		User userdata = loginService.findByEmail(email);
		
		passwordRepository.updateChangePasswordStatusrById(changePasswordstatus,userdata.getId());
		
	}
	
}

