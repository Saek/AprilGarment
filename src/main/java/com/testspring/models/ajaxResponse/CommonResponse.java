package com.testspring.models.ajaxResponse;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class CommonResponse {
	@JsonView(Views.Public.class)
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
