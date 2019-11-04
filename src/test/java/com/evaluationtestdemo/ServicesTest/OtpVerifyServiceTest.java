/**
 * 
 */
package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.entities.User;
import com.evaluationtestdemo.repositories.LoginRepository;
import com.evaluationtestdemo.requestmodels.OtpRequestModel;
import com.evaluationtestdemo.services.LoginService;
import com.evaluationtestdemo.services.OtpService;

/**
 * @author MadhuriC
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class OtpVerifyServiceTest {

	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	LoginService loginService;
	@Autowired
	OtpService otpService;

	@Before
	public void setup() {
		
	  }


	/**
	 * Test method for
	 * {@link com.evaluationtestdemo.controllers.OtpVerifyController#getVerifyOtp(com.evaluationtestdemo.requestmodels.OtpRequestModel)}.
	 */
	@Test
	public void testVerifyOtp() {
		OtpRequestModel otpRequestModel = new OtpRequestModel();
		otpRequestModel.setEmail("madhurichaudhari905@gmail.com");
		otpRequestModel.setOtp("06461");
		User user = loginService.findByEmail(otpRequestModel.getEmail());
		int status = otpService.otpVerified("T", user.getId());
		assertEquals(1, status);

	}

}
