package com.example.crud.beans.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileInformationRequest {
	@JsonProperty
	private String directory;
	@JsonProperty
	private String fileName;
	
	
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
