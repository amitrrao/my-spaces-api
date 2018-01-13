package com.exercise.builder;

import java.util.Date;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;
import com.exercise.item.Item;

/**
 * 
 * This is the EntryBuilder class that is responsible for building an Entry instance.
 *
 */
public class EntryBuilder implements Builder {

	private String title;
	private String summary;
	private String body;

	private Type type = Type.ENTRY;
	private String id;
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
	
	public EntryBuilder(String title, String summary, String body, String id, Date createdAt, String createdBy,
			Date updatedAt, String updatedBy) {
		super();
		this.title = title;
		this.summary = summary;
		this.body = body;
		this.id = id;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}
	
	public Item build() {
		return new Item(
				new Field.FieldBuilder()
				.withTitle(title)
				.withSummary(summary)
				.withBody(body)
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
