package com.example.crud.beans.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileInformationRequest {

	@JsonProperty
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
