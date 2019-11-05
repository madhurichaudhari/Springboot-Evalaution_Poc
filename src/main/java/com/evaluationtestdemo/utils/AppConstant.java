
package com.evaluationtestdemo.utils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


/**
 * @author MadhuriC
 *
 */

public class AppConstant {
	
	

	public static final Contact DEFAULT_CONTACT = new Contact("Madhuri Chaudhari",
			"http://www.hcl.com <http://www.hcl.com> ",
			"madhuric@hcl.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("EvaluationDemo API",
			"EvaluationDemo API for cleint implementation.", "1.0", "urn:tos", DEFAULT_CONTACT, "evaluationV1.0",

			"http://www.hcl.com <http://www.hcl.com> ");

	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(

			Arrays.asList("application/json"));

	/**
	 * USER_LOGIN_SUCCESS
	 */
	public static final String USER_LOGIN_SUCCESS = "User Login Successfully";

	/**
	 * USER_FIRST_TIME
	 */
	public static final String USER_FIRST_TIME = "You are  first time login,so please change the password ";
	/**
	 * USER_OTP_NOT_VERIFIED
	 */
	public static final String USER_OTP_NOT_VERIFIED = "User OTP is  not Verified Login Failed";
	/**
	 * EMAIL_DOES_NOT_EXIST
	 */
	public static final String EMAIL_DOES_NOT_EXIST = "Email does not exist Login Failed";
	/**
	 * PASSWORD_DOES_NOT_EXIST
	 */
	public static final String PASSWORD_DOES_NOT_EXIST = "Password is  not Correct Login Failed";
	public static final String OTP_VERIFIED = "Otp is verified Successfully.";
	public static final String OTP_WRONG = "Otp is wrong";
	public static final String SUCCESS_FULLY_UPDATED = "Successfully updated.";
	public static final String BAD_REQUEST = "Bad request.";
	public static final String SUCCESS = "Success";
	public static final String SUCCESSFULLY_PWD_SEND = "Password send to your email.";
	public static final String EMAIL_NOT_EXIST = "Email not exist.";
	public static final String SUCCESSFULLY_PWD_CHANGED = "Password changed succesfully";
	public static final String PWD_MATCHED_FAILED = "Old Password dose not match.";
	public static final String Yes = "T";
	public static final String No = "F";
	public static final String USER_NOT_EXIST = "User does not exist";
	public static final String RECONFIRM_PWD_MATCHED_FAILED = "Password dose not match";
	public static final String EMAIL_SUBJECT = "Car Pool :: Forget-Password";
	public static final String USER_NOT_FOUND = "User Not Found";
	public static final String USER_REGISTRATION_NOT_COMPLETE = "User Registration Is Not Complete";
	public static final String USER_EMAIL_MOBILE_EXIST = "User Mobile or Email already exist";
	public static final String VERIFY_OTP_FOR_SIGNUP = "Verify Otp for signup";

}
