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
import com.evaluationtestdemo.requestmodels.OtpRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class OtpVerifyControllerTest extends JunitUtils {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/**
	 * Test method for {@link com.evaluationtestdemo.controllers.OtpVerifyController#getVerifyOtp(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testVerifyOtp() {
		String uri = "/user/otpVerify";
		try {
			OtpRequestModel OtpRequestModel = new OtpRequestModel();
			OtpRequestModel.setEmail("madhurichaudhari905@gmail.com");
			OtpRequestModel.setOtp("06461");
			String inputJson = super.mapToJson(OtpRequestModel);
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
