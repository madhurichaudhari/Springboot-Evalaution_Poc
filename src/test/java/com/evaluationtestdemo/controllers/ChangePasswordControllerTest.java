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
import com.evaluationtestdemo.iServices.ChangePasswordServiceInter;
import com.evaluationtestdemo.iServices.LoginServiceInter;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.requestmodels.UserRequestModel;

/**
 * * @author MadhuriC
 *  Created ChangePasswordControllerTest through User can change password.
 * 
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EvaluationTestDemoApplication.class)
class ChangePasswordControllerTest {
	@Mock
	LoginRepository loginRepository;
	@Mock
	ChangePasswordRepository passwordRepository;

	@Mock
	LoginServiceInter loginService;

	@Mock
	ChangePasswordServiceInter changePasswordService;
	@InjectMocks
	ChangePasswordController changePasswordController;
	
	
	/**
	 * Test User can  change Password using findByEmail and updatechangePasswordStatusrById if will return 200
	 * Then password has been changed successfully
	 * 
	 */

	@Test
	void testUserChangePasswordWhenSuccess() {
		ChangePasswordRequestModel changePasswordModel = new ChangePasswordRequestModel();
		changePasswordModel.setNewpassword("admin");
		changePasswordModel.setConfirmpassword("admin");
		changePasswordModel.setOldpassword("user");
		changePasswordModel.setChangePasswordStatus(true);
		changePasswordModel.setEmail("admin@gmail.com");
		changePasswordModel.setUserid("1");
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		userRequestModel.setPassword("user");
		userRequestModel.setId(1);
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(true);
		Mockito.when(loginService.findByEmail(changePasswordModel.getEmail())).thenReturn(user);
		Mockito.when(changePasswordService.validateMatchPassword(changePasswordModel.getOldpassword(),
				userRequestModel.getPassword())).thenReturn(true);
		Mockito.when(
				changePasswordService.updatepassword((userRequestModel.getEmail()), changePasswordModel.getConfirmpassword()))
				.thenReturn(1);
		Mockito.when(changePasswordService.updatechangePasswordStatusrById(user.getEmail(),
				user.getChangePasswordStatus())).thenReturn(1);
		ResponseEntity<Object> entity = changePasswordController.changePassword(changePasswordModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);

	}
	
	/**
	 * Test User can  change Password using findByEmail and updatechangePasswordStatusrById if will return 500
	 * Then password has not  been changed successfully
	 * 
	 */

	@Test
	void testUserChangePasswordWhenFail() {
		ChangePasswordRequestModel changePasswordModel = new ChangePasswordRequestModel();
		changePasswordModel.setNewpassword("admin");
		changePasswordModel.setConfirmpassword("admin");
		changePasswordModel.setOldpassword("user");
		changePasswordModel.setChangePasswordStatus(true);
		changePasswordModel.setEmail("admin@gmail.com");
		changePasswordModel.setUserid("1");
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("admin@gmail.com");
		userRequestModel.setPassword("user");
		userRequestModel.setId(1);
		User user = new User(userRequestModel);
		user.setEmail("admin@gmail.com");
		user.setChangePasswordStatus(false);
		Mockito.when(loginService.findByEmail(changePasswordModel.getEmail())).thenReturn(user);
		Mockito.when(changePasswordService.validateMatchPassword(changePasswordModel.getOldpassword(),
				userRequestModel.getPassword())).thenReturn(true);
		Mockito.when(
				changePasswordService.updatepassword((userRequestModel.getEmail()), changePasswordModel.getConfirmpassword()))
				.thenReturn(0);
		ResponseEntity<Object> entity = changePasswordController.changePassword(changePasswordModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(500);
	}

}
