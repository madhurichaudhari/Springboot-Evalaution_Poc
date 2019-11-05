package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.EmailRequestModel;
import com.evaluationtestdemo.servicesimp.UserServiceImpl;
import com.evaluationtestdemo.utils.EmailUtil;

/**
 * @author MadhuriC
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterationServiceTest {
	
	@Mock
	UserRegisterationRepository userRep;
	@InjectMocks
	UserServiceImpl userRegImp;
	@InjectMocks
	EmailUtil emailUtil;
	@Mock
	JavaMailSender javaMailSender;
	
	/**
	 * Initialize Mocked
	 */
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
	  }
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
		Mockito.when(userRep.save(user)).thenReturn(user);
		User userResult = userRegImp.addUser(emailUtil,javaMailSender,user, emailRequestModel);
		assertEquals("chaudhari", userResult.getFirstName());
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
		Mockito.when(userRep.save(user)).thenReturn(user);
		User userResult = userRegImp.addUser(emailUtil,javaMailSender,user, emailRequestModel);
		assertEquals("Ajeet", userResult.getFirstName());
	}
}
