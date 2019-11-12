package com.evaluationtestdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.evaluationtestdemo.requestmodels.UserRequestModel;

/**
 * @author MadhuriC UserEntity for Creating User Entity
 *
 */
@Entity
@Table(name = "users_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	@Column
	private String userName;
	@Column
	private String gender;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column
	private String mobile;
	@Column
	private String createdBy;
	@Column
	private boolean changePasswordStatus;
	@Column
	private String password;
	@Column
	private String confirmPassword;
	
	
	






	/**
	 * @param userRequestModel
	 */
	public User(UserRequestModel userRequestModel) {
		userName=userRequestModel.getUserName();
		gender=userRequestModel.getGender();
		mobile=userRequestModel.getMobile();
		createdBy=userRequestModel.getCreatedBy();
		password=userRequestModel.getPassword();
		confirmPassword=userRequestModel.getConfirmPassword();
		changePasswordStatus=userRequestModel.getChangePasswordStatus();		
	}
	
	
	
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
	 * @return confirmPassword
	 */
	
	
	/**
	 * 
	 */
	public User() {
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
