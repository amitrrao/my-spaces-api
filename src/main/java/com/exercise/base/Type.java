package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
	
	SPACE("Space"),
	ENTRY("Entry"),
	ASSET("Asset"),
	USER("User");
	
	Type(String name) {
		this.name = name;
	}
	
	private final String name;
	
	@JsonValue
	public String getType() {
		return name;
	}
}