package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * This is a Field class representing all possible fields for an Item in our API.
 * 
 * This class also has a static inner class called FieldBuilder that builds a Field instance.
 * Hence, there are only getters for the instance variables.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {
	
	private String title;
	private String description;
	private String summary;
	private String body;
	private String contentType;
	private String fileName;
	private String upload;
	private String name;
	private Role role;
	
	public Field(String nestedTitle, String nestedDescription, String nestedSummary, String nestedBody,
			String nestedContentType, String nestedFileName, String nestedUpload, String nestedName, Role nestedRole) {
		this.title = nestedTitle;
		this.description = nestedDescription;
		this.summary = nestedSummary;
		this.body = nestedBody;
		this.contentType = nestedContentType;
		this.fileName = nestedFileName;
		this.upload = nestedUpload;
		this.name = nestedName;
		this.role = nestedRole;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getSummary() {
		return summary;
	}
	public String getBody() {
		return body;
	}
	public String getContentType() {
		return contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public String getUpload() {
		return upload;
	}
	public Role getRole() {
		return role;
	}
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Static inner class that is responsible for building a Field instance.
	 *
	 */
	public static class FieldBuilder {
		private String nestedTitle;
		private String nestedDescription;
		private String nestedSummary;
		private String nestedBody;
		private String nestedContentType;
		private String nestedFileName;
		private String nestedUpload;
		private String nestedName;
		private Role nestedRole;
		
		public FieldBuilder withTitle(String title) {
			this.nestedTitle = title;
			return this;
		}
		public FieldBuilder withDescription(String description) {
			this.nestedDescription = description;
			return this;
		}
		
		public FieldBuilder withSummary (String summary) {
			this.nestedSummary = summary;
			return this;
		}
		
		public FieldBuilder withBody(String body) {
			this.nestedBody = body;
			return this;
		}
		
		public FieldBuilder withContentType(String contentType) {
			this.nestedContentType = contentType;
			return this;
		}
		
		public FieldBuilder withFileName(String fileName) {
			this.nestedFileName = fileName;
			return this;
		}
		
		public FieldBuilder withUpload(String upload) {
			this.nestedUpload = upload;
			return this;
		}
		
		public FieldBuilder withName(String name) {
			this.nestedName = name;
			return this;
		}
		
		public FieldBuilder withRole(Role role) {
			this.nestedRole = role;
			return this;
		}
		
		public Field build() {
			return new Field(this.nestedTitle, this.nestedDescription, this.nestedSummary, this.nestedBody, this.nestedContentType, this.nestedFileName, this.nestedUpload, this.nestedName, this.nestedRole);
		}
	}
}