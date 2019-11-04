package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;
import com.evaluationtestdemo.services.UserRegisterationService;

/**
 * @author MadhuriC
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterationServiceTest {

	
	  @Autowired
	  UserRegisterationService userService;
	
	/**
	 * test user Registration
	 */

	@Test
	public void testUserRegistration1() {
	
		EmailRequestModel emailRequestModel = new EmailRequestModel("androidhcl@12345", "OTP send",
				"verify Otp for SignUp");
		User user  = new User();
		user.setEmail("chaudharimadhuri905@gmail.com");
		user.setPassword("madhuri");
		user.setMobile("1234567897");
		user.setFirstName("chaudhari");
		user.setLast_name("madhuri");
		user.setIs_otp_verified("T");
		user.setChangePasswordStatus("T");
		user.setCreatedBy("admin");
		user.setGender("female");
		User userResult = userService.addUser(user, emailRequestModel);
		assertEquals("Madhuri", userResult.getFirstName());
	}

	/**
	 * test Admin Registration
	 */
	@Test
	public void testAdminRegistration() {
		User user = new User();
		EmailRequestModel emailRequestModel = new EmailRequestModel("androidhcl@12345", "OTP send",
				"verify Otp for SignUp");
		user.setEmail("Ajeet@gmail.com");
		user.setPassword("ajeet");
		user.setMobile("1234567896");
		user.setFirstName("Ajeet");
		user.setLast_name("yadav");
		user.setIs_otp_verified("F");
		user.setChangePasswordStatus("F");
		user.setCreatedBy("user");
		user.setGender("male");
		User userResult = userService.addUser(user, emailRequestModel);
		assertEquals("Sujeet", userResult.getFirstName());
	}

}
