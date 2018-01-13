package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
	
	SPACE("Space"),
	ENTRY("Entry"),
	ASSET("Asset"),
	USER("User");
	
	private final String type;
	
	Type(String type) {
		this.type = type;
	}
	
	@JsonValue
	public String getType() {
		return type;
	}
}