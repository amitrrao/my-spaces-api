package com.exercise.base;

public enum Type {
	
	SPACE("Space"),
	ENTRY("Entry"),
	ASSET("Asset"),
	USER("User");
	
	Type(String type) {
		this.type = type;
	}
	
	private final String type;
	
	public String getType() {
		return type;
	}
}