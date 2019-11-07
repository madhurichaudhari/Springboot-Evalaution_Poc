package com.evaluationtestdemo.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author MadhuriC
 *
 */
@Component
public class MiscUtil {
	/**
	 * @param length
	 * @return
	 */
	public char[] generateOtp(int length) {
		
		 Random obj = new Random(); 
		    char[] otp = new char[length]; 
		    for (int i=0; i<length; i++) 
		    { 
		      otp[i]= (char)(obj.nextInt(10)+48); 
		    } 
		    return otp; 
	}
	
	/**
	 * @param n
	 * @return
	 */
	public String getRandomPwd(int n) 
    { 
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"
                                    +"!@#$%^&*()_-+=|}]{['<>.,;?" ;
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
        for (int i = 0; i < n; i++) { 
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }	

}
