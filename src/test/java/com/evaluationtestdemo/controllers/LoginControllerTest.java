/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.evaluationtestdemo.EvaluationTestDemoApplication;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.LoginServiceInter;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.requestmodels.UserRequestModel;

/**
 * @author MadhuriC
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EvaluationTestDemoApplication.class)
class LoginControllerTest {

	@Mock
	private LoginServiceInter loginService;
	@InjectMocks
	private LoginController loginController;

	/**
	 * Test method for
	 * {@link com.evaluationtestdemo.controllers.LoginController#login(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testUserLoginWhenSuccess() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("ajeetkumar@gmail.com");
		loginRequestModel.setPassword("ajeet1");
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail(loginRequestModel.getEmail());
		userRequestModel.setPassword(loginRequestModel.getPassword());
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setPassword("ajeet1");
		user.setChangePasswordStatus(true);
		Mockito.when(loginService.validateUserEmail(loginRequestModel.getEmail())).thenReturn(true);
		Mockito.when(loginService.validateUserPassword(loginRequestModel.getPassword(), loginRequestModel.getEmail()))
				.thenReturn(true);
		Mockito.when(loginService.findByEmail(loginRequestModel.getEmail())).thenReturn(user);
		ResponseEntity<Object> entity = loginController.login(loginRequestModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	void testUserLoginWhenFail() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("ajeetkumar@gmail.com");
		loginRequestModel.setPassword("ajeet1");
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail(loginRequestModel.getEmail());
		userRequestModel.setPassword(loginRequestModel.getPassword());
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setPassword("ajeet1");
		user.setChangePasswordStatus(false);
		Mockito.when(loginService.validateUserEmail(loginRequestModel.getEmail())).thenReturn(true);
		Mockito.when(loginService.validateUserPassword(loginRequestModel.getPassword(), loginRequestModel.getEmail()))
		.thenReturn(false);
		ResponseEntity<Object> entity = loginController.login(loginRequestModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(500);

	}

}
