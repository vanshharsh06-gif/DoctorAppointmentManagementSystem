package com.patientservice.model;

import java.time.LocalDateTime;

public class ErrorResponse {

	private	LocalDateTime timestamp;
	
	private String message;
	
	private String path;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ErrorResponse(String message, String path) {
		this.timestamp=LocalDateTime.now();
		this.message = message;
		this.path = path;
	}
}