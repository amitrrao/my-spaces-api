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
 * This is the AssetBuilder class that is responsible for building an Asset instance.
 * 
 */
public class AssetBuilder implements Builder {
	
	private static final Logger logger = LoggerFactory.getLogger(AssetBuilder.class);

	private String title;
	private String contentType;
	private String fileName;
	private String upload;
	
	private Type type = Type.ASSET;
	private String id;
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
	
	public AssetBuilder(String title, String contentType, String fileName, String upload, String id, Date createdAt,
			String createdBy, Date updatedAt, String updatedBy) {
		this.title = title;
		this.contentType = contentType;
		this.fileName = fileName;
		this.upload = upload;
		this.id = id;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}
	
	public Item build() {
		logger.info("Building a new instance of Asset.");
		return new Item(
				new Field.FieldBuilder()
				.withTitle(title)
				.withContentType(contentType)
				.withFileName(fileName)
				.withUpload(upload)
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
