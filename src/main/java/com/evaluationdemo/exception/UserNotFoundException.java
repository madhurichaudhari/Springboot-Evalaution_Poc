package com.evaluationdemo.exception;

/**
 * @author MadhuriC
 * 
 *  Created UserNotFoundException  for handing repository exception if user not found
 *
 */
public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	/**
	 * @param exception
	 */
	
	public UserNotFoundException() {
	    super();
	  }
	/**
	 * @param exception
	 */
	public UserNotFoundException(String exception) {
	    super(exception);
	  }

	}
