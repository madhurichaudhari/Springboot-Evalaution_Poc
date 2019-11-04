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

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class UserRegistrationControllerTest extends JunitUtils {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	void testUser() {
		String uri = "/user/signup";
		try {
			User user  = new User();
			user.setEmail("madhurichaudhari905@gmail.com");
			user.setPassword("madhuri");
			user.setMobile("1234567898");
			user.setFirstName("madhuri");
			user.setLast_name("chaudhari");
			user.setIs_otp_verified("T");
			user.setChangePasswordStatus("T");
			user.setCreatedBy("admin");
			user.setGender("female");		
			String inputJson = super.mapToJson(user);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			mvcResult.getResponse().getStatus();
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testAdmin() {
		String uri = "/user/signup";
		try {
			User user  = new User();
			user.setEmail("Ranjeet@gmail.com");
			user.setPassword("rajeet");
			user.setMobile("1234567897");
			user.setFirstName("Ranjeet");
			user.setLast_name("yadav");
			user.setIs_otp_verified("F");
			user.setChangePasswordStatus("F");
			user.setCreatedBy("user");
			user.setGender("male");
			String inputJson = super.mapToJson(user);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).
					contentType(MediaType.APPLICATION_JSON_VALUE).
					content(inputJson))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			mvcResult.getResponse().getStatus();
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
