package com.setup.exceptions;

public class UserNameExistsException extends RuntimeException{
	private static final long serialVersionUID = 2L;

	public UserNameExistsException() {
		super("Username Already Exists");
	}
	

}