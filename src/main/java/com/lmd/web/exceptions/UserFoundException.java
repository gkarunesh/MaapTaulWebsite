package com.lmd.web.exceptions;

public class UserFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserFoundException() {
		super("User with this username is already present");
	}
	public UserFoundException(String msg) {super (msg);}

}
