package com.exercise.builder;

import com.exercise.base.Field;
import com.exercise.base.Role;
import com.exercise.base.Sys;
import com.exercise.base.Type;
import com.exercise.item.Item;

/**
 * 
 * This is the UserBuilder class that is responsible for building an User instance.
 *
 */
public class UserBuilder implements Builder {
	
	private Type type = Type.USER;
	private String name;
	private Role role;
	private String id;
	
	public UserBuilder(String name, String id, Role role) {
		this.name = name;
		this.id = id;
		this.role = role;
	}
	
	public Item build() {
		return new Item(
				new Field.FieldBuilder()
				.withName(name)
				.withRole(role)
				.build(),
				
				new Sys.SysBuilder(type)
				.withId(id).build());
	}
}
