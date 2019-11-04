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
 * AdminEntity for Creating Admin Table
 *
 */
@Entity
@Table(name = "admin_tbl")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@NotBlank(message = "First Name is mandatory")
	@Column
	private String firstName;

	@NotBlank(message = "Last Name is mandatory")
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


	
	
	public Admin() {
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
