
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationdemo.exception.UserNotFoundException;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.servicesinter.LoginServiceInter;

/**
 * @author MadhuriC 
 * LoginServiceImpl for implementing response for LoginService
 * declare method for checked User exist or not
 * Checked user exist or not
 *
 */
@Service
@Transactional
public class LoginServiceImp implements LoginServiceInter {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public boolean validateUserEmail(String email) {
		boolean emailStatus = false;
		emailStatus = loginRepository.existsByEmail(email);
		if (emailStatus) {
			emailStatus =true;
		} else {
			throw new UserNotFoundException(" User Not Found");
		}
		return emailStatus;
		}


	@Override
	public User fetchByEmail(String email) {
		User user = loginRepository.findByEmail(email);
		if (user != null) {
			return user;
		}
		 else {
			throw new  UserNotFoundException(" User Not Found");
		 }

	}

	@Override
	public boolean validateUserPassword(String password, String email) {
		User user = loginRepository.findByEmail(email);
		boolean passwordStatus = false;
		if (user != null) {
			passwordStatus = passwordEncoder.matches(password, user.getPassword());

		} else {
			throw new UserNotFoundException(" User Not Found");
		}
		return passwordStatus;
	}
}
