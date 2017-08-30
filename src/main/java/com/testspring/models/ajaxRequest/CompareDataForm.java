package com.testspring.models.ajaxRequest;

import java.util.List;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class CompareDataForm {
	
	@JsonView(Views.Public.class)
	private List<String> years;

	public List<String> getYears() {
		return years;
	}

	public void setYears(List<String> years) {
		this.years = years;
	}
	
}
