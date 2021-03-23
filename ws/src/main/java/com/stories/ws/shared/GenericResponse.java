package com.stories.ws.shared;

import lombok.Data;

@Data
public class GenericResponse {

	private String message;

    public GenericResponse(String user_created) {
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
