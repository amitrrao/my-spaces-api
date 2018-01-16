package com.exercise.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * This is a Sys class, that contains meta data for an Item in our API.
 *
 * This class also has a static inner class called SysBuilder that builds a Sys instance.
 * Hence, this class contains only getters for the instance variables.
 * 
 * @author arao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sys {
	
	private Type type;
	private String id;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date createdAt;
	private String createdBy;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date updatedAt;
	private String updatedBy;
	
	public Sys(Type type, String id, Date createdAt, String createdBy, Date updatedAt, String updatedBy) {
		this.type = type;
		this.id = id;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}
	
	public Sys(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	public String getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * 
	 * Static inner class that is responsible for building a Sys instance.
	 *
	 */
	public static class SysBuilder {
		private Type nestedType;
		private String nestedId;
		private String nestedCreatedBy;
		private Date nestedCreatedAt;
		private Date nestedUpdatedAt;
		private String nestedUpdatedBy;
		
		public SysBuilder(Type type) {
			this.nestedType = type;
		}
		
		public SysBuilder withId(String id) {
			this.nestedId = id;
			return this;
		}
		
		public SysBuilder withCreatedBy(String createdBy) {
			this.nestedCreatedBy = createdBy;
			return this;
		}
		
		public SysBuilder withCreatedAt(Date createdAt) {
			this.nestedCreatedAt = createdAt;
			return this;
		}
		
		public SysBuilder withUpdatedBy(String updatedBy) {
			this.nestedUpdatedBy = updatedBy;
			return this;
		}
		
		public SysBuilder withUpatedAt(Date updatedAt) {
			this.nestedUpdatedAt = updatedAt;
			return this;
		}
		
		public Sys build() {
			return new Sys(this.nestedType, this.nestedId, this.nestedCreatedAt, this.nestedCreatedBy, this.nestedUpdatedAt, this.nestedUpdatedBy);
		}
	}
	
}