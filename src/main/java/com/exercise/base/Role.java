package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonValue;

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