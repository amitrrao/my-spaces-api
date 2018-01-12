package com.exercise.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sys {
	
	private Type type;
	private String id;
	private Date createdAt;
	private String createdBy;
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
	public void setType(Type type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
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