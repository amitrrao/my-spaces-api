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
	
	public Field(String title, String description) {
		this.title = title;
		this.description = description;
	}
	public Field(String title, String summary, String body) {
		this.title = title;
		this.summary = summary;
		this.body = body;
	}
	public Field(String title, String contentType, String fileName, String upload) {
		this.title = title;
		this.contentType = contentType;
		this.fileName = fileName;
		this.upload = upload;
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
}