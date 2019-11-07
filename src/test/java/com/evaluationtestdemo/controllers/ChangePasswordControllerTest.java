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
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.services.ChangePasswordService;
import com.evaluationtestdemo.services.LoginService;
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
	LoginService loginService;
	
	@Mock
	ChangePasswordService passwordService;

	
	@BeforeEach
	public void setUp(){
		super.setUp();
	}

	@Test
	void testChangePasswordWhenSuccess() {
		String uri = "/user/changePassword";
			ChangePasswordRequestModel changePassword=new ChangePasswordRequestModel();
			changePassword.setNewpassword("admin");
			changePassword.setConfirmpassword("admin");
			changePassword.setOldpassword("user");
			changePassword.setChangePasswordStatus(true);
			changePassword.setEmail("madhuric@hcl.com");
			User user = new User();
			user.setEmail("madhuric@gmail.com");
			user.setPassword("user");
			user.setId(1);
			Mockito.when(loginService.findByEmail(changePassword.getEmail())).thenReturn(user);
			Mockito.when(passwordService.getMatchPassword(changePassword.getOldpassword(), user.getPassword())).thenReturn(true);
			Mockito.when(passwordService.updatepassword((user.getEmail()),changePassword.getConfirmpassword())).thenReturn(1);
			Mockito.when(passwordService.updatechangePasswordStatusrById(user.getEmail(),user.getChangePasswordStatus())).thenReturn(1);
			try {
			String inputJson = super.mapToJson(changePassword);
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
