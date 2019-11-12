package com.evaluationdemo.validator;

/**
 * @author MadhuriC
 * 
 *  Created UserNotFoundException  for handing repository exception if user not found
 *
 */
public class UserNotFoundException extends RuntimeException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param exception
	 */
	
	public UserNotFoundException(String exception) {
	    super(exception);
	  }

	}
