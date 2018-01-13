package com.exercise.base;

import com.fasterxml.jackson.annotation.JsonInclude;

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
		this.setName(nestedName);
		this.role = nestedRole;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

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