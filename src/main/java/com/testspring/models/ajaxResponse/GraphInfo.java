package com.testspring.models.ajaxResponse;

import java.util.List;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class GraphInfo {
	@JsonView(Views.Public.class)
	private String label;
	@JsonView(Views.Public.class)
	private List<Integer> data;
	
	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
