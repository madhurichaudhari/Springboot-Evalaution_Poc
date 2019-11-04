package com.evaluationtestdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * @author MadhuriC
 * UserEntity for Creating User Table
 *
 */
@Entity
@Table(name = "users_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	@NotBlank(message = "First Name is mandatory")
	@Column
	private String firstName;
	@Column
	private String last_name;
	@NotBlank(message = "Enter a valid Gender Details")
	@Column
	private String gender;
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true)
	private String email;
	@Size(min = 10, max = 10, message = "Enter the valid phone number")
	@Column
	private String mobile;
	@Column
	private String createdBy;
	@Column
	private String changePasswordStatus;
	@Column
	private String password;
	@Column
	private String otp;
	@Column
	private String isOtpVerified;
	
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
	public String getChangePasswordStatus() {
		return changePasswordStatus;
	}

	/**
	 * @param changePasswordStatus
	 */
	public void setChangePasswordStatus(String changePasswordStatus) {
		this.changePasswordStatus = changePasswordStatus;
	}

	/**
	 * @return
	 */
	public String getIsOtpVerified() {
		return isOtpVerified;
	}

	/**
	 * @param isOtpVerified
	 */
	public void setIsOtpVerified(String isOtpVerified) {
		this.isOtpVerified = isOtpVerified;
	}

	

	/**
	 * @return
	 */
	public String getIs_otp_verified() {
		return isOtpVerified;
	}

	/**
	 * @param is_otp_verified
	 */
	public void setIs_otp_verified(String is_otp_verified) {
		this.isOtpVerified = is_otp_verified;
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
	public User() {
		super();

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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



}
