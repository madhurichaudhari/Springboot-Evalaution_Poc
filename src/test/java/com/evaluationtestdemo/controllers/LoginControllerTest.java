/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class LoginControllerTest extends JunitUtils{

	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	/**
	 * Test method for {@link com.evaluationtestdemo.controllers.LoginController#login(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testLogin() {
		String uri = "/user/login";
		try {
			LoginRequestModel loginRequestModel = new LoginRequestModel();
			loginRequestModel.setEmail("ajeetkumar@gmail.com");
			loginRequestModel.setPassword("ajeet1");
			String inputJson = super.mapToJson(loginRequestModel);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	/**
	 * Test method for {@link com.evaluationtestdemo.controllers.LoginController#adminLogin(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testAdminLogin() {
		
		String uri = "/user/login";
		try {
			LoginRequestModel loginRequestModel = new LoginRequestModel();
			loginRequestModel.setEmail("madhurichaudhari905@gmail.com");
			loginRequestModel.setPassword("madhuri");
			String inputJson = super.mapToJson(loginRequestModel);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
