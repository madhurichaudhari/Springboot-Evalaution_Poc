
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.services.UserRegisterationService;
import com.evaluationtestdemo.utils.EmailUtil;
import com.evaluationtestdemo.utils.MiscUtil;



/**
 * @author MadhuriC
 * UserServiceImpl for implementing response for UserService 
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserRegisterationService {

	@Autowired
	UserRegisterationRepository userRepo;
	
	/*** Creating bean of MiscUtil */
	@Autowired
	MiscUtil miscUtil;
	/*** Creating bean of PasswordEncoder */
	@Autowired
	PasswordEncoder passwordEncoder;
	


	

	@Override
	public User addUser(UserModel userModel) {
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		User muser = userRepo.save(userModel.getUser());
		if(muser!=null && muser.getId()>0) {
		return muser;	
		}
		else {
			return null;
		}
	
	}

	@Override
	public User checkUserEmailAndPhone(String mobile, String email,String userType) {
		return userRepo.findByMobileOrEmail(mobile, email);
	}

	@Override
	public String createRandomOtp() {
		return String.valueOf(miscUtil.generateOtp(5));
	}


}
