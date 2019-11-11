
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationdemo.validator.UserNotFoundException;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.ILoginService;
import com.evaluationtestdemo.repositories.LoginRepository;

/**
 * @author MadhuriC LoginServiceImpl for implementing response for LoginService
 *
 */
@Service
@Transactional
public class LoginServiceImp implements ILoginService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
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
		return passwordEncoder.matches(password, user.getPassword());
	}

}
