package com.evaluationtestdemo.iServices;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.UserRequestModel;



/**
 * @author MadhuriC
 * Created function for user registration
 * checked email and mobile is exist or not
 */
@Service
@Transactional
public interface UserRegisterationServiceInter  {
	/**
	
	 * @param userModel
	 * @return User
	 */
	public User addUser(UserRequestModel userModel);
	/**
	 * @param mobile
	 * @param email
	 * @param userType 
	 * @return User
	 */
	public ResponseEntity<Object> checkUserEmailAndPhone(String mobile, String email, String userType);
	/**
	 * @param firstName
	 * @return User
	 */
	

}
