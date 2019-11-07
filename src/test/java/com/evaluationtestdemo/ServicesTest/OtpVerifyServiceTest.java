/**
 * 
 */
package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.OtpVerifyRepository;
import com.evaluationtestdemo.servicesimp.OtpServiceImp;

/**
 * @author MadhuriC
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class OtpVerifyServiceTest {

	@InjectMocks
	OtpServiceImp otpServiceImp;
	
	@Mock
	OtpVerifyRepository otpVfyRepository;


	/**
	 * 
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test method for
	 * {@link com.evaluationtestdemo.controllers.OtpVerifyController#verifyOtp(com.evaluationtestdemo.requestmodels.OtpRequestModel)}.
	 */
	@Test
	public void testOtpVerified() {
		User user = new User();
		user.setEmail("madhurichaudhari905@gmail.com");
		user.setOtp("06461");
		user.setId(1);
		user.setOtpVerifiedStatus(true);;
		
		Mockito.when(otpVfyRepository.updateisOtpVerifiedById(user.getOtpVerifiedStatus(), user.getId())).thenReturn(1);
		int status = otpServiceImp.otpVerified(user.getOtpVerifiedStatus(),user.getId());
		assertEquals(1, status);
	}

}
