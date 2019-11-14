package com.evaluationtestdemo.servicestest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.UserRegisterationRepository;
import com.evaluationtestdemo.requestmodels.UserRequestModel;
import com.evaluationtestdemo.servicesimp.UserRegisterServiceImpl;

/**
 * @author MadhuriC
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRegisterServiceTest {

	@Mock
	UserRegisterationRepository userRepository;

	@InjectMocks
	UserRegisterServiceImpl userServiceImp;

	@Mock
	PasswordEncoder passwordEncoder;

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
	public void test_UserRegister_When_Success() {
		UserRequestModel userModel = new UserRequestModel();
		userModel.setEmail("chaudharimadhuri905@gmail.com");
		userModel.setId(1);
		userModel.setPassword("madhuri");
		userModel.setMobile("1234567897");
		userModel.setUserName("madhuri");
		userModel.setChangePasswordStatus(false);
		// TODO: We can switch createdBy accordignly user/admin
		userModel.setCreatedBy("admin");
		userModel.setGender("female");
		Mockito.when(passwordEncoder.encode(userModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(new User(userModel))).thenReturn(new User(userModel));
		User userResult = userServiceImp.addUser(userModel);
		assertEquals("chaudhari", userResult.getUserName());
	}

	/**
	 * test user Registration
	 */

	@Test
	public void test_UserRegister_When_Fail() {

		UserRequestModel userModel = new UserRequestModel();
		userModel.setEmail("chaudharimadhuri905@gmail.com");
		userModel.setPassword("madhuri");
		userModel.setMobile("1234567897");
		userModel.setUserName("madhuri");
		userModel.setChangePasswordStatus(false);
		// TODO: We can switch createdBy accordignly user/admin
		userModel.setCreatedBy("admin");
		userModel.setGender("female");
		Mockito.when(passwordEncoder.encode(userModel.getPassword())).thenReturn("12345dRDCB");
		Mockito.when(userRepository.save(new User(userModel))).thenReturn(null);
		User userResult = userServiceImp.addUser(userModel);
		assertEquals(null, userResult);
	}

}