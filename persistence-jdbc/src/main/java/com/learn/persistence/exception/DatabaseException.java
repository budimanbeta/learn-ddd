package com.learn.persistence.exception;

public class DatabaseException extends Exception {
	private static final long serialVersionUID = -6018681026026989588L;

	public DatabaseException() {
		super();
	}
	
	public DatabaseException(String message) {
		super(message);
	}
}
