package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.LoginRequestModel;
import com.evaluationtestdemo.services.LoginService;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;

/**
 * @author MadhuriC
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

	@Mock
	LoginRepository loginRepo;

	@InjectMocks
	LoginService loginService =new  LoginServiceImp();

	
	/**
	 * testUserLoginSuccess
	 */
	
	@Before
	public void setup() {
		
	  }
	
	
	
	  
	
	
	/**
	 * call function for testing User has not been logged successfully
	 */
	@Test
	public void testUserLoginSuccess() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("Ranjeet@gmail.com");
		loginRequestModel.setPassword("ranjeet");
		Mockito.when(loginRepo.existsByEmail(loginRequestModel.getEmail())).thenReturn(true);
		boolean loginSatus = loginService.validateUserEmail(loginRequestModel.getEmail());
		assertEquals(true, loginSatus);
	}

	/**
	 * call function for testing Admin has not been logged successfully
	 */
	@Test
	public void testAdminLoginSuccess() {
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		loginRequestModel.setEmail("madhurichaudhari905@@gmail.com");
		loginRequestModel.setPassword("madhuri");
		Mockito.when(loginRepo.existsByEmail(loginRequestModel.getEmail())).thenReturn(true);
		boolean loginSatus = loginService.validateUserEmail(loginRequestModel.getEmail());
		assertEquals(true, loginSatus);
	}

}
