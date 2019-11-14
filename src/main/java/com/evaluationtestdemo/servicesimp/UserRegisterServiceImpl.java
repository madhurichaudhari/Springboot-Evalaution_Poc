
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.evaluationdemo.exception.NoObjRespnseModel;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.UserRegisterationServiceInter;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * @author MadhuriC UserServiceImpl for implementing response for UserService
 *         declare method for checked User exist or not Checked user data is
 *         saved or not Take input email,mobile
 *
 */
@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterationServiceInter {

	@Autowired
	UserRegisterationRepository userRepository;

	/*** Creating bean of PasswordEncoder */
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<Object> checkUserEmailAndPhone(String mobile, String email, String userType) {
		User user = userRepository.findByMobileOrEmail(mobile, email);
		if (user != null) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.USER_EMAIL_MOBILE_EXIST),
					HttpStatus.OK);
					}
		else {
			return null;
		}
	}

	@Override
	public User addUser(UserRequestModel userRequestModel) {
		userRequestModel.setPassword(passwordEncoder.encode(userRequestModel.getPassword()));
		userRequestModel.setConfirmPassword(passwordEncoder.encode(userRequestModel.getConfirmPassword()));
		try {
			User muser = userRepository.save(new User(userRequestModel));
			return muser;
		} catch (Exception e) {
			return null;

		}

	}
}
