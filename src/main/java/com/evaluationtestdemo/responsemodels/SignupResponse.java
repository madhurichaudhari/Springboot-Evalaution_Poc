package com.evaluationtestdemo.responsemodels;




/**
 * @author MadhuriC
 *  SignupResponse for getting response for User 
 *
 */
public class SignupResponse {

	private String device_id;

	private String device_type;

	private String user_type;

	private String first_name;

	private String last_name;

	
	
	/**
	 * SignupResponse
	 */
	public SignupResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param device_id
	 * @param device_type
	 * @param user_type
	 * @param first_name
	 * @param last_name
	 */
	public SignupResponse(String device_id, String device_type, String user_type, String first_name, String last_name) {
		super();
		this.device_id = device_id;
		this.device_type = device_type;
		this.user_type = user_type;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	
	/**
	 * @return
	 */
	public String getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return
	 */
	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
}
