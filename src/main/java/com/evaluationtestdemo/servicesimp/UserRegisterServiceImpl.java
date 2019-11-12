
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluationdemo.validator.UserNotFoundException;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.IuserRegisterationService;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.UserRequestModel;



/**
 * @author MadhuriC
 * UserServiceImpl for implementing response for UserService
 * declare method for checked User exist or not
 * Checked user data is saved or not 
 * Take input email,mobile
 *
 */
@Service
@Transactional
public class UserRegisterServiceImpl implements IuserRegisterationService {

	@Autowired
	UserRegisterationRepository userRepository;
	
	/*** Creating bean of PasswordEncoder */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	

	@Override
	public User checkUserEmailAndPhone(String mobile, String email,String userType) {		
		  User user = userRepository.findByMobileOrEmail(mobile, email);
			if (user != null) {
				return user;
			} else {
				new UserNotFoundException(" User  Not Found");

			}
			return user;
		
	}
	
	
	@Override
	public User findByUsername(String userName) {
	    User user = userRepository.findByUserName(userName);
		if (user != null) {
			return user;
		} else {
			new UserNotFoundException(" User  Not Found");

		}
		return user;
	    
	}
	
	

	@Override
	public User addUser(UserRequestModel userRequestModel) {
		userRequestModel.setPassword(passwordEncoder.encode(userRequestModel.getPassword()));
		userRequestModel.setConfirmPassword(passwordEncoder.encode(userRequestModel.getConfirmPassword()));
		User muser = userRepository.save(new User(userRequestModel));
		if(muser!=null && muser.getId()>0) {
		return muser;	
		}
		else {
			new UserNotFoundException(" Data Not Saved");
		}
		return muser;
	}
}
