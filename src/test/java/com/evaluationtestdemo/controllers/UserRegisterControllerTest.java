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
import com.evaluationtestdemo.iServices.IUserRegisterationService;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.utils.JunitUtils;

/**
 * @author MadhuriC
 *
 */
class UserRegisterControllerTest extends JunitUtils {

	
	@Mock
	IUserRegisterationService userService;
	
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
		UserRequestModel userModel = new UserRequestModel();
		userModel.setEmail("madhurichaudhari905@gmail.com");
		userModel.setPassword("madhuri");
		userModel.setMobile("1234567898");
		userModel.setUserName("madhuri");
		userModel.setChangePasswordStatus(true);
		//TODO: We can switch createdBy accordignly user/admin
		userModel.setCreatedBy("user");
		userModel.setGender("female");
		
		Mockito.when(userService.checkUserEmailAndPhone(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);
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
