
package com.evaluationtestdemo.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;
import com.evaluationtestdemo.services.UserRegisterationService;
import com.evaluationtestdemo.utils.EmailUtil;



/**
 * @author MadhuriC
 * UserServiceImpl for implementing response for UserService 
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserRegisterationService {

	@Autowired
	UserRegisterationRepository repository;

	

	@Override
	public User addUser(EmailUtil emailUtil,JavaMailSender javaMailSender,User user, EmailRequestModel emailRequestModel) {
		emailUtil.sendEmail(javaMailSender,emailRequestModel);
		User muser = repository.save(user);

		return muser;
	}

	@Override
	public User checkUserEmailAndPhone(String mobile, String email,String userType) {
		return repository.findByMobileOrEmail(mobile, email);
	}


}
