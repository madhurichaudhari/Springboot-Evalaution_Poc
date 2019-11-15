package com.evaluationtestdemo.servicesimp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.evaluationtestdemo.EvaluationTestDemoApplication;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.ChangePasswordRepository;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.servicesimp.ChangePasswordServiceImp;
import com.evaluationtestdemo.servicesimp.LoginServiceImp;

/**
 * ChangePasswordServiceTest for test the logic of Change password
 */
@SpringBootTest(classes = EvaluationTestDemoApplication.class)

public class ChangePasswordServiceImpTest {
	
	@Mock
	ChangePasswordRepository passwordRepository;
	@Mock
	LoginRepository loginRepository;
	
	@Mock
	PasswordEncoder passwordEncoder;
	@InjectMocks
	LoginServiceImp loginService;
	@InjectMocks
	ChangePasswordServiceImp changePassSerImp;

	/**
	 * Initialize mocked
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * call function for test testUpdatepassword
	 */
	@Test
	public void testUpdatePassword() {
		User user = new User();
		user.setEmail("madhurichaudhari905@gmail.com");
		user.setPassword("madhuri");
		user.setId(1);
		Mockito.when(passwordEncoder.encode("madhuri")).thenReturn("");
		Mockito.when(loginRepository.findByEmail(user.getEmail())).thenReturn(user);
		Mockito.when(passwordRepository.UpdateUserById(passwordEncoder.encode("madhuri"), user.getId())).thenReturn(1);
		int changePasswordSatus = changePassSerImp.updatepassword("madhurichaudhari905@gmail.com", "madhuri");
		assertEquals(1, changePasswordSatus);
	}

	/**
	 * call function for test testUpdatechangePasswordStatusrById
	 */

	@Test
	public void testUpdatechangePasswordStatusrById() {
		User user  = new User();
		user.setEmail("madhurichaudhari905@gmail.com");
		user.setPassword("madhuri");
		user.setId(1);
		Mockito.when(loginRepository.findByEmail(user.getEmail())).thenReturn(user);
		Mockito.when(passwordRepository.updateChangePasswordStatusrById(true, user.getId())).thenReturn(1);
		int changePasswordSatus = changePassSerImp.updatechangePasswordStatusrById("madhurichaudhari905@gmail.com",true);
		assertEquals(1, changePasswordSatus);
}

}
