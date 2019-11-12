
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationdemo.validator.UserNotFoundException;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.IloginService;
import com.evaluationtestdemo.repositories.LoginRepository;

/**
 * @author MadhuriC 
 * LoginServiceImpl for implementing response for LoginService
 * declare method for checked User exist or not
 * Checked user exist or not
 *
 */
@Service
@Transactional
public class LoginServiceImp implements IloginService {

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
			new UserNotFoundException(" User  Not Found");
		}
		return emailStatus;
		}


	@Override
	public User findByEmail(String email) {
		User user = loginRepository.findByEmail(email);
		if (user != null) {
			return user;
		} else {
			new UserNotFoundException(" User  Not Saved");

		}
		return user;
	}

	@Override
	public boolean validateUserPassword(String password, String email) {
		User user = loginRepository.findByEmail(email);
		boolean passwordStatus = false;
		if (user != null) {
			passwordStatus = passwordEncoder.matches(password, user.getPassword());

		} else {
			new UserNotFoundException(" User  Not Found");
		}
		return passwordStatus;
	}
}
