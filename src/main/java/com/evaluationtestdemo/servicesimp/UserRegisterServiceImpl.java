
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationdemo.validator.UserNotFoundException;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.IUserRegisterationService;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.UserRequestModel;



/**
 * @author MadhuriC
 * UserServiceImpl for implementing response for UserService 
 *
 */
@Service
@Transactional
public class UserRegisterServiceImpl implements IUserRegisterationService {

	@Autowired
	UserRegisterationRepository userRepository;
	
	/*** Creating bean of PasswordEncoder */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	

	@Override
	public User checkUserEmailAndPhone(String mobile, String email,String userType) {
		return userRepository.findByMobileOrEmail(mobile, email);
	}
	
	
	@Override
	public User findByUsername(String userName) {
	    return userRepository.findByUserName(userName);
	}
	
	

	@Override
	public User addUser(UserRequestModel userModel) {
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userModel.setConfirmPassword(passwordEncoder.encode(userModel.getConfirmPassword()));
		User muser = userRepository.save(userModel.getUser());
		if(muser!=null && muser.getId()>0) {
		return muser;	
		}
		else {
			new UserNotFoundException(" Data Not Saved");
		}
		return muser;
	}
}
