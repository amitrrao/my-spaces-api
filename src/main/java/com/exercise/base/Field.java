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
	
//	public Field(String title, String description) {
//		this.title = title;
//		this.description = description;
//	}
//	public Field(String title, String summary, String body) {
//		this.title = title;
//		this.summary = summary;
//		this.body = body;
//	}
//	public Field(String title, String contentType, String fileName, String upload) {
//		this.title = title;
//		this.contentType = contentType;
//		this.fileName = fileName;
//		this.upload = upload;
//	}
	
	public Field(String nestedTitle, String nestedDescription, String nestedSummary, String nestedBody,
			String nestedContentType, String nestedFileName, String nestedUpload) {
		this.title = nestedTitle;
		this.description = nestedDescription;
		this.summary = nestedSummary;
		this.body = nestedBody;
		this.contentType = nestedContentType;
		this.fileName = nestedFileName;
		this.upload = nestedUpload;
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
	
	public static class FieldBuilder {
		private String nestedTitle;
		private String nestedDescription;
		private String nestedSummary;
		private String nestedBody;
		private String nestedContentType;
		private String nestedFileName;
		private String nestedUpload;
		
		public FieldBuilder(String title) {
			this.nestedTitle= title;
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
		
		public Field build() {
			return new Field(this.nestedTitle, this.nestedDescription, this.nestedSummary, this.nestedBody, this.nestedContentType, this.nestedFileName, this.nestedUpload);
		}
	}
}