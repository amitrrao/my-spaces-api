package com.exercise.item;

import java.util.Date;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;

public class AssetBuilder {

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
	
	public Item createAssetItem() {
		return new Item(
				new Field.FieldBuilder(title)
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
