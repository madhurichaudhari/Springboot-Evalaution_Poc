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

import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class ChangePasswordControllerTest extends JunitUtils {

	@BeforeEach
	public void setUp(){
		super.setUp();
	}

	@Test
	void testChangePassword() {
		String uri = "/user/changePassword";
		try {
			ChangePasswordRequestModel changepassword = new ChangePasswordRequestModel();
			changepassword.setEmail("madhurichaudhari905@gmail.com");
			changepassword.setOldpassword("madhuri");
			changepassword.setNewpassword("madhuri");
			changepassword.setConfirmpassword("madhuri");
		
			String inputJson = super.mapToJson(changepassword);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
