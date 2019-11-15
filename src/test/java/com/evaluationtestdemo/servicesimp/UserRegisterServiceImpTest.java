package com.evaluationtestdemo.servicesimp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.evaluationdemo.exception.NoObjRespnseModel;
import com.evaluationtestdemo.EvaluationTestDemoApplication;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.servicesimp.UserRegisterServiceImp;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * @author MadhuriC
 *
 */
@SpringBootTest(classes = EvaluationTestDemoApplication.class)
public class UserRegisterServiceImpTest {
	@Mock
	UserRegisterationRepository userRepository;

	@InjectMocks
	UserRegisterServiceImp userServiceImp;

	@Mock
	PasswordEncoder passwordEncoder;

	/**
	 * Initialize Mocked
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * test user Registration
	 */

	@Test
	public void testUserRegisterForAddUserWhenSuccess() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		userRequestModel.setId(1);
		userRequestModel.setPassword("madhuri");
		userRequestModel.setConfirmPassword("madhuri");
		userRequestModel.setMobile("1234567897");
		userRequestModel.setUserName("madhuri");
		userRequestModel.setChangePasswordStatus(true);
		// TODO: We can switch createdBy accordignly user/admin
		userRequestModel.setCreatedBy("admin");
		userRequestModel.setGender("female");
		User user = new User(userRequestModel);
		userRequestModel.setId(1);
		user.setEmail("admin@gmail.com");
		user.setPassword("madhuri");
		user.setConfirmPassword("madhuri");
		user.setChangePasswordStatus(true);
		user.setCreatedBy("admin");
		user.setGender("female");
		Mockito.when(passwordEncoder.encode(userRequestModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(passwordEncoder.encode(userRequestModel.getConfirmPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(new User(userRequestModel))).thenReturn(user);
		User userDeatils = userServiceImp.addUser(userRequestModel);
		assertEquals("madhuri", userDeatils.getUserName());
		
		
	}

	/**
	 * test user Registration
	 */

	@Test
	public void testUserRegisterForAddUserWhenFail() {
		UserRequestModel userModel = new UserRequestModel();
		userModel.setEmail("chaudharimadhuri905@gmail.com");
		userModel.setPassword("madhuri");
		userModel.setMobile("1234567897");
		userModel.setUserName("madhuri");
		userModel.setChangePasswordStatus(false);
		// TODO: We can switch createdBy accordignly user/admin
		userModel.setCreatedBy("admin");
		userModel.setGender("female");
		Mockito.when(passwordEncoder.encode(userModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(new User(userModel))).thenReturn(null);
		User userResult = userServiceImp.addUser(userModel);
		assertEquals(null, userResult);
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testUserRegisterForValidateUserEmailAndPhoneWhenSuccess() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("chaudharimadhuri905@gmail.com");
		userRequestModel.setId(1);
		userRequestModel.setPassword("madhuri");
		userRequestModel.setMobile("1234567897");
		userRequestModel.setUserName("madhuri");
		userRequestModel.setChangePasswordStatus(false);
		// TODO: We can switch createdBy accordignly user/admin
		userRequestModel.setCreatedBy("admin");
		userRequestModel.setGender("female");
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(true);	
		
		
		ResponseEntity<Object> responseEntity= 	new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.USER_EMAIL_MOBILE_EXIST),
				HttpStatus.OK);
		
		Mockito.when(passwordEncoder.encode(userRequestModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userResult = userServiceImp.addUser(userRequestModel);
		assertEquals("madhuri", userResult.getUserName());
	}

	/**
	 * 
	 */
	@Test
	public void testUserRegisterForValidateUserEmailAndPhoneWhenFail() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("chaudharimadhuri905@gmail.com");
		userRequestModel.setId(1);
		userRequestModel.setPassword("madhuri");
		userRequestModel.setMobile("1234567897");
		userRequestModel.setUserName("madhuri");
		userRequestModel.setChangePasswordStatus(false);
		// TODO: We can switch createdBy accordignly user/admin
		userRequestModel.setCreatedBy("admin");
		userRequestModel.setGender("female");
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(true);	
		Mockito.when(passwordEncoder.encode(userRequestModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userResult = userServiceImp.addUser(userRequestModel);
		assertEquals("madhuri", userResult.getUserName());
	}
}
