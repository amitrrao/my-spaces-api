package com.exercise.exceptions;

@SuppressWarnings("serial")
public class ItemNotFoundException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public ItemNotFoundException(String message) {
		this.message = message;
	}
	
	public String generateMessage(String message) {
		return message;
	}
}
