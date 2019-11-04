package com.evaluationtestdemo.requestmodels;




/**
 * @author MadhuriC
 * 
 *  EmailRequestModel for Sending Email 
 *
 */
public class EmailRequestModel {
	
	private String email_to;
	private String subject;
	private String message;
	public String getEmail_to() {
		return email_to;
	}

	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmailRequestModel(String email_to, String subject, String message) {
		super();
		this.email_to = email_to;
		this.subject = subject;
		this.message = message;
	}
	
	
	

}
