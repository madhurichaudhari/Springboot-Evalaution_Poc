package com.evaluationtestdemo.iServices;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.servicesimp.UserModel;



/**
 * @author MadhuriC
 *
 */
@Service
@Transactional
public interface IUserRegisterationService {
	/**
	
	 * @param userModel
	 * @return User
	 */
	public User addUser(UserModel userModel);
	/**
	 * @param mobile
	 * @param email
	 * @param userType 
	 * @return User
	 */
	public User checkUserEmailAndPhone(String mobile, String email, String userType);
	
	/**
	 * @return
	 */
	public String createRandomOtp();
}
