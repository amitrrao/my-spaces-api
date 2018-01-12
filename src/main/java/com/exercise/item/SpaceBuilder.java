package com.exercise.item;

import java.util.Date;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;

public class SpaceBuilder {
	private String title;
	private String description;
	
	private Type type = Type.SPACE;
	private String id;
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
	
	public SpaceBuilder(String title, String description, String id, Date createdAt, String createdBy,
			Date updatedAt, String updatedBy) {
		this.title = title;
		this.description = description;
		this.id = id;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}
	
	public Item createSpaceItem() {
		return new Item(
				new Field.FieldBuilder(title)
				.withDescription(description)
				.build(), 
				
				new Sys.SysBuilder(type)
				.withId(id)
				.withId(createdBy)
				.withCreatedAt(createdAt)
				.withUpdatedBy(updatedBy)
				.withUpatedAt(updatedAt)
				.build());
	}
}
