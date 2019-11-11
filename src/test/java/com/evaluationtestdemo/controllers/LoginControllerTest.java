/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.iServices.ILoginService;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class LoginControllerTest extends JunitUtils{
	
	@Mock
	private ILoginService loginService;

	@Before
	public void setUp() {
		super.setUp();
	}
	/**
	 * Test method for {@link com.evaluationtestdemo.controllers.LoginController#login(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testLogin() {
		String uri = "/user/login";
			LoginRequestModel loginRequestModel = new LoginRequestModel();
			loginRequestModel.setEmail("ajeetkumar@gmail.com");
			loginRequestModel.setPassword("ajeet1");
			User user=new User();
			user.setEmail(loginRequestModel.getEmail());
			user.setPassword(loginRequestModel.getPassword());
			Mockito.when(loginService.validateUserEmail(loginRequestModel.getEmail())).thenReturn(true);
			Mockito.when(loginService.findByEmail(loginRequestModel.getEmail())).thenReturn(user);
		try {
			String inputJson = super.mapToJson(loginRequestModel);
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
