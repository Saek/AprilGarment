package com.testspring.models.ajaxResponse;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class ClothDropDownList {
	
	@JsonView(Views.Public.class)
	private int clothId;
	@JsonView(Views.Public.class)
	private String model;
	
	public int getClothId() {
		return clothId;
	}
	public void setClothId(int clothId) {
		this.clothId = clothId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
		
}
