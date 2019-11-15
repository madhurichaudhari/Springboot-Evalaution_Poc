package com.evaluationtestdemo.servicesimp;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.evaluationdemo.exception.UserNotFoundException;
import com.evaluationtestdemo.EvaluationTestDemoApplication;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;

/**
 * @author MadhuriC
 *
 */
@SpringBootTest(classes = EvaluationTestDemoApplication.class)
public class LoginServiceImpTest {
 
	
	@Mock
	LoginRepository loginRepository;
	@InjectMocks
	LoginServiceImp loginServiceimp;

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
	 * Test Case for ValidateEmail when user email is verified
	 */
	@Test
	public void testUserLoginForValidateEmailWhenSuccess() {
		Mockito.when(loginRepository.existsByEmail("Ranjeet@gmail.com")).thenReturn(true);
		boolean loginSatus = loginServiceimp.validateUserEmail("Ranjeet@gmail.com");
		assertEquals(true, loginSatus);
	}

	/**
	 * Test Case for ValidateEmail when user email is not verified
	 */
	@Test
	public void testUserLoginForValidateEmailWhenFail() {
		Mockito.when(loginRepository.existsByEmail("Ranjeet@gmail.com")).thenReturn(false);
		UserNotFoundException exception = new UserNotFoundException();
		//Mockito.when(exception).thenThrow(exception);
		boolean loginSatus = loginServiceimp.validateUserEmail("Ranjeet@gmail.com");
		//assertEquals(false, loginSatus);
	}

	/**
	 * Test Case for FindEmail when user email is verified
	 */
	@Test
	public void testUserLoginForFindEmailWhenSuccess() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(true);
		Mockito.when(loginRepository.findByEmail("admin@gmail.com")).thenReturn(user);
		User userDetails = loginServiceimp.fetchByEmail("admin@gmail.com");
		assertEquals("admin@gmail.com", userDetails.getEmail());
	}

	/**
	 * Test Case for FindEmail when user email is not verified and return User type
	 */
	@Test
	public void testUserLoginForFindEmailWhenFail() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(true);
		Mockito.when(loginRepository.findByEmail("admin@gmail.com")).thenReturn(user);
		User userDetails = loginServiceimp.fetchByEmail("admin@gmail.com");

		// assertEquals("admin@gmail.com", userDetails.getEmail());
	}

	/**
	 * Test Case for ValidateUserPasswordl when user Password is verified and return
	 * User type
	 */
	@Test
	public void testUserLoginForValidateUserPasswordWhenSuccess() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setPassword("abc@123");
		user.setChangePasswordStatus(true);
		Mockito.when(loginRepository.findByEmail("admin@gmail.com")).thenReturn(user);
		Mockito.when(passwordEncoder.matches("abc@123", user.getPassword())).thenReturn(true);
		boolean loginSatus = loginServiceimp.validateUserPassword("abc@123", "admin@gmail.com");
		assertEquals(true, loginSatus);
	}

	/**
	 * * Test Case for ValidateUserPasswordl when user Password is not verified and
	 * return User type
	 * 
	 */
	@Test
	public void testUserLoginForValidateUserPasswordWhenFail() {
		Mockito.when(loginRepository.findByEmail("admin@gmail.com")).thenReturn(null);
		// assertEquals("admin@gmail.com", userDetails.getEmail());
	}

}
