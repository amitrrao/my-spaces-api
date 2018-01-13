package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 * Role is an enum representing all possible roles for a 'User'.
 *
 */
public enum Role {
	
	AUTHOR("Author"),
	EDITOR("Editor");
	
	private final String role;
	
	Role(String role) {
		this.role = role;
	}
	
	@JsonValue
	public String getRole() {
		return role;
	}
}