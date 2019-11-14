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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.evaluationdemo.exception.NoObjRespnseModel;
import com.evaluationtestdemo.EvaluationTestDemoApplication;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.UserRegisterationServiceInter;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.utils.AppConstant;

/**
 * Create UserRegisterControllerTest.class Test here UserRegisterControllerTest
 * function
 * 
 * @author MadhuriC
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EvaluationTestDemoApplication.class)
class UserRegisterControllerTest {

	@Mock
	UserRegisterationServiceInter userRegisterServiceInter;

	@InjectMocks
	UserRegisterController userRegisterController;

	/**
	 * Test User Registration checkUserEmailAndPhone and addUser if will return 201
	 * it will be success
	 * 
	 */
	@Test
	public void testRegisterUserWhenSucess() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("madhurichaudhari905@gmail.com");
		userRequestModel.setId(1);
		userRequestModel.setPassword("madhuri");
		userRequestModel.setConfirmPassword("madhuri");
		userRequestModel.setMobile("1234567898");
		userRequestModel.setUserName("madhuri");
		userRequestModel.setChangePasswordStatus(true);
		// TODO: We can switch createdBy accordignly user/admin
		userRequestModel.setCreatedBy("user");
		userRequestModel.setGender("female");
		Mockito.when(userRegisterServiceInter.checkUserEmailAndPhone(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString())).thenReturn(null);
		Mockito.when(userRegisterServiceInter.addUser(userRequestModel)).thenReturn(new User(userRequestModel));

		ResponseEntity<Object> entity = userRegisterController.registerUser(userRequestModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(201);

	}

	/**
	 * Test User Registration checkUserEmailAndPhone and addUser if will return 200
	 * it will be Fail.
	 * 
	 */

	@Test
	public void testRegisterUserWhenFail() {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setEmail("madhurichaudhari905@gmail.com");
		userRequestModel.setId(1);
		userRequestModel.setPassword("madhuri");
		userRequestModel.setConfirmPassword("madhuri");
		userRequestModel.setMobile("1234567898");
		userRequestModel.setUserName("madhuri");
		userRequestModel.setChangePasswordStatus(true);
		// TODO: We can switch createdBy accordignly user/admin
		userRequestModel.setCreatedBy("user");
		userRequestModel.setGender("female");

		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(
				new NoObjRespnseModel(true, AppConstant.USER_EMAIL_MOBILE_EXIST), HttpStatus.OK);

		Mockito.when(userRegisterServiceInter.checkUserEmailAndPhone(userRequestModel.getMobile(),
				userRequestModel.getEmail(), userRequestModel.getCreatedBy())).thenReturn(responseEntity);

		ResponseEntity<Object> entity = userRegisterController.registerUser(userRequestModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

}
