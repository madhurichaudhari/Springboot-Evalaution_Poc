package com.evaluationdemo.validator;

/**
 * @author MadhuriC
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
