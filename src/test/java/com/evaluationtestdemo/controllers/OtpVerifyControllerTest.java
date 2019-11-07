/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.repositories.OtpVerifyRepository;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;
import com.evaluationtestdemo.servicesimp.OtpServiceImp;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class OtpVerifyControllerTest extends JunitUtils {
	
	@Mock
	LoginRepository loginRepo;
	
	@Mock
	OtpVerifyRepository otpRepo;

	@InjectMocks
	LoginServiceImp loginService;

	@InjectMocks
	OtpServiceImp otpServiceImp;

	@Mock
	OtpVerifyRepository otpVfyRepository;
	
	


	@Before
	public void setUp() {
		super.setUp();
	}

	/**
	 * Test method for {@link com.evaluationtestdemo.controllers.OtpVerifyController#verifyOtp(com.evaluationtestdemo.requestmodels.LoginRequestModel)}.
	 */
	@Test
	void testVerifyOtp() {
		String uri = "/user/otpVerify";
		try {
			User user = new User();
			user.setEmail("madhurichaudhari905@gmail.com");
			user.setOtp("06461");
			user.setOtpVerifiedStatus(true);
			user.setChangePasswordStatus(true);
			user.setId(1);
			Mockito.when(loginRepo.findByEmail(user.getEmail())).thenReturn(user);
			Mockito.when(otpServiceImp.otpVerified(user.getOtpVerifiedStatus(), user.getId())).thenReturn(1);
			String inputJson = super.mapToJson(user);
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
