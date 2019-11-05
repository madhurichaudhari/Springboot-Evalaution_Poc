/**
 * 
 */
package com.evaluationtestdemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.repositories.OtpVerifyRepository;
import com.evaluationtestdemo.requestmodels.ChangePasswordRequestModel;
import com.evaluationtestdemo.servicesimp.ChangePasswordServiceImp;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class ChangePasswordControllerTest extends JunitUtils {
	@Mock
	LoginRepository loginRepo;
	@Mock
	ChangePasswordRepository passwordRepository;
	@Mock
	LoginRepository loginRepository;
	@Mock
	OtpVerifyRepository otpRepo;
	@Mock
	PasswordEncoder passwordEncoder;
	@InjectMocks
	LoginServiceImp loginService;
	@InjectMocks
	ChangePasswordServiceImp changePassSerImp;

	@BeforeEach
	public void setUp(){
		super.setUp();
	}

	@Test
	void testChangePassword() {
		String uri = "/user/changePassword";
		try {
			User user = new User();
			user.setEmail("madhurichaudhari905@gmail.com");
			user.setPassword("madhuri");
			user.setId(1);
			Mockito.when(passwordEncoder.encode("madhuri")).thenReturn("#DREDRHR###");
			Mockito.when(loginRepository.findByEmail(user.getEmail())).thenReturn(user);
		
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
