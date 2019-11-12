/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.IchangePasswordService;
import com.evaluationtestdemo.iServices.IloginService;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class ChangePasswordControllerTest extends JunitUtils {
	@Mock
	LoginRepository loginRepository;
	@Mock
	ChangePasswordRepository passwordRepository;
	
	@Mock
	IloginService loginService;
	
	@Mock
	IchangePasswordService passwordService;

	
	@BeforeEach
	public void setUp(){
		super.setUp();
	}

	@Test
	void testUserChangePasswordWhenSuccess() {
		String uri = "/user/changePassword";
			ChangePasswordRequestModel changePasswordModel=new ChangePasswordRequestModel();
			changePasswordModel.setNewpassword("admin");
			changePasswordModel.setConfirmpassword("admin");
			changePasswordModel.setOldpassword("user");
			changePasswordModel.setChangePasswordStatus(true);
			changePasswordModel.setEmail("madhuric@hcl.com");
			changePasswordModel.setUserid("1");
			User user = new User();
			user.setEmail("madhuric@gmail.com");
			user.setPassword("user");
			user.setId(1);
			Mockito.when(loginService.findByEmail(changePasswordModel.getEmail())).thenReturn(user);
			Mockito.when(passwordService.getMatchPassword(changePasswordModel.getOldpassword(), user.getPassword())).thenReturn(true);
			Mockito.when(passwordService.updatepassword((user.getEmail()),changePasswordModel.getConfirmpassword())).thenReturn(1);
			Mockito.when(passwordService.updatechangePasswordStatusrById(user.getEmail(),user.getChangePasswordStatus())).thenReturn(1);
			try {
			String inputJson = super.mapToJson(changePasswordModel);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
