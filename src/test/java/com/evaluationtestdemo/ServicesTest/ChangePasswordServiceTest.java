package com.evaluationtestdemo.ServicesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.evaluationtestdemo.services.ChangePasswordService;

/**
 * ChangePasswordServiceTest for test the logic of Change password 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChangePasswordServiceTest {

	@Autowired
	ChangePasswordService changePasswordService;

	/**
	 * call function for test testUpdatepassword
	 */
	@Test
	public void testUpdatechangePasswordStatusrById() {		
		
		int changePasswordSatus = changePasswordService.updatepassword("madhurichaudhari905@gmail.com", "madhuri");
		
		assertEquals(1,changePasswordSatus);
	}
	
	
	/**
	 * call function for test testUpdatepassword
	 */

	
	


}








