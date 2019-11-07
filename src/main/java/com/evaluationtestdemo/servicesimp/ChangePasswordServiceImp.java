package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
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
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private LoginRepository loginRepo;

	@Override
	public int updatepassword(String email, String password) {
		User userdata = loginRepo.findByEmail(email);
		return passwordRepository.UpdateUserById(passwordEncoder.encode(password), userdata.getId());
	}

	@Override
	public int updatechangePasswordStatusrById(String email, boolean changePasswordstatus) {
		User userdata = loginRepo.findByEmail(email);
		return passwordRepository.updateChangePasswordStatusrById(changePasswordstatus, userdata.getId());

	}

	@Override
	public boolean getMatchPassword(String oldpassword, String password) {
		boolean passwordStatus=passwordEncoder.matches(oldpassword, password);
		return passwordStatus;
	}

}
