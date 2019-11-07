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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evaluationtestdemo.services.UserRegisterationService;
import com.evaluationtestdemo.servicesimp.UserModel;
import com.evaluationtestdemo.utils.EmailUtil;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class UserRegisterControllerTest extends JunitUtils {

	/*
	 * @Mock UserRegisterationRepository userRep;
	 * 
	 * @InjectMocks UserServiceImpl userRegImp;
	 */
	@Mock
	UserRegisterationService userService;
	
	@Mock
	EmailUtil emailUtil;
	
	@Mock
	 private JavaMailSender javaMailSender;

	/**
	 * Initialize Mocked
	 */

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	void testRegisterUser() {
		String uri = "/user/signup";
		UserModel userModel = new UserModel();
		userModel.setEmail("madhurichaudhari905@gmail.com");
		userModel.setPassword("madhuri");
		userModel.setMobile("1234567898");
		userModel.setFirstName("madhuri");
		userModel.setLast_name("chaudhari");
		userModel.setOtpVerifiedStatus(true);
		userModel.setChangePasswordStatus(true);
		//TODO: We can switch createdBy accordignly user/admin
		userModel.setCreatedBy("user");
		userModel.setGender("female");
		userModel.setOtp("1244");
		Mockito.when(userService.checkUserEmailAndPhone(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);
		Mockito.when(userService.createRandomOtp()).thenReturn("3456");
		Mockito.doNothing().when(emailUtil).sendEmail(javaMailSender,userModel.getEmail(), "Verify Otp for signup", "Otp is 1244"); 
		Mockito.when(userService.addUser(userModel)).thenReturn(userModel.getUser());
		try {
			String inputJson = super.mapToJson(userModel);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
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
