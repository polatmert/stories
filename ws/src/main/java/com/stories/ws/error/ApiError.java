package com.stories.ws.error;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.stories.ws.shared.Views;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
	
	@JsonView(Views.Base.class)
	private int status;
	
	@JsonView(Views.Base.class)
	private String message;

	@JsonView(Views.Base.class)
	private String path;
	
	@JsonView(Views.Base.class) 
	private long timestamp = new Date().getTime();
	
	private Map<String , String> validationErrors;
	
	public ApiError(int status , String message , String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public ApiError(int status, String message, String path, long timestamp, Map<String, String> validationErrors) {
		this.status = status;
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
		this.validationErrors = validationErrors;
	}

	public ApiError(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}