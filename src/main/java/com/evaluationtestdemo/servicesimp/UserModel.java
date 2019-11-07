package com.evaluationtestdemo.servicesimp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.evaluationtestdemo.entities.User;

/**
 * @author MadhuriC
 *
 */
public class UserModel {

	private long id;

	/**
	 * @param id
	 * @param firstName
	 * @param last_name
	 * @param gender
	 * @param email
	 * @param mobile
	 * @param createdBy
	 * @param changePasswordStatus
	 * @param password
	 * @param otp
	 * @param otpVerifiedStatus
	 */
	public UserModel(long id, String firstName, String last_name, String gender, String email, String mobile,
			String createdBy, boolean changePasswordStatus, String password, String otp, boolean otpVerifiedStatus) {
		this.id = id;
		this.firstName = firstName;
		this.last_name = last_name;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.createdBy = createdBy;
		this.changePasswordStatus = changePasswordStatus;
		this.password = password;
		this.otp = otp;
		this.otpVerifiedStatus = otpVerifiedStatus;

	}

	@NotBlank(message = "First Name is mandatory")
	private String firstName;

	private String last_name;
	@NotBlank(message = "Enter a valid Gender Details")

	private String gender;
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")

	private String email;
	@Size(min = 10, max = 10, message = "Enter the valid phone number")

	private String mobile;

	private String createdBy;

	private boolean changePasswordStatus;

	private String password;

	private String otp;

	private boolean otpVerifiedStatus;
	
	private User user;

	/**
	 * @return isOtpVerified
	 */

	public boolean getOtpVerifiedStatus() {
		return otpVerifiedStatus;
	}

	/**
	 * @param otpVerifiedStatus
	 */
	public void setOtpVerifiedStatus(boolean otpVerifiedStatus) {
		this.otpVerifiedStatus = otpVerifiedStatus;
	}

	/**
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return
	 */
	public boolean getChangePasswordStatus() {
		return changePasswordStatus;
	}

	/**
	 * @param changePasswordStatus
	 */
	public void setChangePasswordStatus(boolean changePasswordStatus) {
		this.changePasswordStatus = changePasswordStatus;
	}

	/**
	 * @return
	 */
	public String getOtp() {
		return otp;
	}

	/**
	 * @param otp
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	public UserModel() {
		super();

	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	
	/**
	 * @return User
	 */
	public User getUser() {
		if(user == null) {
		user=new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLast_name(last_name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setCreatedBy(createdBy);
		user.setPassword(password);
		user.setGender(gender);
		user.setOtp(otp);
		user.setOtpVerifiedStatus(otpVerifiedStatus);
		user.setChangePasswordStatus(changePasswordStatus);
		}
	    return user;
	}
}
