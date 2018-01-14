package com.exercise.builder;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;
import com.exercise.item.Item;

/**
 * 
 * This is the SpaceBuilder class that is responsible for building an Space instance.
 *
 */
public class SpaceBuilder implements Builder{
	
	private static final Logger logger = LoggerFactory.getLogger(SpaceBuilder.class);
	
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
	
	public Item build() {
		logger.info("Building a new instance of Space.");
		return new Item(
				new Field.FieldBuilder()
				.withTitle(title)
				.withDescription(description)
				.build(), 
				
				new Sys.SysBuilder(type)
				.withId(id)
				.withCreatedBy(createdBy)
				.withCreatedAt(createdAt)
				.withUpdatedBy(updatedBy)
				.withUpatedAt(updatedAt)
				.build());
	}
}
