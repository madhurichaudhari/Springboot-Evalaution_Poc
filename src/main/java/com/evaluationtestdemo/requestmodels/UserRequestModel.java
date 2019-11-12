package com.evaluationtestdemo.requestmodels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.evaluationtestdemo.entities.User;

/**
 * @author MadhuriC
 *
 */
public class UserRequestModel {

	private long id;
	@NotBlank(message = "First Name is mandatory")
	private String userName;
	@NotBlank(message = "Enter a valid Gender Details")
	private String gender;
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	@Size(min = 10, max = 10, message = "Enter the valid phone number")
	private String mobile;
	private String createdBy;
	private boolean changePasswordStatus;
	private String password;
	private String confirmPassword;

	/**
	 * @return confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private User user;

	/**
	 * @param id
	 * @param userName
	 * @param gender
	 * @param email
	 * @param mobile
	 * @param createdBy
	 * @param changePasswordStatus
	 * @param password
	 * @param confirmPassword
	 * @param otp
	 * @param otpVerifiedStatus
	 */
	public UserRequestModel(long id, String userName, String gender, String email, String mobile, String createdBy,
			boolean changePasswordStatus, String password, String confirmPassword) {
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.createdBy = createdBy;
		this.changePasswordStatus = changePasswordStatus;
		this.password = password;
		this.confirmPassword = confirmPassword;

	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return createdBy
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
	 * @return changePasswordStatus
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
	 * @return password
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
	public UserRequestModel() {
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
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


}
