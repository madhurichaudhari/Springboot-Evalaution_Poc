
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.services.LoginService;

/**
 * @author MadhuriC LoginServiceImpl for implementing response for LoginService
 *
 */
@Service
@Transactional
public class LoginServiceImp implements LoginService {

	@Autowired(required = false)
	private LoginRepository loginRepository;
	

	
	
	@Autowired(required = false)
	PasswordEncoder passwordEncoder;

	@Override
	public boolean validateUserEmail(String emailAddress) {
		return loginRepository.existsByEmail(emailAddress);

	}

	@Override
	public User findByEmailandPassword(String email, String password, String is_otp_verified) {
		return null;
	}

	@Override
	public User findByEmail(String email) {
		return loginRepository.findByEmail(email);
	}

	@Override
	public boolean validateUserPassword(String password, String email) {
		User user = loginRepository.findByEmail(email);
		return passwordEncoder.matches(password, user.getPassword());
	}

	@Override
	public boolean validateUserOtpVerified(String emailAddress, String password) {
		User user = loginRepository.findByEmail(emailAddress);
		boolean otpStatus = user.getIs_otp_verified().equalsIgnoreCase("T") ? true : false;
		return otpStatus;
	}



}
