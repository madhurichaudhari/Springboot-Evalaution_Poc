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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;

/**
 * @author MadhuriC
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginServiceTest {

	@Mock
	LoginRepository loginRepository;
	@InjectMocks
	LoginServiceImp loginServiceimp;

	/**
	 * Initialize Mocked
	 */
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
	  }
	/**
	 * Testing User/Admin has been logged successfully
	 */
	@Test
	public void testUserLoginWhenSuccess() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("Ranjeet@gmail.com");
		loginRequestModel.setPassword("ranjeet");
		Mockito.when(loginRepository.existsByEmail(loginRequestModel.getEmail())).thenReturn(true);
		boolean loginSatus = loginServiceimp.validateUserEmail(loginRequestModel.getEmail());
		assertEquals(true, loginSatus);
	}

	
	/**
	 * 
	 */
	@Test
	public void testAdminLoginWhenFail() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("madhurichaudhari905@@gmail.com");
		loginRequestModel.setPassword("madhuri");
		Mockito.when(loginRepository.existsByEmail(loginRequestModel.getEmail())).thenReturn(false);
		boolean loginSatus = loginServiceimp.validateUserEmail(loginRequestModel.getEmail());
		assertEquals(false, loginSatus);
	}

}
